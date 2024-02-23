package com.github.rinotc.springrestsample.controllers.boundedcontexts

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.rinotc.springrestsample.usecases.CreateBoundedContextOutput
import com.github.rinotc.springrestsample.usecases.CreateBoundedContextUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("/bounded-contexts")
class BoundedContextController(
    private val createUseCase: CreateBoundedContextUseCase
) {

    @PostMapping("/")
    fun post(@RequestBody body: CreateBoundedContextRequest): ResponseEntity<Any> {
        return when (val r = body.validated()) {
            is Err -> {
                println("invalid input")
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    mapOf(
                        "message" to r.error
                    )
                )
            }
            is Ok -> {
                when (val o = createUseCase.handle(r.value)) {
                    is CreateBoundedContextOutput.AliasIsNotUnique ->
                        ResponseEntity.status(HttpStatus.CONFLICT).body(
                            mapOf(
                                "message" to "${o.alias.value} is already exists."
                            )
                        )

                    is CreateBoundedContextOutput.Success -> {
                        val location = ServletUriComponentsBuilder
                            .fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(o.boundedContext.id.value.toString())
                            .toUri()

                        ResponseEntity.created(location).body(BoundedContextResponse(o.boundedContext))
                    }
                }
            }
        }
    }
}
package com.github.rinotc.springrestsample.controllers.boundedcontexts.get

import com.github.rinotc.springrestsample.controllers.boundedcontexts.BoundedContextResponse
import com.github.rinotc.springrestsample.core.boundedcontext.BoundedContextId
import com.github.rinotc.springrestsample.usecases.boundedcontexts.get.GetBoundedContextInput
import com.github.rinotc.springrestsample.usecases.boundedcontexts.get.GetBoundedContextOutput
import com.github.rinotc.springrestsample.usecases.boundedcontexts.get.GetBoundedContextUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/bounded-contexts")
class GetBoundedContextController(
    private val getUseCase: GetBoundedContextUseCase
) {
    @GetMapping("/{id}")
    fun action(@PathVariable id: String): ResponseEntity<Any> {
        val boundedContextId = BoundedContextId.of(id)
        val input = GetBoundedContextInput(boundedContextId)
        return when (val o = getUseCase.handle(input)) {
            is GetBoundedContextOutput.Success -> {
                val response = BoundedContextResponse(o.boundedContext)
                ResponseEntity.ok(response)
            }

            is GetBoundedContextOutput.NotFound -> {
                ResponseEntity.notFound().build()
            }
        }
    }
}
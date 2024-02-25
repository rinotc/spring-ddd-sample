package com.github.rinotc.springrestsample.controllers.boundedcontexts.list

import com.github.rinotc.springrestsample.controllers.boundedcontexts.BoundedContextResponse
import com.github.rinotc.springrestsample.usecases.boundedcontexts.list.ListBoundedContextsInput
import com.github.rinotc.springrestsample.usecases.boundedcontexts.list.ListBoundedContextsOutput
import com.github.rinotc.springrestsample.usecases.boundedcontexts.list.ListBoundedContextsUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/bounded-contexts")
class ListBoundedContextsController(
    private val  listUseCase: ListBoundedContextsUseCase
) {

    @GetMapping("")
    fun action(): ResponseEntity<List<BoundedContextResponse>> {
        return when (val o = listUseCase.handle(ListBoundedContextsInput)) {
            is ListBoundedContextsOutput.Success -> {
                val response = o.boundedContexts.map(::BoundedContextResponse)
                ResponseEntity.ok(response)
            }
        }
    }
}
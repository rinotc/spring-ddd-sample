package com.github.rinotc.springrestsample.controllers.boundedcontexts.delete

import com.github.rinotc.springrestsample.core.boundedcontext.BoundedContextId
import com.github.rinotc.springrestsample.usecases.boundedcontexts.delete.DeleteBoundedContextInput
import com.github.rinotc.springrestsample.usecases.boundedcontexts.delete.DeleteBoundedContextOutput
import com.github.rinotc.springrestsample.usecases.boundedcontexts.delete.DeleteBoundedContextUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/bounded-contexts")
class DeleteBoundedContextController(
    private val deleteUseCase: DeleteBoundedContextUseCase
) {

    @DeleteMapping("/{id}")
    fun action(@PathVariable id: String): ResponseEntity<Any> {
        try {
            val boundedContextId = BoundedContextId.of(id)
            val input = DeleteBoundedContextInput(boundedContextId)
            return when (val o = deleteUseCase.handle(input)) {
                is DeleteBoundedContextOutput.Success -> {
                    ResponseEntity.noContent().build()
                }
                is DeleteBoundedContextOutput.NotFound -> {
                    ResponseEntity.notFound().build()
                }
            }
        } catch (e: IllegalArgumentException) {
            return ResponseEntity.badRequest().body(
                mapOf(
                    "message" to "invalid UUID format"
                )
            )
        }
    }
}
package com.github.rinotc.springrestsample.usecases.boundedcontexts.delete

import com.github.rinotc.springrestsample.core.boundedcontext.BoundedContextId
import com.github.rinotc.springrestsample.core.boundedcontext.BoundedContextRepository
import com.github.rinotc.springrestsample.libs.usecase.Input
import com.github.rinotc.springrestsample.libs.usecase.Output
import com.github.rinotc.springrestsample.libs.usecase.UseCase
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class DeleteBoundedContextUseCase(
    private val boundedContextRepository: BoundedContextRepository
) : UseCase<DeleteBoundedContextInput, DeleteBoundedContextOutput>{
    override fun handle(input: DeleteBoundedContextInput): DeleteBoundedContextOutput {
        val boundedContext = boundedContextRepository.findById(input.id)
        return if (boundedContext != null) {
            boundedContextRepository.delete(boundedContext)
            DeleteBoundedContextOutput.Success(boundedContext.id)
        } else {
            DeleteBoundedContextOutput.NotFound(input.id)
        }
    }
}

data class DeleteBoundedContextInput(
    val id: BoundedContextId
) : Input<DeleteBoundedContextOutput>

sealed class DeleteBoundedContextOutput: Output {
    data class Success(val id: BoundedContextId) : DeleteBoundedContextOutput()
    data class NotFound(val id: BoundedContextId) : DeleteBoundedContextOutput()
}
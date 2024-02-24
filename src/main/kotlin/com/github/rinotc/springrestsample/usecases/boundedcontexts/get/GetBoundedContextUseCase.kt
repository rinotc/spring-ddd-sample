package com.github.rinotc.springrestsample.usecases.boundedcontexts.get

import com.github.rinotc.springrestsample.core.boundedcontext.BoundedContext
import com.github.rinotc.springrestsample.core.boundedcontext.BoundedContextId
import com.github.rinotc.springrestsample.core.boundedcontext.BoundedContextRepository
import com.github.rinotc.springrestsample.libs.usecase.Input
import com.github.rinotc.springrestsample.libs.usecase.Output
import com.github.rinotc.springrestsample.libs.usecase.UseCase
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@Service
class GetBoundedContextUseCase (
    private val boundedContextRepository: BoundedContextRepository
): UseCase<GetBoundedContextInput, GetBoundedContextOutput> {
    override fun handle(input: GetBoundedContextInput): GetBoundedContextOutput {
        val boundedContext = boundedContextRepository.findById(input.id)
        return if (boundedContext != null) {
            GetBoundedContextOutput.Success(boundedContext)
        } else {
            GetBoundedContextOutput.NotFound(input.id)
        }
    }
}

data class GetBoundedContextInput(
    val id: BoundedContextId
) : Input<GetBoundedContextOutput>

sealed class GetBoundedContextOutput: Output {
    data class Success(val boundedContext: BoundedContext) : GetBoundedContextOutput()
    data class NotFound(val id: BoundedContextId) : GetBoundedContextOutput()
}

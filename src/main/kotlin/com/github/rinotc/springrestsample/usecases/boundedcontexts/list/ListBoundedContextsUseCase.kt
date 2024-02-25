package com.github.rinotc.springrestsample.usecases.boundedcontexts.list

import com.github.rinotc.springrestsample.core.boundedcontext.BoundedContext
import com.github.rinotc.springrestsample.core.boundedcontext.BoundedContextRepository
import com.github.rinotc.springrestsample.libs.usecase.Input
import com.github.rinotc.springrestsample.libs.usecase.Output
import com.github.rinotc.springrestsample.libs.usecase.UseCase
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class ListBoundedContextsUseCase(
    private val boundedContextsRepository: BoundedContextRepository
) : UseCase<ListBoundedContextsInput, ListBoundedContextsOutput> {

    override fun handle(input: ListBoundedContextsInput): ListBoundedContextsOutput {
        val boundedContexts = boundedContextsRepository.findAll()
        return ListBoundedContextsOutput.Success(boundedContexts)
    }
}

data object ListBoundedContextsInput : Input<ListBoundedContextsOutput>

sealed class ListBoundedContextsOutput : Output {
    data class Success(val boundedContexts: List<BoundedContext>) : ListBoundedContextsOutput()
}

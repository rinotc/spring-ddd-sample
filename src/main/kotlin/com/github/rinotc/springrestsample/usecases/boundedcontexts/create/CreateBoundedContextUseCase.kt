package com.github.rinotc.springrestsample.usecases.boundedcontexts.create

import com.github.michaelbull.result.*
import com.github.rinotc.springrestsample.core.boundedcontext.*
import com.github.rinotc.springrestsample.libs.usecase.Input
import com.github.rinotc.springrestsample.libs.usecase.Output
import com.github.rinotc.springrestsample.libs.usecase.UseCase
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class CreateBoundedContextUseCase(
    private val boundedContextSpec: BoundedContextSpec,
    private val boundedContextRepository: BoundedContextRepository
) : UseCase<CreateBoundedContextInput, CreateBoundedContextOutput> {

    override fun handle(input: CreateBoundedContextInput): CreateBoundedContextOutput {
        val createValues = BoundedContext.Companion.CreateValues(
            input.alias,
            input.name,
            input.overview
        )
        val result = binding {
            val canCreateMessage = boundedContextSpec.canCreate(createValues)
                .mapError { CreateBoundedContextOutput.AliasIsNotUnique(input.alias) }
                .bind()
            val boundedContext = BoundedContext.create(canCreateMessage)
            boundedContextRepository.insert(boundedContext)
            CreateBoundedContextOutput.Success(boundedContext)
        }
        return result.merge()
    }
}

data class CreateBoundedContextInput(
    val alias: BoundedContextAlias,
    val name: BoundedContextName,
    val overview: BoundedContextOverview
) : Input<CreateBoundedContextOutput>

sealed class CreateBoundedContextOutput : Output {
    data class Success(val boundedContext: BoundedContext) : CreateBoundedContextOutput()
    data class AliasIsNotUnique(val alias: BoundedContextAlias) : CreateBoundedContextOutput()
}
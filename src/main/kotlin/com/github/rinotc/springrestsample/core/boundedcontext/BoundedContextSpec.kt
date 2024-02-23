package com.github.rinotc.springrestsample.core.boundedcontext

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result

interface BoundedContextSpec {

    fun canCreate(value: BoundedContext.Companion.CreateValues): Result<CanCreateMessage, Because> {
        if (!isAliasUnique(value.alias)) return Err(Because.AliasIsNotUnique)
        return Ok(CanCreateMessage(value))
    }

    companion object {
        data class CanCreateMessage(val value: BoundedContext.Companion.CreateValues)
        sealed class Because {
            data object AliasIsNotUnique : Because()
        }
    }

    fun isAliasUnique(value: BoundedContextAlias): Boolean
}
package com.github.rinotc.springrestsample.core.boundedcontext

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import com.github.michaelbull.result.map
import com.github.rinotc.springrestsample.libs.ddd.ValueObject

data class BoundedContextOverview(val value: String) : ValueObject {
    init {
        invariant(requirements(value))
    }

    companion object {

        fun validate(value: String): Result<BoundedContextOverview, String> {
            return requirements(value).map { BoundedContextOverview(value) }
        }

        private const val MAX_LENGTH = 500
        private fun requirements(value: String): Result<Unit, String> {
            if (value.length > MAX_LENGTH) return Err("BoundedContextOverview must be less than $MAX_LENGTH characters")
            return Ok(Unit)
        }
    }
}
package com.github.rinotc.springrestsample.core.boundedcontext

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.rinotc.springrestsample.libs.ddd.ValueObject
import com.github.michaelbull.result.Result
import com.github.michaelbull.result.map

data class BoundedContextName(val value: String): ValueObject {
    init {
        invariant(requirements(value))
    }

    companion object {
        fun validate(value: String): Result<BoundedContextName, String> {
            return requirements(value).map { BoundedContextName(value) }
        }

        private const val MAX_LENGTH = 100
        private fun requirements(value: String): Result<Unit, String> {
            if (value.isEmpty()) return Err("BoundedContextName must not be empty")
            if (value.length > MAX_LENGTH) return Err("BoundedContextName must be less than $MAX_LENGTH characters")
            return Ok(Unit)
        }
    }
}

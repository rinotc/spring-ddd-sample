package com.github.rinotc.springrestsample.core.boundedcontext

import com.github.michaelbull.result.*
import com.github.rinotc.springrestsample.libs.ddd.ValueObject

data class BoundedContextAlias(val value: String) : ValueObject {

    init {
        invariant(requirements(value))
    }

    companion object {

        private const val MAX_LENGTH = 32

        fun validate(value: String): Result<BoundedContextAlias, String> =
            requirements(value).map { BoundedContextAlias(value) }


        private fun requirements(value: String): Result<Unit, String> {
            value.let {
                if (it.isEmpty()) return Err("BoundedContextAlias must not be empty")
                if (it.length > MAX_LENGTH) return Err("BoundedContextAlias must be less than $MAX_LENGTH characters")
                if (it.matches(Regex("^[a-zA-Z0-9]*$")).not()) return Err("BoundedContextAlias must be only alphanumeric")
                return Ok(Unit)
            }
        }
    }
}

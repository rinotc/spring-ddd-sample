package com.github.rinotc.springrestsample.core.boundedcontext

import com.github.rinotc.springrestsample.libs.ddd.ValueObject

data class BoundedContextName(val value: String): ValueObject {
    init {
        invariant(requirements(value))
    }
    companion object {
        fun validate(value: String): Result<BoundedContextName> {
            return requirements(value).map { BoundedContextName(value) }
        }

        private const val MAX_LENGTH = 100
        private fun requirements(value: String): Result<Unit> {
            return runCatching {
                mustNotEmpty(value)
                mustLessThanMaxLength(value)
            }
        }
        private fun mustNotEmpty(value: String) {
            require(value.isNotEmpty()) { "BoundedContextName must not be empty" }
        }
        private fun mustLessThanMaxLength(value: String) {
            require(value.length <= MAX_LENGTH) { "BoundedContextName must be less than $MAX_LENGTH characters" }
        }


    }
}

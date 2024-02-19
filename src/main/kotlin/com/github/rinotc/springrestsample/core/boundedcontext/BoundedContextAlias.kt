package com.github.rinotc.springrestsample.core.boundedcontext

import com.github.rinotc.springrestsample.libs.ddd.ValueObject

data class BoundedContextAlias(val value: String): ValueObject {

    init {
        invariant(requirements(value))
    }

    companion object {

        fun validate(value: String): Result<BoundedContextAlias> {
            return requirements(value).map { BoundedContextAlias(value) }
        }

        private const val MAX_LENGTH = 32
        private fun requirements(value: String): Result<Unit> {
            return runCatching {
                mustNotEmpty(value)
                mustLessThan32Length(value)
                mustOnlyAlphanumeric(value)
            }
        }
        private fun mustNotEmpty(value: String) {
            require(value.isNotEmpty()) { "BoundedContextAlias must not be empty" }
        }

        private fun mustLessThan32Length(value: String) {
            require(value.length <= MAX_LENGTH) { "BoundedContextAlias must be less than $MAX_LENGTH characters" }
        }

        private fun mustOnlyAlphanumeric(value: String) {
            require(value.matches(Regex("^[a-zA-Z0-9]*$"))) { "BoundedContextAlias must be only alphanumeric" }
        }
    }
}

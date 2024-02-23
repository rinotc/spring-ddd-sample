package com.github.rinotc.springrestsample.libs.ddd

import arrow.core.Either
import com.github.michaelbull.result.Result
import com.github.michaelbull.result.getOrElse

interface AssertionConcerns {

    fun invariant(vararg es: Either<String, Unit>) {
        es.forEach {
            when (it) {
                is Either.Left<String> -> throw IllegalArgumentException("requirement failed ${it.value}")
                is Either.Right<Unit> -> {}
            }
        }
    }

    fun invariant(r: Result<Unit, String>) {
        r.getOrElse { throw IllegalArgumentException("requirement failed: $it") }
    }
}
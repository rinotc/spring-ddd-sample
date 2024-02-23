package com.github.rinotc.springrestsample.libs.functional

import arrow.core.Either
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result

interface Functional {
    companion object {
        fun <L, R> Either<L, R>.toResult(): Result<R, L> {
            return when (this) {
                is Either.Left<L> -> Err(this.value)
                is Either.Right<R> -> Ok(this.value)
            }
        }

        fun <V, E> Result<V, E>.toEither(): Either<E, V> {
            return when (this) {
                is Ok<V> -> Either.Right(this.value)
                is Err<E> -> Either.Left(this.error)
            }
        }
    }
}
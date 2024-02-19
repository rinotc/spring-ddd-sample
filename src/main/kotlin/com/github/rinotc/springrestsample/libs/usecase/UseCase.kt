package com.github.rinotc.springrestsample.libs.usecase

interface UseCase<I: Input<O>, O: Output> {

    fun handle(input: I): O
}
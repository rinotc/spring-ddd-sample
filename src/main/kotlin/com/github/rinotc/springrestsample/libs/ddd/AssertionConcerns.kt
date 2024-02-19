package com.github.rinotc.springrestsample.libs.ddd

interface AssertionConcerns {

    fun invariant(r: Result<Unit>) {
        r.getOrElse { throw IllegalArgumentException("requirement failed: $it") }
    }
}
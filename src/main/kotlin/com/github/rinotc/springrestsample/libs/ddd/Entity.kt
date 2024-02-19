package com.github.rinotc.springrestsample.libs.ddd

interface Entity<ID : EntityId> : AssertionConcerns {
    val id: ID
}
package com.github.rinotc.springrestsample.libs.ddd

import com.github.rinotc.springrestsample.libs.functional.Functional

interface Entity<ID : EntityId> : AssertionConcerns, Functional {
    val id: ID
}
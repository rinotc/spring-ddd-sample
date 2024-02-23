package com.github.rinotc.springrestsample.core.boundedcontext

import com.github.rinotc.springrestsample.libs.ddd.Repository

interface BoundedContextRepository: Repository<BoundedContext> {

    fun findById(id: BoundedContextId): BoundedContext?

    fun insert(entity: BoundedContext): Unit

    fun update(entity: BoundedContext): Unit

    fun delete(entity: BoundedContext): Unit
}
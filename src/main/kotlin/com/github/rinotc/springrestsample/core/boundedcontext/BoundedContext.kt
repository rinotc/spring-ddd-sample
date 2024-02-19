package com.github.rinotc.springrestsample.core.boundedcontext

import com.github.rinotc.springrestsample.libs.ddd.Entity
import com.github.rinotc.springrestsample.libs.ddd.EntityId
import java.util.UUID

data class BoundedContextId(override val value: UUID): EntityId

class BoundedContext private constructor(
    override val id: BoundedContextId,
    val alias: BoundedContextAlias,
): Entity<BoundedContextId> {
}
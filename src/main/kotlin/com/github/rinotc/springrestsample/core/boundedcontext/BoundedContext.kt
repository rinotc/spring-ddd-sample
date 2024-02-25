package com.github.rinotc.springrestsample.core.boundedcontext

import com.github.rinotc.springrestsample.libs.ddd.Aggregate
import com.github.rinotc.springrestsample.libs.ddd.Entity
import com.github.rinotc.springrestsample.libs.ddd.EntityId
import java.util.*

data class BoundedContextId(override val value: UUID) : EntityId {
    companion object {
        fun of(value: String): BoundedContextId = BoundedContextId(UUID.fromString(value))
    }
}

class BoundedContext private constructor(
    override val id: BoundedContextId,
    val alias: BoundedContextAlias,
    val name: BoundedContextName,
    val overview: BoundedContextOverview,
) : Entity<BoundedContextId>, Aggregate {


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as BoundedContext
        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return "BoundedContext(id=${id.value}, alias=${alias.value}, name=${name.value}, overview=${overview.value})"
    }


    companion object {
        fun reconstruct(
            id: BoundedContextId,
            alias: BoundedContextAlias,
            name: BoundedContextName,
            overview: BoundedContextOverview
        ): BoundedContext {
            return BoundedContext(id, alias, name, overview)
        }

        fun create(message: BoundedContextSpec.Companion.CanCreateMessage): BoundedContext {
            return BoundedContext(
                BoundedContextId(UUID.randomUUID()),
                message.value.alias,
                message.value.name,
                message.value.overview
            )
        }

        data class CreateValues(val alias: BoundedContextAlias, val name: BoundedContextName, val overview: BoundedContextOverview)
    }
}
package com.github.rinotc.springrestsample.infra.boundedcontext

import com.github.rinotc.springrestsample.core.boundedcontext.*
import com.github.rinotc.springrestsample.infra.generated.jooq.tables.BoundedContexts
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Suppress("PrivatePropertyName")
@Repository
class JdbcBoundedContextRepository(private val dslContext: DSLContext): BoundedContextRepository {

    private val BOUNDED_CONTEXTS = BoundedContexts.BOUNDED_CONTEXTS

    override fun findById(id: BoundedContextId): BoundedContext? {
        return this.dslContext.select()
            .from(BOUNDED_CONTEXTS)
            .where(BOUNDED_CONTEXTS.BOUNDED_CONTEXT_ID.eq(id.value.toString()))
            .fetchOne()?.map {
                BoundedContext.reconstruct(
                    BoundedContextId.of(it[BOUNDED_CONTEXTS.BOUNDED_CONTEXT_ID]!!),
                    BoundedContextAlias(it[BOUNDED_CONTEXTS.BOUNDED_CONTEXT_ALIAS]!!),
                    BoundedContextName(it[BOUNDED_CONTEXTS.BOUNDED_CONTEXT_NAME]!!),
                    BoundedContextOverview(it[BOUNDED_CONTEXTS.BOUNDED_CONTEXT_OVERVIEW]!!)
                )
            }
    }

    override fun insert(entity: BoundedContext) {
        this.dslContext.insertInto(BOUNDED_CONTEXTS)
            .set(BOUNDED_CONTEXTS.BOUNDED_CONTEXT_ID, entity.id.value.toString())
            .set(BOUNDED_CONTEXTS.BOUNDED_CONTEXT_ALIAS, entity.alias.value)
            .set(BOUNDED_CONTEXTS.BOUNDED_CONTEXT_NAME, entity.name.value)
            .set(BOUNDED_CONTEXTS.BOUNDED_CONTEXT_OVERVIEW, entity.overview.value)
            .execute()
    }

    override fun update(entity: BoundedContext) {
        this.dslContext.update(BOUNDED_CONTEXTS)
            .set(BOUNDED_CONTEXTS.BOUNDED_CONTEXT_ALIAS, entity.alias.value)
            .set(BOUNDED_CONTEXTS.BOUNDED_CONTEXT_NAME, entity.name.value)
            .set(BOUNDED_CONTEXTS.BOUNDED_CONTEXT_OVERVIEW, entity.overview.value)
            .where(BOUNDED_CONTEXTS.BOUNDED_CONTEXT_ID.eq(entity.id.value.toString()))
            .execute()
    }

    override fun delete(entity: BoundedContext) {
        this.dslContext.deleteFrom(BOUNDED_CONTEXTS)
            .where(BOUNDED_CONTEXTS.BOUNDED_CONTEXT_ID.eq(entity.id.value.toString()))
            .execute()
    }
}
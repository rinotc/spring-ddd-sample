package com.github.rinotc.springrestsample.infra.boundedcontext

import com.github.rinotc.springrestsample.core.boundedcontext.BoundedContextAlias
import com.github.rinotc.springrestsample.core.boundedcontext.BoundedContextSpec
import com.github.rinotc.springrestsample.infra.generated.jooq.tables.BoundedContexts
import org.jooq.DSLContext
import org.jooq.impl.DSL
import org.springframework.stereotype.Repository

@Repository
class JdbcBoundedContextSpec(private val dslContext: DSLContext): BoundedContextSpec {
    private val BOUNDED_CONTEXTS = BoundedContexts.BOUNDED_CONTEXTS
    override fun isAliasUnique(value: BoundedContextAlias): Boolean {
        val count = this.dslContext.select(DSL.count())
            .from(BOUNDED_CONTEXTS)
            .where(BOUNDED_CONTEXTS.BOUNDED_CONTEXT_ALIAS.eq(value.value))
            .fetchOne(1, Int::class.java)!!
        return count == 0
    }
}
package com.github.rinotc.springrestsample.controllers.boundedcontexts

import com.github.rinotc.springrestsample.core.boundedcontext.BoundedContext

data class BoundedContextResponse(private val entity: BoundedContext) {
    val id: String = entity.id.value.toString()
    val alias: String = entity.alias.value
    val name: String = entity.name.value
    val overview: String = entity.overview.value
}
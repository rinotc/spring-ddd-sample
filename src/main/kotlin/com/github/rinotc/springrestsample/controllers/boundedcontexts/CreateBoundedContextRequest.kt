package com.github.rinotc.springrestsample.controllers.boundedcontexts

import com.github.michaelbull.result.binding
import com.github.rinotc.springrestsample.core.boundedcontext.BoundedContextAlias
import com.github.rinotc.springrestsample.core.boundedcontext.BoundedContextName
import com.github.rinotc.springrestsample.core.boundedcontext.BoundedContextOverview
import com.github.rinotc.springrestsample.usecases.CreateBoundedContextInput
import com.github.michaelbull.result.Result

data class CreateBoundedContextRequest(
    val alias: String,
    val name: String,
    val overview: String
) {
    fun validated(): Result<CreateBoundedContextInput, String> = binding {
        val a = BoundedContextAlias.validate(alias).bind()
        val n = BoundedContextName.validate(name).bind()
        val o = BoundedContextOverview.validate(overview).bind()
        CreateBoundedContextInput(a, n, o)
    }
}
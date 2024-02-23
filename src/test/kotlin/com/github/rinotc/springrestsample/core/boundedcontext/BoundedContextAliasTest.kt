package com.github.rinotc.springrestsample.core.boundedcontext

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("NonAsciiCharacters", "TestFunctionName")
class BoundedContextAliasTest {
    @Test
    fun 空文字を許容しない() {
        assertThrows<IllegalArgumentException> {
             BoundedContextAlias("")
        }
    }

    @Test
    fun 最大文字数は32文字() {
        assertThrows<IllegalArgumentException> {
            BoundedContextAlias("a".repeat(33))
        }

        val alias = BoundedContextAlias("a".repeat(32))
        assert(alias.value.length == 32)
    }

    @Test
    fun エイリアスに含まれる文字は半角英数字のみ() {
        assertThrows<IllegalArgumentException> {
            BoundedContextAlias("あ")
        }
    }
}
/*
 * Copyright (c) 2020. xmmmmmovo
 */

package fundamental

import algorithms.priority
import org.junit.jupiter.api.*

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.platform.commons.logging.LoggerFactory

internal class MathUtilsKtTest {

    companion object {
        private val log = LoggerFactory.getLogger(MathUtilsKtTest::class.java)

        @BeforeAll
        @JvmStatic
        fun before() {
            log.info { "MathUtilsKtTest start" }
        }

        @AfterAll
        @JvmStatic
        fun after() {
            log.info { "MathUtilsKtTest end" }
        }
    }

    @ParameterizedTest
    @CsvSource(
        "6, 3, 3",
        "6, 4, 2",
        "12, 8, 4"
    )
    fun gcd(a: Long, b: Long, res: Long) {
        log.info { "a:$a, b:$b testing" }
        assertEquals(res, algorithms.gcd(a, b))
    }

    @ParameterizedTest
    @CsvSource(
        "6, 3, 3",
        "6, 4, 2",
        "12, 8, 4",
        "0, 0, 0"
    )
    fun qgcd(a: Long, b: Long, res: Long) {
        log.info { "a:$a, b:$b testing" }
        assertEquals(res, algorithms.qgcd(a, b))
    }

    @ParameterizedTest
    @CsvSource(
        "+, 0",
        "-, 0",
        "*, 1",
        "/, 1",
        "(, 2",
        "), 2"
    )
    fun getPriority(c: Char, res: Int) {
        log.info { "c:$c testing" }
        assertEquals(res, priority[c])
    }

    @ParameterizedTest
    @CsvSource(
        "'', 0.0",
        " 1 + 2 , 3.0",
        "1+2* 3 + (4*5+6)*7, 189.0"
    )
    fun evalIntArithmetic(expr: String, res: Double) {
        log.info { "expr:$expr testing" }
        assertEquals(res, algorithms.evalIntArithmetic(expr))
    }

    @ParameterizedTest
    @CsvSource(
        "'', true",
        "(), true",
        "(((()()))), true",
        "(((())), false",
        "())), false",
        "[([)), false",
        "[([])], true",
        "[({}{})], true",
        "[{{{{})], false",
        "})], false"
    )
    fun isBanlanced(expr: String, res: Boolean) {
        log.info { "expr:$expr testing" }
        assertEquals(res, algorithms.isBanlanced(expr))
    }
}
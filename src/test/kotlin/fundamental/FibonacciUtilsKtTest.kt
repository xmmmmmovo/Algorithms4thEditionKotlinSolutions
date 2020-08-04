/*
 * Copyright (c) 2020. xmmmmmovo
 */

package fundamental

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.platform.commons.logging.LoggerFactory
import utils.readIntFile

internal class FibonacciUtilsKtTest {
    private val intestlist = readIntFile("./data/tinyT.txt")
    private val wtestlist = readIntFile("./data/tinyW.txt").sorted()

    companion object {
        private val log = LoggerFactory.getLogger(FibonacciUtilsKtTest::class.java)

        @BeforeAll
        @JvmStatic
        fun before() {
            log.info { "FibonacciUtilsKtTest start" }
        }

        @AfterAll
        @JvmStatic
        fun after() {
            log.info { "FibonacciUtilsKtTest end" }
        }
    }

    @Test
    fun makeFibonacciList() {
        assertEquals(emptyList<Long>(), algorithms.makeFibonacciList(0))
        assertEquals(listOf(1), algorithms.makeFibonacciList(1))
        assertEquals(listOf(1, 1), algorithms.makeFibonacciList(2))
        assertEquals(listOf(1, 1, 2), algorithms.makeFibonacciList(3))
        assertEquals(listOf(1, 1, 2, 3), algorithms.makeFibonacciList(4))
    }

    @Test
    fun makeFibonacciListUntilLength() {
        assertEquals(emptyList<Long>(), algorithms.makeFibonacciListUntilLength(0))
        assertEquals(listOf(1, 1, 2), algorithms.makeFibonacciListUntilLength(1))
        assertEquals(listOf(1, 1, 2, 3, 5), algorithms.makeFibonacciListUntilLength(2))
        assertEquals(listOf(1, 1, 2, 3, 5), algorithms.makeFibonacciListUntilLength(3))
    }

    @Test
    fun fibonacciBinarySearch() {
        log.info { "fibonacciBinarySearch testing" }

        intestlist.forEach {
            assertEquals(wtestlist.indexOf(it), algorithms.fibonacciBinarySearch(wtestlist, it))
        }
    }
}
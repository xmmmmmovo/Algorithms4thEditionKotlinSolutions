/*
 * Copyright (c) 2020. xmmmmmovo
 */

package fundamental

import edu.princeton.cs.algs4.In
import org.junit.jupiter.api.*

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.platform.commons.logging.LoggerFactory
import utils.readIntList

internal class ListUtilsKtTest {
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val dlist = listOf(1, 1, 2, 2, 1)

    companion object {
        private val log = LoggerFactory.getLogger(ListUtilsKtTest::class.java)

        @BeforeAll
        @JvmStatic
        fun before() {
            log.info { "ListUtilsKtTest start" }
        }

        @AfterAll
        @JvmStatic
        fun after() {
            log.info { "ListUtilsKtTest end" }
        }
    }

    @ParameterizedTest
    @CsvSource(
        "1, true",
        "10, true",
        "5, true",
        "-1, false"
    )
    fun containsInList(key: Int, res: Boolean) {
        assertEquals(res, algorithms.containsInList(list, key))
    }

    @Test
    fun containsDuplicatesInSorted() {
        assertEquals(false, algorithms.containsDuplicatesInSorted(list))
        assertEquals(true, algorithms.containsDuplicatesInSorted(dlist))
    }

    @Test
    fun minPair() {
        assertEquals(Pair(1, 2), algorithms.minPair(list))
        assertEquals(Pair(1, 1), algorithms.minPair(dlist))
    }

    @Test
    fun maxPair() {
        assertEquals(Pair(1, 10), algorithms.maxPair(list))
        assertEquals(Pair(1, 2), algorithms.maxPair(dlist))
    }
}
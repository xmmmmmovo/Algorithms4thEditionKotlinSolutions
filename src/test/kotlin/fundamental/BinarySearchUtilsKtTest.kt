/*
 * Copyright (c) 2020. xmmmmmovo
 */

package fundamental

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.platform.commons.logging.LoggerFactory

internal class BinarySearchUtilsKtTest {
    val l1 = listOf(1, 2, 3, 4, 5, 6, 7)
    val l2 = listOf(10, 2, 5, 4, 7, 6, 1, 3, 10)
    val l3 = listOf(4, 3, 2, 1, 4)
    val samelist = listOf(1, 1, 1, 1, 1)

    companion object {
        private val log = LoggerFactory.getLogger(BinarySearchUtilsKtTest::class.java)

        @BeforeAll
        @JvmStatic
        fun before() {
            log.info { "BinarySearchUtilsKtTest start" }
        }

        @AfterAll
        @JvmStatic
        fun after() {
            log.info { "BinarySearchUtilsKtTest end" }
        }
    }

    @Test
    fun binarySearch() {
        log.info { "binarySearch testing" }

        assertEquals(1, algorithms.binarySearch(l1, 2))
        assertEquals(4, algorithms.binarySearch(l1, 5))
        val l2s = l2.sorted()
        assertEquals(1, algorithms.binarySearch(l2s, 2))
        assertEquals(3, algorithms.binarySearch(l2s, 4))
        val l3s = l3.sorted()
        assertEquals(2, algorithms.binarySearch(l3s, 3))
        assertEquals(0, algorithms.binarySearch(l3s, 1))
    }

    @Test
    fun partialMinElem() {
        log.info { "partialMinElem testing" }

        assertEquals(0, algorithms.partialMinElem(l1))
        assertEquals(1, algorithms.partialMinElem(l2))
        assertEquals(3, algorithms.partialMinElem(l3))
        assertEquals(-1, algorithms.partialMinElem(samelist))
    }
}
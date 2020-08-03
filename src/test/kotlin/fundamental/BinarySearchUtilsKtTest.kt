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

internal class BinarySearchUtilsKtTest {
    private val l1 = listOf(1, 2, 3, 4, 5, 6, 7)
    private val l2 = listOf(10, 2, 5, 4, 7, 6, 1, 3, 10)
    private val l3 = listOf(4, 3, 2, 1, 4)
    private val l4 = listOf(1, 6, 10, 7, 4)

    private val intestlist = readIntFile("./data/tinyT.txt")
    private val wtestlist = readIntFile("./data/tinyW.txt").sorted()

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

        intestlist.forEach {
            assertEquals(wtestlist.indexOf(it), algorithms.binarySearch(wtestlist, it))
        }
    }

    @Test
    fun partialMinElem() {
        log.info { "partialMinElem testing" }

        assertEquals(0, algorithms.partialMinElem(l1))
        assertEquals(1, algorithms.partialMinElem(l2))
        assertEquals(3, algorithms.partialMinElem(l3))
        assertEquals(0, algorithms.partialMinElem(l4))
    }

    @Test
    fun partialMaxElem() {
        log.info { "partialMaxElem testing" }

        assertEquals(6, algorithms.partialMaxElem(l1))
        assertEquals(2, algorithms.partialMaxElem(l4))
    }

    @Test
    fun doubleToneSearch() {
        log.info { "doubleToneSearch testing" }
        assertEquals(-1, algorithms.doubleToneSearch(l4, 1111))
        assertEquals(0, algorithms.doubleToneSearch(l4, 1))
        assertEquals(4, algorithms.doubleToneSearch(l4, 4))
        assertEquals(1, algorithms.doubleToneSearch(l4, 6))
        assertEquals(2, algorithms.doubleToneSearch(l4, 10))
    }
}
/*
 * Copyright (c) 2020. xmmmmmovo
 */

package fundamental

import ds.LinkedList
import org.junit.jupiter.api.*

import org.junit.jupiter.api.Assertions.*
import org.junit.platform.commons.logging.LoggerFactory

internal class NumUtilsKtTest {
    private val list1 = listOf(1, 2, 3, 4, 5)
    private val list2 = listOf(-1, 2, -1, 1)
    private val matrix = listOf(
        listOf(1, 2, 3),
        listOf(2, 2, 3),
        listOf(1, 2, 3)
    )
    private val matrix2 = listOf(
        listOf(2, 2, 3),
        listOf(2, 3, 1),
        listOf(1, 2, 3)
    )

    companion object {
        private val log = LoggerFactory.getLogger(NumUtilsKtTest::class.java)

        @BeforeAll
        @JvmStatic
        fun before() {
            log.info { "NumUtilsKtTest start" }
        }

        @AfterAll
        @JvmStatic
        fun after() {
            log.info { "NumUtilsKtTest end" }
        }
    }

    @Test
    fun threeSumForce() {
        log.info { "threeSumForce testing" }

        assertEquals(listOf<LinkedList<Int>>(), algorithms.threeSumForce(list1, 0))
        assertEquals(listOf<LinkedList<Int>>(), algorithms.threeSumForce(list1, 3))
        assertEquals(
            listOf(
                LinkedList<Int>().apply { add(1); add(4); add(5) },
                LinkedList<Int>().apply { add(2); add(3); add(5) }
            ),
            algorithms.threeSumForce(list1, 10))
        assertEquals(listOf(
            LinkedList<Int>().apply { add(-1); add(2); add(-1) }
        ), algorithms.threeSumForce(list2, 0))
    }

    @Test
    fun threeSumBinaryFast() {
        log.info { "threeSumBinaryFast testing" }

        assertEquals(listOf<LinkedList<Int>>(), algorithms.threeSumForce(list1, 0))
        assertEquals(listOf<LinkedList<Int>>(), algorithms.threeSumForce(list1, 3))
        assertEquals(
            listOf(
                LinkedList<Int>().apply { add(1); add(4); add(5) },
                LinkedList<Int>().apply { add(2); add(3); add(5) }
            ),
            algorithms.threeSumForce(list1, 10))
        assertEquals(listOf(
            LinkedList<Int>().apply { add(-1); add(2); add(-1) }
        ), algorithms.threeSumForce(list2, 0))
    }

    @Test
    fun matrixPartialMinElem() {
        log.info { "matrixPartialMinElem testing" }

        algorithms.matrixPartialMinElem(matrix)
    }
}
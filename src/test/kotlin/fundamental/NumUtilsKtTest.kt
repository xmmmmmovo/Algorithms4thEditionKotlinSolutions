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
        listOf(4, 2, 1),
        listOf(5, 6, 7),
        listOf(10, 9, 8)
    )
    private val matrix3 = listOf(
        listOf(26, 3, 4, 10, 11),
        listOf(5, 1, 6, 12, 13),
        listOf(7, 8, 9, 14, 15),
        listOf(16, 17, 18, 27, 20),
        listOf(21, 22, 23, 24, 25)
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
        assertEquals(
            listOf<LinkedList<Int>>(), algorithms.threeSumForce(list2, 0)
        )
    }

    @Test
    fun threeSumBinaryFast() {
        log.info { "threeSumBinaryFast testing" }

        assertEquals(listOf<LinkedList<Int>>(), algorithms.threeSumBinaryFast(list1, 0))
        assertEquals(listOf<LinkedList<Int>>(), algorithms.threeSumBinaryFast(list1, 3))
        assertEquals(
            listOf(
                LinkedList<Int>().apply { add(1); add(4); add(5) },
                LinkedList<Int>().apply { add(2); add(3); add(5) }
            ),
            algorithms.threeSumBinaryFast(list1, 10))
        assertEquals(
            listOf<LinkedList<Int>>(), algorithms.threeSumBinaryFast(list2, 0)
        )
    }

    @Test
    fun matrixPartialMinElem() {
        log.info { "matrixPartialMinElem testing" }

        assertEquals(Pair(2, 0), algorithms.matrixPartialMinElem(matrix))
        assertEquals(Pair(0, 2), algorithms.matrixPartialMinElem(matrix2))
        assertEquals(Pair(1, 1), algorithms.matrixPartialMinElem(matrix3))
    }
}
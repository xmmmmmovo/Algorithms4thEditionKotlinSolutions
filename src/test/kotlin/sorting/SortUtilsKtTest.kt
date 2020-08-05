/*
 * Copyright (c) 2020. xmmmmmovo
 */

package sorting

import fundamental.AccumulatorTest
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.platform.commons.logging.LoggerFactory

internal class SortUtilsKtTest {
    val list = listOf(1, 2, 3, 4, 5, 10, 6, 7, 8, 9)

    companion object {
        private val log = LoggerFactory.getLogger(SortUtilsKtTest::class.java)

        @BeforeAll
        @JvmStatic
        fun before() {
            log.info { "SortUtilsKtTest start" }
        }

        @AfterAll
        @JvmStatic
        fun after() {
            log.info { "SortUtilsKtTest end" }
        }
    }

    @Test
    fun bubbleSort() {
        algorithms.bubbleSort(list)
    }
}
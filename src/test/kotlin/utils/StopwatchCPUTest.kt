/*
 * Copyright (c) 2020. xmmmmmovo
 */

package utils

import fundamental.BinarySearchUtilsKtTest
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.platform.commons.logging.LoggerFactory

internal class StopwatchCPUTest {
    companion object {
        private val log = LoggerFactory.getLogger(StopwatchCPUTest::class.java)

        @BeforeAll
        @JvmStatic
        fun before() {
            log.info { "StopwatchCPUTest start" }
        }

        @AfterAll
        @JvmStatic
        fun after() {
            log.info { "StopwatchCPUTest end" }
        }
    }

    @Test
    fun elapsedTime() {
        log.info { "elapsedTime testing" }
        val swc = StopwatchCPU()
        val sum = (0..100000).sum()
        log.info { swc.toString() }
    }
}
/*
 * Copyright (c) 2020. xmmmmmovo
 */

package fundamental

import ds.VisualAccumulator
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.platform.commons.logging.LoggerFactory
import kotlin.math.sqrt

internal class VisualAccumulatorTest {
    val acc = VisualAccumulator()

    companion object {
        private val log = LoggerFactory.getLogger(AccumulatorTest::class.java)

        @BeforeAll
        @JvmStatic
        fun before() {
            log.info { "AccumulatorTest start" }
        }

        @AfterAll
        @JvmStatic
        fun after() {
            log.info { "AccumulatorTest end" }
        }
    }

    @Test
    fun addDataValue() {
        log.info { "addDataValue testing" }

        acc.addDataValue(2.0)
        assertEquals(2.0, acc.total())
        acc.addDataValue(3.0)
        assertEquals(5.0, acc.total())
        acc.addDataValue(4.0)
        assertEquals(9.0, acc.total())
    }

    @Test
    fun mean() {
        log.info { "mean testing" }

        acc.addDataValue(2.0)
        assertEquals(2.0, acc.mean())
        acc.addDataValue(3.0)
        assertEquals(2.5, acc.mean())
        acc.addDataValue(4.0)
        assertEquals(3.0, acc.mean())
    }

    @Test
    fun variance() {
        log.info { "variance testing" }

        acc.addDataValue(2.0)
        assertEquals(0.0, acc.variance())
        acc.addDataValue(3.0)
        assertEquals(0.5, acc.variance())
        acc.addDataValue(4.0)
        assertEquals(1.0, acc.variance())
    }

    @Test
    fun stddev() {
        log.info { "stddev testing" }

        acc.addDataValue(2.0)
        assertEquals(0.0, acc.stddev())
        acc.addDataValue(3.0)
        assertEquals(sqrt(0.5), acc.stddev(), 0.000001)
        acc.addDataValue(4.0)
        assertEquals(sqrt(1.0), acc.stddev(), 0.000001)
    }

    @Test
    fun testToString() {
        log.info { "testToString testing" }

        acc.addDataValue(2.0)
        assertEquals("Mean (1 times, 2.00 values): 2.00000", acc.toString())
    }
}
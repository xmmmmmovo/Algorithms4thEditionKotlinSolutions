/*
 * Copyright (c) 2020. xmmmmmovo
 */

package fundamental

import algorithms.Point2DMinDistanceCalculator
import ds.Point2D
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.platform.commons.logging.LoggerFactory

internal class Point2DMinDistanceCalculatorTest {
    private val list = Array<Point2D>(5) { Point2D(it.toDouble(), it.toDouble()) }
    private val pc = Point2DMinDistanceCalculator(5, list)

    companion object {
        private val log = LoggerFactory.getLogger(Point2DMinDistanceCalculatorTest::class.java)

        @BeforeAll
        @JvmStatic
        fun before() {
            log.info { "Point2DMinDistanceCalculatorTest start" }
        }

        @AfterAll
        @JvmStatic
        fun after() {
            log.info { "Point2DMinDistanceCalculatorTest end" }
        }
    }

    @Test
    fun minDistanceForce() {
        log.info { "minDistanceForce testing" }

        assertEquals(1.414, pc.minDistanceForce(), 0.001)
    }

    @Test
    fun minDistanceDivide() {
        log.info { "getMinPointPair testing" }

    }
}
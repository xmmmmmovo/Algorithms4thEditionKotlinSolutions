/*
 * Copyright (c) 2020. xmmmmmovo
 */

package fundamental

import ds.Point2D
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.platform.commons.logging.LoggerFactory

internal class Point2DTest {
    private val p1 = Point2D(1.0, 2.0)
    private val p2 = Point2D(2.0, 3.0)
    private val p3 = Point2D(2.0, 3.0)

    companion object {
        private val log = LoggerFactory.getLogger(Point2DTest::class.java)

        @BeforeAll
        @JvmStatic
        fun before() {
            log.info { "Point2DTest start" }
        }

        @AfterAll
        @JvmStatic
        fun after() {
            log.info { "Point2DTest end" }
        }
    }

    @Test
    fun compareTo() {
        log.info { "compareTo testing" }

        assertEquals(true, p1 <= p2)
        assertEquals(true, p2 >= p1)
        assertEquals(true, p2 >= p3)
    }

    @Test
    fun testToString() {
        log.info { "compareTo testing" }

        assertEquals("x=1.00, y=2.00", p1.toString())
        assertEquals("x=2.00, y=3.00", p2.toString())
        assertEquals("x=2.00, y=3.00", p3.toString())
    }

    @Test
    fun getX() {
        log.info { "compareTo testing" }

        assertEquals(1.0, p1.x)
        assertEquals(2.0, p2.x)
        assertEquals(2.0, p3.x)
    }

    @Test
    fun getY() {
        log.info { "compareTo testing" }

        assertEquals(2.0, p1.y)
        assertEquals(3.0, p2.y)
        assertEquals(3.0, p3.y)
    }
}
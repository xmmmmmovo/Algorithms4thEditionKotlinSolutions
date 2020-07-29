/*
 * Copyright (c) 2020. xmmmmmovo
 */

package fundamental

import ds.StackDeque
import org.junit.jupiter.api.*

import org.junit.jupiter.api.Assertions.*
import org.junit.platform.commons.logging.LoggerFactory

internal class StackDequeTest {
    val sd = StackDeque<Int>()

    companion object {
        private val log = LoggerFactory.getLogger(StackDequeTest::class.java)

        @BeforeAll
        @JvmStatic
        fun before() {
            log.info { "StackDequeTest start" }
        }

        @AfterAll
        @JvmStatic
        fun after() {
            log.info { "StackDequeTest end" }
        }

    }

    @Test
    fun isEmpty() {
        log.info { "isEmpty testing" }

        assertEquals(true, sd.isEmpty())
        sd.pushLeft(1)
        assertEquals(false, sd.isEmpty())
        sd.popLeft()
        assertEquals(true, sd.isEmpty())
        sd.pushRight(1)
        assertEquals(false, sd.isEmpty())
        sd.popRight()
        assertEquals(true, sd.isEmpty())

    }

    @Test
    fun pushLeft() {
        log.info { "pushLeft testing" }

        sd.pushLeft(1)
        sd.pushLeft(2)
        sd.pushLeft(3)
        assertEquals(1, sd.popRight())
        assertEquals(2, sd.popRight())
        assertEquals(3, sd.popRight())
    }

    @Test
    fun pushRight() {
        log.info { "pushRight testing" }

        sd.pushRight(1)
        sd.pushRight(2)
        sd.pushRight(3)
        assertEquals(1, sd.popLeft())
        assertEquals(2, sd.popLeft())
        assertEquals(3, sd.popLeft())
    }

    @Test
    fun popLeft() {
        log.info { "popLeft testing" }

        sd.pushLeft(1)
        sd.pushLeft(2)
        sd.pushLeft(3)
        assertEquals(3, sd.popLeft())
        assertEquals(2, sd.popLeft())
        assertEquals(1, sd.popLeft())
    }

    @Test
    fun popRight() {
        log.info { "popRight testing" }

        sd.pushRight(1)
        sd.pushRight(2)
        sd.pushRight(3)
        assertEquals(3, sd.popRight())
        assertEquals(2, sd.popRight())
        assertEquals(1, sd.popRight())
    }

    @Test
    fun getSize() {
        log.info { "getSize testing" }

        assertEquals(0, sd.size)
        sd.pushLeft(1)
        assertEquals(1, sd.size)
        sd.pushRight(2)
        assertEquals(2, sd.size)
        sd.popRight()
        assertEquals(1, sd.size)
        sd.popLeft()
        assertEquals(0, sd.size)
    }

    @Test
    fun testToString() {
        log.info { "testToString testing" }
        assertEquals("[]", sd.toString())
        sd.pushLeft(1)
        assertEquals("[1]", sd.toString())
        sd.pushLeft(2)
        assertEquals("[2, 1]", sd.toString())
        sd.popRight()
        assertEquals("[2]", sd.toString())
    }
}
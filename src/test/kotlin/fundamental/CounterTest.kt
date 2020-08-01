/*
 * Copyright (c) 2020. xmmmmmovo
 */

package fundamental

import ds.Counter
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.platform.commons.logging.LoggerFactory

internal class CounterTest {
    private val c = Counter("test tag", 0)
    private val cc = Counter("test comp", 1)

    companion object {
        private val log = LoggerFactory.getLogger(CounterTest::class.java)

        @BeforeAll
        @JvmStatic
        fun before() {
            log.info { "CounterTest start" }
        }

        @AfterAll
        @JvmStatic
        fun after() {
            log.info { "CounterTest end" }
        }
    }


    @Test
    fun increment() {
        log.info { "increment testing" }

        c.increment()
        assertEquals(1, c.tally)
        c.increment()
        assertEquals(2, c.tally)
        c.increment()
        assertEquals(3, c.tally)
        c.increment()
        assertEquals(4, c.tally)
    }

    @Test
    fun compareTo() {
        log.info { "increment testing" }

        assertEquals(true, c < cc)
        c.increment()
        assertEquals(true, c == cc)
        assertEquals(true, c >= cc)
        assertEquals(false, c.equals(1))
        c.increment()
        assertEquals(true, c > cc)
    }

    @Test
    fun testToString() {
        log.info { "increment testing" }

        assertEquals("test tag 0 times", c.toString())
        assertEquals("test comp 1 times", cc.toString())
    }
}
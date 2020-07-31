/*
 * Copyright (c) 2020. xmmmmmovo
 */

package fundamental

import ds.StackDequeOpt
import org.junit.jupiter.api.*

import org.junit.jupiter.api.Assertions.*
import org.junit.platform.commons.logging.LoggerFactory

internal class StackDequeOptTest {
    private val sdo = StackDequeOpt<Int>()

    companion object {
        private val log = LoggerFactory.getLogger(StackDequeOptTest::class.java)

        @BeforeAll
        @JvmStatic
        fun before() {
            log.info { "StackDequeOptTest start" }
        }

        @AfterAll
        @JvmStatic
        fun after() {
            log.info { "StackDequeOptTest end" }
        }
    }

    @Test
    fun isEmpty() {
        log.info { "isEmpty testing" }

        assertEquals(true, sdo.isEmpty())
        sdo.pushRight(1)
        assertEquals(false, sdo.isEmpty())
        sdo.popLeft()
        assertEquals(true, sdo.isEmpty())
    }

    @Test
    fun pushRight() {
        log.info { "pushRight testing" }

        sdo.pushRight(1)
        sdo.pushRight(2)
        sdo.pushRight(3)
        assertEquals(1, sdo.popLeft())
        assertEquals(2, sdo.popLeft())
        assertEquals(3, sdo.popLeft())
    }

    @Test
    fun peekLeft() {
        log.info { "peekLeft testing" }

        sdo.pushRight(1)
        sdo.pushRight(2)
        sdo.pushRight(3)
        assertEquals(1, sdo.peekLeft())
        sdo.popLeft()
        assertEquals(2, sdo.peekLeft())
    }

    @Test
    fun getSize() {
        log.info { "getSize testing" }

        assertEquals(0, sdo.size)
        sdo.pushRight(1)
        assertEquals(1, sdo.size)
        sdo.popLeft()
        assertEquals(0, sdo.size)
        sdo.pushRight(1)
        sdo.pushRight(2)
        sdo.pushRight(3)
        assertEquals(3, sdo.size)
    }
}
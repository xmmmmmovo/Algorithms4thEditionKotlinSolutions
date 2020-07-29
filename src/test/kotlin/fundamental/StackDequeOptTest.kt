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

    @BeforeEach
    fun setUp() {

    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun isEmpty() {
    }

    @Test
    fun pushRight() {
    }

    @Test
    fun popLeft() {
    }

    @Test
    fun peekLeft() {
    }

    @Test
    fun getSize() {
    }

    @Test
    fun asList() {
    }

    @Test
    fun testToString() {

    }
}
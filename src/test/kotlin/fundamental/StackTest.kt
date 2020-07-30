/*
 * Copyright (c) 2020. xmmmmmovo
 */

package fundamental

import ds.Stack
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.platform.commons.logging.LoggerFactory

internal class StackTest {
    private val s = Stack<Int>()

    companion object {
        private val log = LoggerFactory.getLogger(StackTest::class.java)

        @BeforeAll
        @JvmStatic
        fun before() {
            log.info { "StackTest start" }
        }

        @AfterAll
        @JvmStatic
        fun after() {
            log.info { "StackTest end" }
        }
    }

    @Test
    fun isEmpty() {
        log.info { "isEmpty testing" }

        assertEquals(true, s.isEmpty())
        s.push(1)
        assertEquals(false, s.isEmpty())
        s.pop()
        assertEquals(true, s.isEmpty())
    }

    @Test
    fun getSize() {
        log.info { "getSize testing" }

        assertEquals(0, s.size)
        s.push(1)
        assertEquals(1, s.size)
        s.pop()
        assertEquals(0, s.size)
    }

    @Test
    fun contains() {
        log.info { "contains testing" }

        s.push(1)
        assertEquals(true, s.contains(1))
        s.pop()
        assertEquals(false, s.contains(1))
    }

    @Test
    fun containsAll() {
        log.info { "containsAll testing" }

        s.push(1)
        s.push(2)
        s.push(3)
        assertEquals(true, s.containsAll(listOf(1, 2)))
        s.pop()
        s.pop()
        assertEquals(true, s.containsAll(listOf(1)))
        s.pop()
        assertEquals(false, s.containsAll(listOf(1)))
    }

    @Test
    fun pop() {
        log.info { "pop testing" }

        s.push(1)
        s.push(2)
        s.push(3)
        assertEquals(3, s.pop())
        assertEquals(2, s.pop())
        assertEquals(1, s.pop())
    }

    @Test
    fun peek() {
        log.info { "peek testing" }

        s.push(1)
        s.push(2)
        s.push(3)
        assertEquals(3, s.peek())
    }

    @Test
    fun testClone() {
        log.info { "testClone testing" }

        s.push(1)
        s.push(2)
        val sc = s.clone()
        assertEquals(2, sc.size)
        assertEquals(2, sc.pop())
        assertEquals(1, sc.size)
        assertEquals(2, s.size)
    }

    @Test
    fun testToString() {
        log.info { "testToString testing" }

        assertEquals("[]", s.toString())
        s.push(1)
        assertEquals("[1]", s.toString())
    }
}
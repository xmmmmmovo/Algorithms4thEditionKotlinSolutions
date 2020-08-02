/*
 * Copyright (c) 2020. xmmmmmovo
 */

package fundamental

import ds.LinkedList
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.platform.commons.logging.LoggerFactory

internal class LinkedListTest {
    private val ll = LinkedList<Int>()

    companion object {
        private val log = LoggerFactory.getLogger(LinkedListTest::class.java)

        @BeforeAll
        @JvmStatic
        fun before() {
            log.info { "LinkedListTest start" }
        }

        @AfterAll
        @JvmStatic
        fun after() {
            log.info { "LinkedListTest end" }
        }
    }

    @Test
    fun add() {
        log.info { "add testing" }

        ll.add(1)
        ll.add(2)
        ll.add(3)
        assertEquals(1, ll.getFirst())
        assertEquals(3, ll.getLast())
        ll.add(0, 11)
        ll.add(4, 12)
        assertEquals(11, ll.getFirst())
        assertEquals(12, ll.getLast())
    }

    @Test
    fun addAll() {
        log.info { "addAll testing" }
        ll.addAll(listOf(1, 1, 4, 5, 1, 4))
        assertEquals(1, ll.getFirst())
        assertEquals(4, ll.getLast())
        assertEquals("[1, 1, 4, 5, 1, 4]", ll.toString())
        ll.addAll(0, listOf(11))
        ll.addAll(7, listOf(11))
        assertEquals(11, ll.getFirst())
        assertEquals(11, ll.getLast())
    }

    @Test
    fun clear() {
        log.info { "clear testing" }
        ll.addAll(listOf(1, 1, 4, 5, 1, 4))
        ll.clear()
        assertEquals("[]", ll.toString())
    }

    @Test
    fun remove() {
        log.info { "remove testing" }
        ll.addAll(listOf(1, 1, 4, 5, 1, 4))
        ll.remove(5)
        assertEquals("[1, 1, 4, 1, 4]", ll.toString())
        assertEquals(5, ll.size)
        ll.remove(1)
        assertEquals("[1, 4, 1, 4]", ll.toString())
        assertEquals(4, ll.size)
    }

    @Test
    fun removeAll() {
        log.info { "add testing" }

    }

    @Test
    fun removeAt() {
        log.info { "add testing" }

    }

    @Test
    fun retainAll() {
        log.info { "add testing" }

    }

    @Test
    fun set() {
        log.info { "add testing" }

    }

    @Test
    fun contains() {
        log.info { "add testing" }

    }

    @Test
    fun containsAll() {
        log.info { "add testing" }

    }

    @Test
    fun indexOf() {
        log.info { "add testing" }

    }

    @Test
    fun get() {
        log.info { "add testing" }

    }

    @Test
    fun isEmpty() {
        log.info { "add testing" }

    }

    @Test
    fun lastIndexOf() {
        log.info { "add testing" }

    }

    @Test
    operator fun iterator() {
        log.info { "add testing" }

    }

    @Test
    fun listIterator() {
        log.info { "add testing" }

    }

    @Test
    fun testListIterator() {
        log.info { "add testing" }


    }

    @Test
    fun subList() {
        log.info { "subList testing" }

        ll.add(1)
        ll.add(2)
        ll.add(3)
        val subl = ll.subList(0, 2)
        assertEquals("[1, 2]", subl.toString())
    }

    @Test
    fun getSize() {
        log.info { "getSize testing" }
        assertEquals(0, ll.size)
        ll.addFirst(1)
        assertEquals(1, ll.size)
    }

    @Test
    fun getFirst() {
        log.info { "getFirst testing" }
        ll.addFirst(1)
        ll.addFirst(2)
        assertEquals(2, ll.getFirst())
    }

    @Test
    fun getLast() {
        log.info { "getLast testing" }
        ll.addFirst(1)
        ll.addFirst(2)
        assertEquals(1, ll.getLast())
    }

    @Test
    fun reverse() {
        log.info { "reverse testing" }
        ll.reverse()
        assertEquals("[]", ll.toString())
        ll.addFirst(1)
        ll.addFirst(2)
        ll.reverse()
        assertEquals("[1, 2]", ll.toString())
    }

    @Test
    fun addFirst() {
        log.info { "addFirst testing" }
        ll.addFirst(1)
        ll.addFirst(2)
        assertEquals(1, ll.removeLast())
        assertEquals(2, ll.removeLast())
    }

    @Test
    fun addLast() {
        log.info { "addLast testing" }
        ll.addLast(1)
        ll.addLast(2)
        ll.addLast(3)
        assertEquals(1, ll.removeFirst())
        assertEquals(2, ll.removeFirst())
    }

    @Test
    fun removeFirst() {
        log.info { "removeFirst testing" }
        ll.addFirst(1)
        ll.addFirst(2)
        assertEquals(2, ll.removeFirst())
        assertEquals(1, ll.removeFirst())
    }

    @Test
    fun removeLast() {
        log.info { "removeLast testing" }
        ll.addLast(1)
        ll.addLast(2)
        assertEquals(2, ll.removeLast())
        assertEquals(1, ll.removeLast())
    }

    @Test
    fun testEquals() {
        log.info { "testEquals testing" }
        val el = LinkedList<Int>()
        assertEquals(true, ll == el)
        el.add(1)
        assertEquals(true, ll != el)
        val sl = ll
        val tl = Double
        assertEquals(true, ll == sl)
        assertEquals(false, ll.equals(tl))
    }

    @Test
    fun testHashCode() {
        log.info { "testHashCode testing" }
        assertEquals(1, ll.hashCode())
        ll.add(1)
        assertEquals(32, ll.hashCode())
    }
}
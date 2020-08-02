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
        ll.addAll(emptyList())
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
        assertEquals(false, ll.remove(111))
        assertEquals("[1, 4, 1, 4]", ll.toString())
        assertEquals(4, ll.size)
    }

    @Test
    fun removeAll() {
        log.info { "removeAll testing" }
        ll.addAll(listOf(1, 2, 3, 4, 5, 6))

        assertEquals(false, ll.removeAll(listOf(1, 2, 10)))
        assertEquals(true, ll.removeAll(listOf(1, 2, 3)))
        assertEquals(3, ll.size)
    }

    @Test
    fun removeAt() {
        log.info { "removeAt testing" }
        ll.addAll(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(5, ll.removeAt(4))
    }

    @Test
    fun retainAll() {
        log.info { "retainAll testing" }
        ll.addAll(listOf(1, 2, 3, 4, 5, 6))
        ll.retainAll(listOf(1, 2, 3))
        assertEquals(3, ll.size)
        assertEquals("[1, 2, 3]", ll.toString())
    }

    @Test
    fun set() {
        log.info { "set testing" }
        ll.addAll(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(3, ll.set(2, 10))
    }

    @Test
    fun contains() {
        log.info { "contains testing" }
        ll.addAll(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(true, ll.contains(3))
        assertEquals(false, ll.contains(111))
    }

    @Test
    fun containsAll() {
        log.info { "containsAll testing" }
        ll.addAll(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(false, ll.containsAll(emptyList()))
        assertEquals(true, ll.containsAll(listOf(1, 2, 3)))
        assertEquals(false, ll.containsAll(listOf(1, 2, 111)))
    }

    @Test
    fun indexOf() {
        log.info { "indexOf testing" }
        ll.addAll(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(-1, ll.indexOf(1111))
        assertEquals(2, ll.indexOf(3))
    }

    @Test
    fun get() {
        log.info { "get testing" }
        ll.addAll(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(1, ll.get(0))
        assertEquals(3, ll.get(2))
    }

    @Test
    fun isEmpty() {
        log.info { "isEmpty testing" }
        assertEquals(true, ll.isEmpty())
        ll.add(111)
        assertEquals(false, ll.isEmpty())
    }

    @Test
    fun lastIndexOf() {
        log.info { "lastIndexOf testing" }
        ll.addAll(listOf(1, 1, 3, 4, 1, 6))
        assertEquals(-1, ll.lastIndexOf(111))
        assertEquals(4, ll.lastIndexOf(1))
    }

    @Test
    operator fun iterator() {
        log.info { "iterator testing" }
        ll.addAll(listOf(1, 2, 3, 4, 5, 6))

        val it = ll.iterator()
        if (it.hasNext()) {
            assertEquals(1, it.next())
        }
        assertEquals(2, it.next())
    }

    @Test
    fun listIterator() {
        log.info { "listIterator testing" }
        ll.addAll(listOf(1, 2, 3, 4, 5, 6))
        val it = ll.listIterator()
        val itt = ll.listIterator(2)

        itt.next()
        itt.set(100)
        assertEquals(100, ll.get(3))
        itt.remove()
        assertEquals(5, ll.get(3))
        itt.add(11)
        assertEquals(11, ll.get(2))
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
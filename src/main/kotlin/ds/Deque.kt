/*
 * Copyright (c) 2020. xmmmmmovo
 */
package ds

import java.util.Deque

/**
 * 双向队列类
 * */
class Deque<T> : Collection<T> {
    private val list = LinkedList<T>()

    override fun isEmpty() = list.size == 0

    fun pushLeft(element: T) = list.addFirst(element)

    fun pushRight(element: T) = list.addLast(element)

    fun popLeft(): T = list.removeFirst()

    fun popRight(): T = list.removeLast()

    override val size: Int
        get() = list.size

    /**
     * 是否包含[element]
     * */
    override fun contains(element: T): Boolean {
        return indexOf(element) != -1
    }

    /**
     * 是否包含所有[elements]
     * */
    override fun containsAll(elements: Collection<T>): Boolean =
        if (elements.isEmpty())
            false
        else
            elements.all {
                contains(it)
            }

    /**
     * 查看[element]的位置
     * */
    private fun indexOf(element: T): Int {
        var index = 0
        this.forEach {
            if (it == element) {
                return index
            }
            index++
        }
        return -1
    }

    override fun toString(): String {
        return list.toString()
    }

    override fun iterator(): Iterator<T> {
        return list.iterator()
    }
}
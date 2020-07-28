/*
 * Copyright (c) 2020. xmmmmmovo
 */
package ds

/**
 * 栈
 * @author xmmmmmovo
 * @date 2020/7/28 16:44
 * @since version-1.0
 */
class Stack<T> : Collection<T> {
    private var first: Node<T>? = null
    private var n: Int = 0

    constructor()

    constructor(s: Stack<T>) {
        for (i in s) {
            push(i)
        }
    }

    /**
     * 是否空
     * */
    override fun isEmpty(): Boolean = first == null

    /**
     * 栈大小
     * */
    override val size: Int
        get() = n

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

    /**
     * 入栈
     * */
    fun push(item: T) {
        val oi = first
        first = Node(
            item,
            oi
        )
        n++
    }

    /**
     * 出栈
     * */
    fun pop(): T {
        if (isEmpty()) {
            throw NoSuchElementException("Stack underflow")
        }
        return first?.item.also {
            first = first?.next
            n--
        }!!
    }

    /**
     * 看栈顶
     * */
    fun peek(): T {
        if (isEmpty()) {
            throw NoSuchElementException("Stack underflow")
        }
        return first?.item!!
    }

    override fun toString(): String {
        return StringBuilder().also {
            this.forEach { item -> it.append("$item ") }
        }.toString()
    }

    override fun iterator(): Iterator<T> {
        return LinkedIterator(first)
    }

    companion object {
        private data class Node<T>(
            val item: T,
            var next: Node<T>? = null
        )
    }

    private class LinkedIterator<T>(
        private var current: Node<T>?
    ) : Iterator<T> {

        override fun hasNext(): Boolean {
            return current != null
        }

        override fun next(): T {
            if (!hasNext()) {
                throw NoSuchElementException()
            }
            val item = current?.item
            current = current?.next
            return item!!
        }
    }
}
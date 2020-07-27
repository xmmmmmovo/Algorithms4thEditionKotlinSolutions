package ds

/**
 * 单项队列类
 * */
class Queue<T> : Collection<T> {
    private var first: Node<T>? = null
    private var last: Node<T>? = null
    private var n: Int = 0

    constructor()

    constructor(q: Queue<T>) {
        for (i in q) {
            enqueue(i)
        }
    }

    override fun isEmpty(): Boolean = first == null

    /**
     * 入队列
     * */
    fun enqueue(item: T) {
        val ol = last
        last = Node(
                item,
                null
        )
        if (isEmpty()) {
            first = last
        } else {
            ol?.next = last
        }
        n++
    }

    /**
     * 出队列
     * */
    fun dequeue(): T {
        if (isEmpty()) {
            throw NoSuchElementException("Stack underflow")
        }
        return first?.item.also {
            first = first?.next
            n--
            if (isEmpty()) {
                last = null
            }
        }!!
    }

    /**
     * 查看队列首
     * */
    fun peek(): T {
        if (isEmpty()) {
            throw NoSuchElementException("Stack underflow")
        }
        return first?.item!!
    }

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
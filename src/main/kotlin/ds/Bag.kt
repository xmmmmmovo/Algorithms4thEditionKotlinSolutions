package ds

class Bag<T> : Collection<T> {
    private var first: Node<T>? = null
    private var n: Int = 0

    /**
     * 是否为空
     * */
    override fun isEmpty(): Boolean = first == null

    /**
     * 返回长度
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
     * 添加元素
     * */
    fun add(item: T) {
        val oi = first
        first = Node(
            item,
            oi
        )
        n++
    }

    override fun iterator(): Iterator<T> {
        return LinkedIterator(first)
    }

    private data class Node<T>(
        val item: T,
        var next: Node<T>? = null
    )

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
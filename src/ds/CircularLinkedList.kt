package ds

/**
 * 循环链表
 * 此类仅用于约瑟夫环问题 所以api设计很简单
 * */
class CircularLinkedList<T> : MutableCollection<T> {
    private var _size = 0
    private var first: Node<T>? = null
    private var last: Node<T>? = null

    override val size
        get() = _size

    override fun clear() {
        var n = first
        while (n != null) {
            val next = n.next
            // 快速gc
            n.item = null
            n.next = null
            n.prev = null
            n = next
        }
        first = null
        last = null
        _size = 0
    }

    override fun contains(element: T): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }
    
    override fun add(element: T): Boolean {
        linkedLast(element)
        return true
    }

    override fun addAll(elements: Collection<T>): Boolean {
        TODO("Not yet implemented")
    }

    override fun remove(element: T): Boolean {
        TODO("Not yet implemented")
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        TODO("Not yet implemented")
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        TODO("Not yet implemented")
    }

    override fun iterator(): MutableIterator<T> {
        return IteratorImpl(0)
    }

    fun iterator(index: Int): MutableIterator<T> {
        return IteratorImpl(index)
    }

    private fun getNode(index: Int): Node<T> {
        val reIndex = index % _size
        return if (reIndex < (_size shr 1)) {
            var node = first
            for (i in 0 until index) {
                node = node?.next
            }
            node!!
        } else {
            var node = last
            for (i in _size - 2 downTo index) {
                node = node?.prev
            }
            node!!
        }
    }

    /**
     * 连接尾节点
     * */
    private fun linkedLast(item: T) {
        val l = last
        val nNode = Node(item, l, null)
        last = nNode

        if (l == null) {
            first = last
        } else {
            l.next = nNode
        }
        _size++
    }

    /**
     * 解除首部连接
     * */
    private fun unlinkFirst(): T {
        val f = first ?: throw NoSuchElementException()
        val item = f.item
        val next = f.next
        // 快速GC
        f.next = null
        f.item = null
        first = next
        if (next == null) {
            last = null
        } else {
            next.prev = null
        }

        _size--
        return item!!
    }

    /**
     * 解除尾部连接
     * */
    private fun unlinkLast(): T {
        val l = last ?: throw NoSuchElementException()
        val item = l.item
        val prev = l.prev
        // 快速GC
        l.item = null
        l.prev = null
        last = prev
        if (prev == null) {
            first = null
        } else {
            prev.next = null
        }
        _size--
        return item!!
    }

    /**
     * 解连接
     * */
    private fun unlink(node: Node<T>): T {
        val np = node.prev
        val nn = node.next
        val ne = node.item

        if (np == null) {
            first = nn
        } else {
            np.next = nn
            node.prev = null
        }

        if (nn == null) {
            last = np
        } else {
            nn.prev = np
            node.next = null
        }

        node.item = null
        _size--
        return ne!!
    }

    companion object {
        private data class Node<T>(
            var item: T?,
            var prev: Node<T>?,
            var next: Node<T>?
        )
    }

    private inner class IteratorImpl(
        private var index: Int = 0
    ) : MutableIterator<T> {
        private var current: Node<T>? = getNode(index)

        override fun hasNext(): Boolean = index != 0

        override fun next(): T {
            TODO("Not yet implemented")
        }

        override fun remove() {
            TODO("Not yet implemented")
        }

    }
}
package ds

/**
 * @Author xmmmmmovo
 * @Version 1.0
 * 循环链表
 * 此类仅用于约瑟夫环问题 所以api设计很简单
 * */
class CircularLinkedList<T> : MutableIterable<T> {
    private var _size = 0
    private var first: Node<T>? = null
    private var last: Node<T>? = null

    val size
        get() = _size

    fun clear() {
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

    fun isEmpty(): Boolean = _size == 0

    fun add(element: T): Boolean {
        linkedLast(element)
        return true
    }

    override fun iterator(): MutableIterator<T> {
        return IteratorImpl(0)
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
        first!!.prev = nNode
        nNode.next = first
        _size++
    }

    /**
     * 解连接
     * */
    private fun unlink(node: Node<T>): T {
        val npre = node.prev
        val nnext = node.next
        val nitem = node.item

        if (npre == last && nnext == first) {
            last = null
            first = null
        } else {
            if (node == first)
                first = nnext
            if (node == last)
                last = npre
            npre!!.next = nnext
            nnext!!.prev = npre
            node.next = null
            node.prev = null
        }

        node.item = null
        _size--
        return nitem!!
    }

    /**
     * 转字符串方法
     * */
    override fun toString(): String =
            when (_size) {
                0 -> "[]"
                else -> {
                    val sb = StringBuilder()
                    sb.append("[")
                    var n = first
                    while (n != last) {
                        sb.append("${n!!.item}, ")
                        n = n.next
                    }
                    sb.append("${n!!.item}]").toString()
                }
            }

    companion object {
        private data class Node<T>(
                var item: T?,
                var prev: Node<T>?,
                var next: Node<T>?
        )

        /**
         * 查看位置是否合法
         * */
        internal fun checkPositionIndex(index: Int, size: Int) {
            if (index < 0 || size == 0) {
                throw IndexOutOfBoundsException("index: $index, size: $size")
            }
        }
    }

    private inner class IteratorImpl(
            private var index: Int = 0
    ) : MutableIterator<T> {
        private var current: Node<T>? = null
        private var lastReturned: Node<T>? = null

        init {
            checkPositionIndex(index, size)
            current = getNode(index)
        }

        override fun hasNext(): Boolean = current != null

        override fun next(): T {
            if (!hasNext()) {
                throw NoSuchElementException()
            }
            lastReturned = current
            current = current?.next
            index++
            return lastReturned?.item ?: throw NoSuchElementException()
        }

        override fun remove() {
            unlink(lastReturned ?: throw IllegalStateException())
            index--
        }

    }
}
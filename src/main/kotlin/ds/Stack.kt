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
class Stack<T> : Collection<T>, Cloneable {
    /**
     * 首节点
     */
    private var first: Node<T>? = null

    /**
     * 栈深度
     */
    private var n: Int = 0

    /**
     * 构造函数
     * @author xmmmmmovo
     * @date 2020/7/29 19:07
     * @since version-1.0
     */
    constructor()

    /**
     * 拷贝构造函数
     * @author xmmmmmovo
     * @date 2020/7/29 19:07
     * @since version-1.0
     */
    constructor(s: Stack<T>) {
        for (i in s) {
            push(i)
        }
    }


    /**
     * 判断是否为空
     * @author xmmmmmovo
     * @date 2020/7/29 19:07
     * @return 返回是否为空
     * @since version-1.0
     */
    override fun isEmpty(): Boolean = first == null


    /**
     * 栈大小
     * @author xmmmmmovo
     * @date 2020/7/29 19:07
     * @since version-1.0
     */
    override val size: Int
        get() = n

    /**
     * 是否包含某元素
     * @author xmmmmmovo
     * @date 2020/7/29 19:08
     * @param element 查找的元素
     * @return 是否包含
     * @since version-1.0
     */
    override fun contains(element: T): Boolean {
        return indexOf(element) != -1
    }


    /**
     * 是否包含传入参数的所有元素
     * @author xmmmmmovo
     * @date 2020/7/29 19:08
     * @param elements 需要查找的元素列表
     * @return 是否包含所有
     * @since version-1.0
     */
    override fun containsAll(elements: Collection<T>): Boolean =
        if (elements.isEmpty())
            false
        else
            elements.all {
                contains(it)
            }


    /**
     * 查看某元素的位置
     * @author xmmmmmovo
     * @date 2020/7/29 19:09
     * @param element 需要查找的元素
     * @return 位置，未找到就返回-1
     * @since version-1.0
     */
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
     * @author xmmmmmovo
     * @date 2020/7/29 19:10
     * @param item 入栈元素
     * @since version-1.0
     */
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
     * @author xmmmmmovo
     * @date 2020/7/29 19:10
     * @return 返回出栈元素
     * @throws NoSuchElementException 没有元素却出栈
     * @since version-1.0
     */
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
     * 查看栈顶
     * @author xmmmmmovo
     * @date 2020/7/29 19:11
     * @return 栈顶元素
     * @throws NoSuchElementException 没有元素却查看栈顶
     * @since version-1.0
     */
    fun peek(): T {
        if (isEmpty()) {
            throw NoSuchElementException("Stack underflow")
        }
        return first?.item!!
    }

    /**
     * 拷贝函数
     * @author xmmmmmovo
     * @date 2020/7/29 19:12
     * @return 返回拷贝
     * @throws CloneNotSupportedException 不支持拷贝
     * @since version-1.0
     */
    @Throws(CloneNotSupportedException::class)
    public override fun clone(): Stack<T> {
        return super.clone() as Stack<T>
    }

    /**
     * 转字符串方法
     * @author xmmmmmovo
     * @date 2020/7/29 19:12
     * @return 字符串
     * @since version-1.0
     */
    override fun toString(): String {
        return StringBuilder().also {
            it.append("[")
            this.forEachIndexed { index, t ->
                it.append("$t")
                if (index != size - 1) it.append(" ")
            }
            it.append("]")
        }.toString()
    }

    /**
     * 返回迭代器方法
     * @author xmmmmmovo
     * @date 2020/7/29 19:13
     * @return 返回迭代器
     * @since version-1.0
     */
    override fun iterator(): Iterator<T> {
        return LinkedIterator(first)
    }

    companion object {
        /**
         * 节点类
         * @author xmmmmmovo
         * @date 2020/7/29 19:13
         * @since version-1.0
         */
        private data class Node<T>(
            val item: T,
            var next: Node<T>? = null
        )
    }

    /**
     * 迭代器类
     * @author xmmmmmovo
     * @date 2020/7/29 19:13
     * @since version-1.0
     */
    private class LinkedIterator<T>(
        /**
         * 当前节点
         */
        private var current: Node<T>?
    ) : Iterator<T> {

        /**
         * 是否有下一元素
         * @author xmmmmmovo
         * @date 2020/7/29 19:13
         * @return 是否有下一元素
         * @since version-1.0
         */
        override fun hasNext(): Boolean {
            return current != null
        }

        /**
         * 返回下一元素
         * @author xmmmmmovo
         * @date 2020/7/29 19:14
         * @return 返回下一元素
         * @since version-1.0
         */
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
/*
 * Copyright (c) 2020. xmmmmmovo
 */
package ds

/**
 * 用六个栈实现单向队列
 * @author xmmmmmovo
 * @date 2020/7/28 16:43
 * @since version-1.0
 */
class StackDequeOpt<T> {
    /**
     * 左栈
     */
    private val lst = Stack<T>()

    /**
     * 右栈
     */
    private val rst = Stack<T>()

    /**
     * 左栈替换栈 用于复制时转换
     */
    private val tlst = Stack<T>()

    /**
     * 右栈替换栈 用于复制时候入队
     */
    private val trst = Stack<T>()

    /**
     * 左翻转栈，用于保护左栈原有数据
     */
    private val lstrev = Stack<T>()

    /**
     * 用于复制过程中的出栈操作
     */
    private var hlst = Stack<T>()

    /**
     * 判断是否在复制
     */
    private var isCopying = false

    /**
     * 需要复制
     */
    private var needCopy = 0

    /**
     * 队列是否为空
     * @author xmmmmmovo
     * @date 2020/7/29 16:54
     * @return 返回是否为空
     * @since version-1.0
     */
    fun isEmpty(): Boolean =
        lst.isEmpty() && rst.isEmpty()


    /**
     * 入右队列
     * @author xmmmmmovo
     * @date 2020/7/29 16:55
     * @param element 入元素
     * @since version-1.0
     */
    fun pushRight(element: T) {
        when {
            !isCopying && sizeDiff > 0 -> {
                needCopy = 0
                rst.push(element)
            }
            !isCopying && sizeDiff == 0 -> {
                rst.push(element)
                isCopying = true
                hlst = lst
            }
            isCopying -> {

            }
        }
    }


    /**
     * 出左队列
     * @author xmmmmmovo
     * @date 2020/7/29 16:55
     * @return 返回队列第一个元素
     * @throws NoSuchElementException 没有元素时抛出
     * @since version-1.0
     */
    fun popLeft(): T {
        TODO("Not yet implemented")
    }


    /**
     * 预览元素
     * @author xmmmmmovo
     * @date 2020/7/29 16:56
     * @return 返回队列第一个元素
     * @throws NoSuchElementException 没有元素时抛出
     * @since version-1.0
     */
    fun peekLeft(): T = if (isCopying) hlst.peek() else lst.peek()

    private fun oneStep() {

    }

    private val sizeDiff: Int
        get() = lst.size - rst.size

    val size: Int
        get() = lst.size + rst.size

    fun asList(): List<T> {
        val list = mutableListOf<T>()
        TODO("Not yet implemented")
        return list
    }

    override fun toString(): String = asList().toString()
}
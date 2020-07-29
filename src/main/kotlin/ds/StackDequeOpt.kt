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
    private var lst = Stack<T>()

    /**
     * 右栈
     */
    private var rst = Stack<T>()

    /**
     * 左栈替换栈 用于复制时转换
     */
    private var tlst = Stack<T>()

    /**
     * 右栈替换栈 用于复制时候入队
     */
    private var trst = Stack<T>()

    /**
     * 左翻转栈，用于保护左栈原有数据
     */
    private var lstrev = Stack<T>()

    /**
     * 用于复制过程中的出栈操作
     */
    private var hlst = Stack<T>()

    /**
     * 判断是否在复制
     */
    private var isCopying = false

    /**
     * 需要复制数量
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
        lst.isEmpty() && rst.isEmpty() && tlst.isEmpty() && trst.isEmpty() && lstrev.isEmpty()


    /**
     * 入右队列
     * @author xmmmmmovo
     * @date 2020/7/29 16:55
     * @param element 入元素
     * @since version-1.0
     */
    fun pushRight(element: T) {
        when {
            /**
             * 左栈大于右栈
             */
            !isCopying && sizeDiff > 0 -> {
                needCopy = 0
                rst.push(element)
            }
            /**
             * 左右栈相等的时候，因为不知道下一步操作
             * 所以提前准备来进行复制操作
             */
            !isCopying && sizeDiff == 0 -> {
                rst.push(element)
                isCopying = true
                hlst = lst.clone()
                oneStep()
                oneStep()
            }
            /**
             * 如果还在复制直接 入栈到中转栈
             * 因为原栈需要别的用处
             */
            isCopying -> {
                tlst.push(element)
                oneStep()
                oneStep()
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
        when {
            /**
             * 如果没有在copy的时候并且左大于右则直接左栈弹出
             */
            !isCopying && sizeDiff > 0 -> {
                return lst.pop()
            }
            /**
             * 如果没有在复制并且左栈刚好等于右栈，那么就直接弹出左栈
             * 这样左栈小于右栈，进入复制状态
             */
            !isCopying && sizeDiff == 0 -> {
                val t = lst.pop()
                hlst = lst.clone()
                isCopying = true
                oneStep()
                oneStep()
                return t
            }
            /**
             * 因为复制状态下，所有左栈元素会到hlst中所以直接hlst出栈
             */
            else -> {
                val t = hlst.pop()
                needCopy--
                oneStep()
                oneStep()
                return t
            }
        }
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

    /**
     * 中间操作 这里是脱离了入栈出栈操作的额外操作
     * @author xmmmmmovo
     * @date 2020/7/29 20:32
     * @since version-1.0
     */
    private fun oneStep() {
        when {
            /**
             * 正在copy的时候左右栈都不是空的，这说明需要进行交换了
             * 本次这里右栈进入左栈中转栈
             * 左栈进入左栈反转栈(用于后面直接替换
             */
            isCopying && lst.isNotEmpty() && rst.isNotEmpty() -> {
                needCopy++
                tlst.push(rst.pop())
                lstrev.push(lst.pop())
            }
            /**
             * 此状态说明此时左栈已经完成转移，右栈还有剩余
             * 把右栈的元素移动到左栈中转栈中
             */
            isCopying && lst.isEmpty() && rst.isNotEmpty() -> {
                isCopying = true
                tlst.push(rst.pop())
            }
            /**
             * 此时说明左右栈都是空栈了
             * 但是需要复制的数量大于1
             * 就说明lstrev还有剩余可以转移的元素
             * 直接转移到左中转栈用于后面计算
             */
            isCopying && lst.isEmpty() && rst.isEmpty() && needCopy > 1 -> {
                isCopying = true
                needCopy--
                tlst.push(lstrev.pop())
            }
            /**
             * 如果左右栈都为空， 并且仅有一个需要复制的
             * 那么就直接把最后一个元素并入左栈中转栈
             * 中转栈转为主栈 就完成了一个循环
             */
            isCopying && lst.isEmpty() && rst.isEmpty() && needCopy == 1 -> {
                isCopying = false
                needCopy--
                tlst.push(lstrev.pop())
                lst = tlst
                rst = trst
                tlst = Stack()
                trst = Stack()
                lstrev = Stack()
                hlst = Stack()
            }
            /**
             * 同上
             */
            isCopying && lst.isEmpty() && rst.isEmpty() && needCopy == 0 -> {
                isCopying = false
                lst = tlst
                rst = trst
                tlst = Stack()
                trst = Stack()
                lstrev = Stack()
                hlst = Stack()
            }
        }
    }

    /**
     * 左栈-右栈大小的差值
     * @author xmmmmmovo
     * @date 2020/7/29 20:33
     * @since version-1.0
     */
    private val sizeDiff: Int
        get() = lst.size - rst.size

    /**
     * 队列总长度
     * @author xmmmmmovo
     * @date 2020/7/29 20:33
     * @since version-1.0
     */
    val size: Int
        get() = lst.size + rst.size + tlst.size + trst.size + lstrev.size
}
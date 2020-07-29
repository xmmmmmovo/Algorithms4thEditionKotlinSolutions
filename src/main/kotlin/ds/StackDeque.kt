/*
 * Copyright (c) 2020. xmmmmmovo
 */
package ds

/**
 * 使用三个栈实现双向队列，使得所有操作为O(1)
 * @author xmmmmmovo
 * @date 2020/7/28 16:44
 * @since version-1.0
 */
class StackDeque<T> {
    /**
     * 左栈
     */
    private val lst = Stack<T>()

    /**
     * 右栈
     */
    private val rst = Stack<T>()

    /**
     * 中间栈
     */
    private val tst = Stack<T>()

    /**
     * 表示储存的是左栈还是右栈
     */
    private var tmpIsRight = false


    /**
     * 判断是否为空
     * @author xmmmmmovo
     * @date 2020/7/29 17:27
     * @return 返回是否为空
     * @since version-1.0
     */
    fun isEmpty(): Boolean =
        lst.isEmpty() && rst.isEmpty() && tst.isEmpty()

    /**
     * 入左队列
     * @author xmmmmmovo
     * @date 2020/7/29 16:55
     * @param element 入元素
     * @since version-1.0
     */
    fun pushLeft(element: T) {
        lst.push(element)
    }

    /**
     * 入右队列
     * @author xmmmmmovo
     * @date 2020/7/29 16:55
     * @param element 入元素
     * @since version-1.0
     */
    fun pushRight(element: T) {
        rst.push(element)
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
        return when {
            /*
            * 这里如果左栈有值的话就说明要么左边插入值了
            * 要么右边或者中转栈转移到了左栈，无论哪种情况都是栈顶就是最左
            * 直接出栈就可以
            * */
            lst.isNotEmpty() -> lst.pop()
            /**
             * 这里先判断中转栈内容是否是存的右栈的内容
             * 判断如果是右栈的内容，再判断中转栈是否是空的
             * 如果不是就说明右栈已经转移到中转栈中了
             * 相当于移动到了左栈，所以直接弹出中转栈
             * */
            tst.isNotEmpty() && tmpIsRight -> tst.pop()
            /**
             * 这里先判断中转栈内容是否是存的右栈的内容
             * 判断如果不是右栈的内容，再判断中转栈是否是空的
             * 如果不是就说明是左栈移动到了中栈了
             * 相当于移动到了右栈，所以先弹出到左栈再弹出左栈
             * */
            tst.isNotEmpty() && !tmpIsRight -> {
                while (tst.isNotEmpty())
                    lst.push(tst.pop())
                lst.pop()
            }
            /**
             * 这里如果是中转栈是空的并且右栈不为空
             * 就直接转移到中转栈再弹出中转栈
             * */
            tst.isEmpty() && rst.isNotEmpty() -> {
                while (rst.isNotEmpty())
                    tst.push(rst.pop())
                tmpIsRight = true // 存的是右栈
                tst.pop()
            }
            /**
             * 所有栈都没有内容，自然就抛出异常
             * */
            else -> throw NoSuchElementException("Stack underflow")
        }
    }

    /**
     * 出右队列
     * @author xmmmmmovo
     * @date 2020/7/29 16:55
     * @return 返回队列第一个元素
     * @throws NoSuchElementException 没有元素时抛出
     * @since version-1.0
     */
    fun popRight(): T {
        return when {
            rst.isNotEmpty() -> rst.pop()
            tst.isNotEmpty() && !tmpIsRight -> tst.pop()
            tst.isNotEmpty() && tmpIsRight -> {
                while (!tst.isEmpty())
                    rst.push(tst.pop())
                rst.pop()
            }
            tst.isEmpty() && lst.isNotEmpty() -> {
                while (lst.isNotEmpty())
                    tst.push(lst.pop())
                tmpIsRight = false // 存的是左栈
                tst.pop()
            }
            else -> throw NoSuchElementException("Stack underflow")
        }
    }

    /**
     * 队列长度
     * @author xmmmmmovo
     * @date 2020/7/29 17:29
     * @since version-1.0
     */
    val size: Int
        get() = lst.size + rst.size + tst.size

    /**
     * 转换为列表格式
     * @author xmmmmmovo
     * @date 2020/7/29 17:29
     * @return 转换后的列表格式
     * @since version-1.0
     */
    fun asList(): List<T> {
        val list = mutableListOf<T>()
        lst.forEach {
            list.add(it)
        }
        // 如果非空那就得判断tmp里面存储的是左还是右了
        // 但是右栈一定要翻转
        tst.run {
            if (tmpIsRight) this else reversed()
        }.forEach { list.add(it) }
        rst.reversed().forEach {
            list.add(it)
        }
        return list
    }

    /**
     * 转字符串方法
     * @author xmmmmmovo
     * @date 2020/7/29 17:29
     * @return 字符串
     * @since version-1.0
     */
    override fun toString(): String = asList().toString()
}
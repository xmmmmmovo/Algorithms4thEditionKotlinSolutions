package ds

import utils.*

/*
 *  @Description 用六个栈实现队列
 *  @Author xmmmmmovo
 *  @Version 1.0
 **/
class StackDequeOpt<T> {
    // 左栈
    private val lst = Stack<T>()

    // 右栈
    private val rst = Stack<T>()

    // 左栈替换栈
    private val tlst = Stack<T>()

    // 右栈替换栈
    private val trst = Stack<T>()

    fun isEmpty(): Boolean =
            lst.isEmpty() && rst.isEmpty()

    /**
     * 入右队列
     * */
    fun pushRight(element: T) {
        rst.push(element)
    }

    /**
     * 出左队列(对应的是入右队列
     * */
    fun popLeft(): T {
        TODO("Not yet implemented")
    }

    /**
     * 根据左栈状态peek
     * */
    fun peekLeft(): T {
        TODO("Not yet implemented")
    }

    val size: Int
        get() = lst.size + rst.size

    fun asList(): List<T> {
        val list = mutableListOf<T>()
        TODO("Not yet implemented")
        return list
    }

    override fun toString(): String = asList().toString()
}
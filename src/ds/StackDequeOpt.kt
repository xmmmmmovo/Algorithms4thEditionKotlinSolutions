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

    // 中间栈
    private val tst = Stack<T>()

    fun isEmpty(): Boolean =
            lst.isEmpty() && rst.isEmpty() && tst.isEmpty()

    /**
     * 入左队列
     * */
    fun pushLeft(element: T) {
        TODO("Not yet implemented")
    }

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
     * 出右队列(对应的是出左队列
     * */
    fun popRight(): T {
        TODO("Not yet implemented")
    }

    val size: Int
        get() = lst.size + rst.size + tst.size

    fun asList(): List<T> {
        val list = mutableListOf<T>()
        TODO("Not yet implemented")
        return list
    }

    override fun toString(): String = asList().toString()
}
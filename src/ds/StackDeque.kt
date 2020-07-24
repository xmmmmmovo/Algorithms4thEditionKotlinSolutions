package ds

/*
 * 使用三个栈实现队列
 * 使得所有操作都是O(1)
 *  @Author xmmmmmovo
 *  @Version 1.0
 **/
class StackDeque<T> : Collection<T> {
    // 左栈
    private val lst = Stack<T>()

    // 右栈
    private val rst = Stack<T>()

    // 中间栈
    private val tst = Stack<T>()

    // 表示存储的栈位置
    private var tmpIsRight = false


    override fun isEmpty(): Boolean =
            lst.isEmpty() && rst.isEmpty() && tst.isEmpty()

    fun pushLeft(element: T) {
        lst.push(element)
    }

    fun pushRight(element: T) {
        rst.push(element)
    }

    fun popLeft(): T {

    }

    fun popRight(): T {

    }

    override val size: Int
        get() = lst.size + rst.size + tst.size

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
    }

    override fun toString(): String {
    }

    override fun iterator(): Iterator<T> {
    }

    private class IteratorImpl<T> : Iterator<T> {
        override fun hasNext(): Boolean {
            TODO("Not yet implemented")
        }

        override fun next(): T {
            TODO("Not yet implemented")
        }
    }
}
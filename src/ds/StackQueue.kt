package ds

/*
 * 使用三个栈实现队列
 * 使得所有操作都是O(1)
 *  @Author xmmmmmovo
 *  @Version 1.0
 **/
class StackQueue<T> : Collection<T> {


    override fun isEmpty() {

    }

    fun pushLeft(element: T) {

    }

    fun pushRight(element: T) {

    }

    fun popLeft(): T {

    }

    fun popRight(): T {

    }

    override val size: Int
        get() = {

        }

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
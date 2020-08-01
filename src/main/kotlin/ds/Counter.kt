/*
 * Copyright (c) 2020. xmmmmmovo
 */
package ds

/**
 * 计数器类
 * @author xmmmmmovo
 * @date 2020/7/28 16:46
 * @since version-1.0
 */
class Counter constructor(
    private val tag: String = "",
    private var count: Int = 0
) : Comparable<Counter> {

    /**
     * 计数器+1
     * */
    fun increment() {
        count += 1
    }

    /**
     * 结尾多少count
     * */
    val tally: Int
        get() = count

    override fun compareTo(other: Counter): Int {
        if (this.count < other.count)
            return -1
        else if (this.count > other.count)
            return 1
        return 0
    }

    override fun equals(other: Any?): Boolean =
        when (other) {
            is Counter -> this.tally == other.tally
            else -> false
        }

    override fun toString(): String {
        return "$tag $count times"
    }

}
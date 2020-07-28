/*
 * Copyright (c) 2020. xmmmmmovo
 */
package algorithms

import ds.CircularLinkedList
import ds.Deque

/**
 * 约瑟夫环实现
 * @author xmmmmmovo
 * @date 2020/7/28 12:10
 * @since version-1.0
 */
class JosephusSolutions(
        private var totalPeople: Int = 0,
        private var intervalPeople: Int = 0,
        private var remainPeople: Int = 1
) {
    /**
     * 初始化
     * @author xmmmmmovo
     * @date 2020/7/28 12:10
     * @since version-1.0
     */
    init {
        checkArguments()
    }

    /**
     * 参数检查
     * @author xmmmmmovo
     * @date 2020/7/28 12:10
     * @throws IllegalArgumentException 参数异常
     * @since version-1.0
     */
    private fun checkArguments() {
        if (
                totalPeople <= 0 || remainPeople <= 0 || intervalPeople <= 0
        ) {
            throw IllegalArgumentException("人数不能小于等于0！")
        }

        if (totalPeople < remainPeople)
            throw IllegalArgumentException("总人数不能小于剩余人数！")
    }

    /**
     * 更改人数
     * @author xmmmmmovo
     * @date 2020/7/28 12:11
     * @param totalPeople 总人数
     * @param intervalPeople 间隔人数
     * @param remainPeople 剩余人数
     * @since version-1.0
     */
    fun changePeopleNumbers(
            totalPeople: Int = this.totalPeople,
            intervalPeople: Int = this.intervalPeople,
            remainPeople: Int = this.remainPeople
    ) {
        this.totalPeople = totalPeople
        this.intervalPeople = intervalPeople
        this.remainPeople = remainPeople
        checkArguments()
    }

    /**
     * 双向队列求法 就是嗯求
     * @author xmmmmmovo
     * @date 2020/7/28 12:12
     * @return 返回剩余人数列表的字符串形式
     * @since version-1.0
     */
    fun queueForceSolution(): String {
        val sb = StringBuilder()
        // 初始化队列
        val deque = Deque<Int>().apply {
            for (i in 1..totalPeople)
                pushRight(i)
        }

        // 没有到剩余人数就继续循环
        while (deque.size != remainPeople) {
            // 跳过间隔人数
            // 这里的跳过为了不影响后面的循环做的是左出右进的方案
            for (q in 1 until intervalPeople)
                deque.pushRight(deque.popLeft())
            deque.popLeft()
        }

        return sb.apply {
            deque.forEachIndexed { index, i ->
                append("${i}号")
                if (index != deque.size - 1) append(", ")
            }
        }.toString()
    }

    /**
     * 双向链表解法
     * @author xmmmmmovo
     * @date 2020/7/28 12:13
     * @return 返回剩余人数列表的字符串形式
     * @since version-1.0
     */
    fun linkedListForceSolution(): String {
        val sb = StringBuilder()
        val cl = CircularLinkedList<Int>().apply {
            for (i in 1..totalPeople)
                add(i)
        }
        val iter = cl.iterator()

        var cnt = 0
        while (iter.hasNext() && cl.size != remainPeople) {
            iter.next()
            cnt++
            if (cnt == intervalPeople) {
                iter.remove()
                cnt = 0
            }
        }

        return sb.apply {
            cl.forEachIndexed { index, i ->
                append("${i}号")
                if (index != cl.size - 1) append(", ") else return@apply
            }
        }.toString()
    }

    /**
     * 数学解法
     * @author xmmmmmovo
     * @date 2020/7/28 12:12
     * @return 返回剩余人数列表的字符串形式
     * @since version-1.0
     */
    fun mathFastSolution(): String {
        val sb = StringBuilder()
        val k = MutableList(remainPeople) { it }
        for (idx in remainPeople + 1..totalPeople) {
            k.forEachIndexed { index, i ->
                k[index] = (i + intervalPeople) % idx
            }
        }
        return sb.apply {
            k.map { it + 1 }.forEachIndexed { index, i ->
                append("${i}号")
                if (index != k.size - 1) append(", ")
            }
        }.toString()
    }
}
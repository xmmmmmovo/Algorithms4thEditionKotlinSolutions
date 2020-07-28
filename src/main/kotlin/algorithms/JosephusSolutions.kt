/*
 * Copyright (c) 2020. xmmmmmovo
 */
package algorithms

import ds.CircularLinkedList
import ds.Deque

/*
 * 约瑟夫环实现
 *  @Author xmmmmmovo
 *  @Version 1.0
 **/
class JosephusSolutions(
        private var totalPeople: Int = 0,
        private var intervalPeople: Int = 0,
        private var remainPeople: Int = 1
) {
    init {
        checkArguments()
    }

    private fun checkArguments() {
        if (
                totalPeople <= 0 || remainPeople <= 0 || intervalPeople <= 0
        ) {
            throw IllegalArgumentException("人数不能小于等于0！")
        }

        if (totalPeople < remainPeople)
            throw IllegalArgumentException("总人数不能小于剩余人数！")
    }

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
     * 双向队列暴力求法
     * 就是嗯求
     * */
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
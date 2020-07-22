package algorithms

import ds.CircularLinkedList
import ds.Deque

class JosephusSolutions(
    private var totalPeople: Int = 0,
    private var intervalPeople: Int = 0,
    private var remainPeople: Int = 1
) {
    init {
        if (
            totalPeople <= 0 || remainPeople <= 0 || intervalPeople <= 0
        ) {
            throw IllegalArgumentException("人数不能小于等于0！")
        }
    }

    fun changePeopleNumbers(
        totalPeople: Int,
        intervalPeople: Int,
        remainPeople: Int
    ) {
        this.totalPeople = totalPeople
        this.intervalPeople = intervalPeople
        this.remainPeople = remainPeople
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

    fun likedListForceSolution(): String {
        val sb = StringBuilder()
        val cl = CircularLinkedList<Int>().apply {
        }



        return sb.apply {
            cl.forEachIndexed { index, i ->
                append("${i}号")
                if (index != cl.size - 1) append(", ")
            }
        }.toString()
    }
}
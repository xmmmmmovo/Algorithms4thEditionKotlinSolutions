package algorithms

import ds.Deque

class JosephusSolutions(
    private val totalPeople: Int = 0,
    private val remainPeople: Int = 0,
    private val intervalPeople: Int = 0
) {
    init {
        if (
            totalPeople <= 0 || remainPeople <= 0 || intervalPeople <= 0
        ) {
            throw IllegalArgumentException("人数不能小于等于0！")
        }
    }

    /**
     * 函数
     * */
    fun queueForceSolution(): String {
        val sb = StringBuilder()
        val deque = Deque<Int>().apply {
            for (i in 1..totalPeople)
                pushRight(i)
        }

        while (deque.size != remainPeople) {
            for (q in 1 until intervalPeople)
                deque.pushRight(deque.popLeft())
            deque.popLeft()
        }
        listOf<Int>().indices

        return with(sb) {

            return this.toString()
        }
    }
}
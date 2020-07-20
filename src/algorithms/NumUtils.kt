package algorithms

import ds.LinkedList

/**
 * 蛮力法求四数之和
 * */
fun fourSumForce(list: List<Int>, num: Int): Int {
    var cnt = 0

    for (a in list.indices)
        for (b in a until list.size)
            for (c in b until list.size)
                for (d in c until list.size)
                    if (list[a] + list[b] + list[c] + list[d] == num) {
                        cnt++
                    }
    return cnt
}

/**
 * 二分求非重复三数之和
 * */
fun threeSumBinaryFast(list: List<Int>): List<List<Int>> {
    var res = LinkedList<List<Int>>()
    val sl = list.sorted().run {
        if (containsDuplicatesInSorted(this))
            distinct()
        else
            this
    }
    if (list.size < 3) throw IllegalArgumentException("数组非重复元素小于3个!")
    for (i in sl.indices) {
        for (j in i until sl.size) {
            val k = binarySearch(sl, -(sl[i] + sl[j]), j + 1)
            if (k != -1) {
                res.add(listOf(sl[i], sl[j], sl[k]))
            }
        }
    }

    return res
}
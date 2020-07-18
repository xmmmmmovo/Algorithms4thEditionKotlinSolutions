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

/**
 * 双指针求可重复三数之和
 * */
fun threeSumDoublePointFast(list: List<Int>): List<List<Int>> {
    if (list.size < 3) throw IllegalArgumentException("数组元素小于3个!")
    var res = LinkedList<List<Int>>()
    // 依旧是先排序
    val sl = list.sorted()
    for (i in 0 until sl.size - 2) {
        // 这里是短路或,所以不会出现异常
        if (i == 0 || sl[i] != sl[i - 1]) {
            val lo = i + 1
            val hi = sl.size - 1
            val sum = 0 - sl[i]
        }
    }

    return res
}
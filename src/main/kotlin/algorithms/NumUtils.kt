/*
 * Copyright (c) 2020. xmmmmmovo
 */
package algorithms

import ds.LinkedList

/**
 * 蛮力法求三数之和
 * @author xmmmmmovo
 * @date 2020/7/28 16:09
 * @param list 数字列表
 * @param num 所求的数字
 * @return 满足条件的个数
 * @since version-1.0
 */
fun threeSumForce(list: List<Int>, num: Int): List<List<Int>> {
    val res = LinkedList<List<Int>>()

    for (a in list.indices)
        for (b in a + 1 until list.size)
            for (c in b + 1 until list.size)
                if (list[a] + list[b] + list[c] == num) {
                    res.add(listOf(list[a], list[b], list[c]))
                }
    return res
}

/**
 * 二分法[binarySearch]求三数之和
 * @author xmmmmmovo
 * @date 2020/7/28 16:09
 * @param list 数字列表
 * @return 满足和为0的所有组合的列表
 * @throws IllegalArgumentException 数组元素小于3个时抛出异常
 * @since version-1.0
 */
fun threeSumBinaryFast(list: List<Int>): List<List<Int>> {
    val res = LinkedList<List<Int>>()
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
 * 局部最小元素
 * @author xmmmmmovo
 * @date 2020/7/30 19:36
 * @param list 数字列表
 * @return 最小元素数字
 * @throws IllegalArgumentException 数组元素小于3个时抛出异常
 * @since version-1.0
 */
fun PartialMinElem(list: List<Int>): Int {
    if (list.size < 3) throw IllegalArgumentException("数组元素小于3个！")
    var lo = 0
    var hi = list.size - 1

    while (lo <= hi) {

    }

    return Double.NaN.toInt()
}
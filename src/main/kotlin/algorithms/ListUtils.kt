/*
 * Copyright (c) 2020. xmmmmmovo
 */
package algorithms

import ext.compareTo
import ext.minus

/**
 * 查找列表中是否存在某元素，利用[binarySearch]二分查找
 * @author xmmmmmovo
 * @date 2020/7/28 11:49
 * @param list 列表
 * @param key 需要查找的元素
 * @return 返回是否存在
 * @since version-1.0
 */
fun <T : Comparable<T>> containsInList(list: List<T>, key: T): Boolean {
    val sorted = list.sorted()
    val res = binarySearch(sorted, key)
    return res != -1
}

/**
 * 查找已排序元素中是否有重复元素
 * @author xmmmmmovo
 * @date 2020/7/28 11:50
 * @param list 列表
 * @return 是否存在重复元素
 * @since version-1.0
 */
fun <T : Comparable<T>> containsDuplicatesInSorted(list: List<T>): Boolean {
    for (i in 0 until list.size - 1) {
        if (list[i] == list[i + 1]) return true
    }
    return false
}

/**
 * 求一个列表中两者之差绝对值最小的两个数
 * @author xmmmmmovo
 * @date 2020/7/30 13:51
 * @param list 传入的列表
 * @return 返回差最小的两个数字
 * @throws IllegalArgumentException 如果列表元素小于2个就会抛出
 * @since version-1.0
 */
fun <T : Number> minPair(list: List<T>): Pair<T, T> {
    if (list.size < 2) throw IllegalArgumentException("列表元素过少！")
    val sl = list.sortedBy { it.toDouble() }
    var min = sl[0]
    var smin = sl[1]
    var diff = sl[1] - sl[0]
    for (i in 1 until list.size - 1) {
        if (sl[i + 1] - sl[i] < diff) {
            min = sl[i]
            smin = sl[i + 1]
            diff = smin - min
        }
    }
    return Pair(min, smin)
}

/**
 * 求一个列表中两者之差绝对值最大的两个数
 * @author xmmmmmovo
 * @date 2020/7/30 13:51
 * @param list 传入的列表
 * @return 返回差最大的两个数字
 * @throws IllegalArgumentException 如果列表元素小于2个就会抛出
 * @since version-1.0
 */
fun <T : Comparable<T>> maxPair(list: List<T>): Pair<T, T> {
    if (list.size < 2) throw IllegalArgumentException("列表元素过少！")
    var min = list[0]
    var max = list[1]
    for (it in list) {
        if (it > max)
            max = it
        if (it < min)
            min = it
    }
    return Pair(min, max)
}
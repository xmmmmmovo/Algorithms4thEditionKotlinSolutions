/*
 * Copyright (c) 2020. xmmmmmovo
 */
package algorithms

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

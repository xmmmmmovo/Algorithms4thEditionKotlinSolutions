/*
 * Copyright (c) 2020. xmmmmmovo
 */
package algorithms

/**
 * aaaaaaaa
 * @author xmmmmmovo
 * @date 2020/7/28 11:46
 * @param list 列表
 * @param key 需要查找的值
 * @param lo 左范围
 * @param hi 右范围
 * @return 查找到了就返回下标，没查找到就返回-1
 * @since version-1.0
 */
fun <T : Comparable<T>> binarySearch(
    list: List<T>, key: T, lo: Int = 0, hi: Int = list.size - 1
): Int {

    var lo = lo
    var hi = hi

    while (lo <= hi) {
        val mid = lo + (hi - lo) / 2
        when {
            key < list[mid] -> {
                hi = mid - 1
            }
            key > list[mid] -> {
                lo = mid + 1
            }
            else -> {
                return mid
            }
        }
    }

    return -1
}

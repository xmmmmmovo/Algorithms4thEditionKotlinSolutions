/*
 * Copyright (c) 2020. xmmmmmovo
 */
package algorithms

import edu.princeton.cs.algs4.In
import ext.compareTo
import kotlin.math.acos

/**
 * 在一个列表中二分查找到某个值
 * @author xmmmmmovo
 * @date 2020/7/28 11:46
 * @param list 列表
 * @param key 需要查找的值
 * @param _lo 左范围 默认为0
 * @param _hi 右范围 默认为list.size - 1
 * @return 查找到了就返回下标，没查找到就返回-1
 * @since version-1.0
 */
fun <T : Comparable<T>> binarySearch(
    list: List<T>, key: T, _lo: Int = 0, _hi: Int = list.size - 1
): Int {

    var lo = _lo
    var hi = _hi

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

/**
 * 局部最小元素
 * @author xmmmmmovo
 * @date 2020/7/30 19:36
 * @param list 数字列表
 * @param _lo 左边界 默认为0
 * @param _hi 右边界 默认为list.size - 1
 * @return 最小元素下标
 * @throws IllegalArgumentException 数组元素小于3个时抛出异常
 * @since version-1.0
 */
fun partialMinElem(
    list: List<Number>, _lo: Int = 0, _hi: Int = list.size - 1
): Int {
    var lo = _lo
    var hi = _hi

    while (lo <= hi) {
        // 取mid
        val mid = lo + (hi - lo) / 2
        /**
         * 这里分为三个情况
         * ↘↗直接返回
         * ↗↗往左走
         * ↗↘都可以，原题是往小的地方走(因为部分排序过的数组会更快)
         * ↘↘往右走
         * 总之就是往小的地方走
         */
        when {
            mid == _lo ->
                if (list[mid] < list[mid + 1]) return mid
                else lo = mid + 1
            mid == _hi ->
                if (list[mid] < list[mid - 1]) return mid
                else hi = mid - 1
            list[mid - 1] > list[mid] && list[mid] < list[mid + 1] -> {
                return mid
            }
            list[mid - 1] < list[mid] && list[mid] < list[mid + 1] -> {
                hi = mid - 1
            }
            list[mid - 1] < list[mid] && list[mid] > list[mid + 1] -> {
                if (list[mid - 1] >= list[mid + 1]) lo = mid + 1
                else hi = mid - 1
            }
            else -> {
                lo = mid + 1
            }
        }
    }

    // 当所有元素都是一样的时候才没有最小值，返回-1
    return -1
}

/**
 * 局部最大元素
 * @author xmmmmmovo
 * @date 2020/7/30 19:36
 * @param list 数字列表
 * @param _lo 左边界 默认为0
 * @param _hi 右边界 默认为list.size - 1
 * @return 最大元素下标
 * @throws IllegalArgumentException 数组元素小于3个时抛出异常
 * @since version-1.0
 */
fun partialMaxElem(
    list: List<Number>, _lo: Int = 0, _hi: Int = list.size - 1
): Int {
    var lo = _lo
    var hi = _hi

    while (lo <= hi) {
        // 取mid
        val mid = lo + (hi - lo) / 2
        when {
            mid == _lo ->
                if (list[mid] > list[mid + 1]) return mid
                else lo = mid + 1
            mid == _hi ->
                if (list[mid] > list[mid - 1]) return mid
                else hi = mid - 1
            list[mid - 1] < list[mid] && list[mid] > list[mid + 1] -> {
                return mid
            }
            list[mid - 1] > list[mid] && list[mid] > list[mid + 1] -> {
                hi = mid - 1
            }
            list[mid - 1] > list[mid] && list[mid] < list[mid + 1] -> {
                if (list[mid - 1] <= list[mid + 1]) lo = mid + 1
                else hi = mid - 1
            }
            else -> {
                lo = mid + 1
            }
        }
    }

    // 当所有元素都是一样的时候才没有最小值，返回-1
    return -1
}

/**
 * 双调查找
 * @author xmmmmmovo
 * @date 2020/7/31 15:42
 * @param
 * @return
 * @throws
 * @since version-1.0
 */
fun <T : Comparable<T>> doubleToneSearch(
    list: List<T>, key: T, _lo: Int = 0, _hi: Int = list.size - 1
): Int {
    var lo = _lo
    var hi = _hi

    while (lo <= hi) {
        val mid = lo + (lo + hi) / 2
        when {
            list[mid] == key -> return mid
            // 往大的地方走
            list[mid] < key -> {
                when {
//                    mid - 1 == _lo ->
                }
            }
            else -> {

            }

        }
    }

    return -1
}

/**
 * 斐波那契二分搜索
 * @author xmmmmmovo
 * @date 2020/7/31 16:09
 * @param
 * @return
 * @since version-1.0
 */
fun fibonacciBinarySearch() {
}
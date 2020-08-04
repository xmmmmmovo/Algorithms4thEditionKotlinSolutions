/*
 * Copyright (c) 2020. xmmmmmovo
 */

package algorithms

/**
 * 创建斐波那契数列
 * @author xmmmmmovo
 * @date 2020/8/3 1:01
 * @param length 数列长度
 * @return 数列
 * @since version-1.0
 */
fun makeFibonacciList(length: Int): List<Int> =
    when (length) {
        0 -> emptyList()
        1 -> listOf(1)
        2 -> listOf(1, 1)
        else -> {
            val fl = mutableListOf<Int>(1, 1)
            for (i in 1 until length - 1) {
                fl.add(fl[i] + fl[i - 1])
            }
            fl
        }
    }

/**
 * 创建最大值大于[length]的第一个数
 * @author xmmmmmovo
 * @date 2020/8/3 1:01
 * @param length 最长值
 * @return 数列
 * @since version-1.0
 */
fun makeFibonacciListUntilLength(length: Int): List<Int> {
    return when (length) {
        0 -> emptyList()
        1 -> listOf(1, 1, 2)
        2 -> listOf(1, 1, 2, 3, 5)
        else -> {
            val fl = mutableListOf(1, 1)
            var nv = 2
            while (length > nv - 1) {
                fl.add(nv)
                nv += fl[fl.size - 2]
            }
            fl.add(nv)
            fl
        }
    }
}

/**
 * 斐波那契二分搜索
 * @author xmmmmmovo
 * @date 2020/7/31 16:09
 * @param list 列表
 * @param key 需要查找的值
 * @param _lo 左范围 默认为0
 * @param _hi 右范围 默认为list.size - 1
 * @return 查找到了就返回下标，没查找到就返回-1
 * @since version-1.0
 */
fun <T : Comparable<T>> fibonacciBinarySearch(
    list: List<T>, key: T, _lo: Int = 0, _hi: Int = list.size - 1
): Int {
    if (list.isEmpty()) return -1
    if (list.size < 3) return list.indexOf(key)

    // 此时最末尾的值肯定是刚好大于长度的那个
    val fbl = makeFibonacciListUntilLength(_hi - _lo + 1)
    val tl = list.toMutableList()
    tl.addAll(List((fbl.last() - 1 - list.size)) { list.last() })

    var lo = _lo
    var hi = if (_hi == list.lastIndex) tl.lastIndex else _hi
    var k = fbl.lastIndex

    while (lo <= hi) {
        val mid = lo + fbl[k - 1] - 1
        when {
            tl[mid] > key -> {
                hi = mid - 1
                k--
            }
            // 小堆就-2，因为少了f(n-1)的信息
            tl[mid] < key -> {
                lo = mid + 1
                k -= 2
            }
            else -> return if (mid >= _hi) list.lastIndex else mid
        }
    }

    return -1
}
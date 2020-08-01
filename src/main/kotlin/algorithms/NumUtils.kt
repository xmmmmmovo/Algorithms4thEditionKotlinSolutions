/*
 * Copyright (c) 2020. xmmmmmovo
 */
package algorithms

import ds.LinkedList
import ext.compareTo

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
    val sl = list.sorted().run {
        if (containsDuplicatesInSorted(this))
            distinct()
        else
            this
    }
    for (a in sl.indices)
        for (b in a + 1 until sl.size)
            for (c in b + 1 until sl.size)
                if (sl[a] + sl[b] + sl[c] == num) {
                    res.add(listOf(sl[a], sl[b], sl[c]))
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
fun threeSumBinaryFast(list: List<Int>, num: Int): List<List<Int>> {
    val res = LinkedList<List<Int>>()
    val sl = list.sorted().run {
        if (containsDuplicatesInSorted(this))
            distinct()
        else
            this
    }
    if (list.size < 3) throw IllegalArgumentException("数组非重复元素小于3个!")
    for (i in sl.indices) {
        for (j in i + 1 until sl.size) {
            val k = binarySearch(sl, num - (sl[i] + sl[j]), j + 1)
            if (k != -1) {
                res.add(listOf(sl[i], sl[j], sl[k]))
            }
        }
    }

    return res
}

/**
 * 矩阵局部最小元素
 * @author xmmmmmovo
 * @date 2020/7/30 19:36
 * @param matrix 矩阵
 * @return 最小元素数字
 * @throws IllegalArgumentException 矩阵为空的时候抛出异常
 * @since version-1.0
 */
fun <T : Number> matrixPartialMinElem(matrix: List<List<T>>): Pair<Int, Int> {
    if (matrix.isEmpty()) throw IllegalArgumentException("矩阵不能为空！")
    var lor = 0
    var hir = matrix.size - 1

    while (lor <= hir) {
        val mr = lor + (hir - lor) / 2
        val kc = partialMinElem(matrix[mr])

        when {
            kc == -1 -> {
                lor++
            }
            mr == 0 ->
                if (matrix[mr + 1][kc] > matrix[mr][kc])
                    return Pair(mr, kc)
                else
                    lor = mr + 1
            mr == matrix.size - 1 ->
                if (matrix[mr][kc] < matrix[mr - 1][kc])
                    return Pair(mr, kc)
                else
                    hir = mr - 1
            matrix[mr - 1][kc] > matrix[mr][kc] && matrix[mr][kc] < matrix[mr + 1][kc] ->
                return Pair(mr, kc)
            matrix[mr - 1][kc] < matrix[mr][kc] && matrix[mr][kc] < matrix[mr + 1][kc] ->
                hir = mr - 1
            matrix[mr - 1][kc] < matrix[mr][kc] && matrix[mr][kc] > matrix[mr + 1][kc] ->
                if (matrix[mr - 1][kc] >= matrix[mr + 1][kc]) lor = mr + 1 else hir = mr - 1
            else -> lor = mr + 1
        }
    }

    return Pair(-1, -1)
}
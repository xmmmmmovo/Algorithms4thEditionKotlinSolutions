/*
 * Copyright (c) 2020. xmmmmmovo
 */

package algorithms

/**
 * 冒泡排序
 * @author xmmmmmovo
 * @date 2020/8/5 8:05
 * @param list 列表
 * @param _lo 左范围 默认为0
 * @param _hi 右范围 默认为list.size - 1
 * @return 排序后数组
 * @since version-1.0
 */
fun <T : Comparable<T>> bubbleSort(
    list: List<T>, _lo: Int = 0, _hi: Int = list.size - 1
): List<T> {
    if (list.size < 2) return list

//    val sort = fun() {
//
//    }
    var cnt = 0

    val ml = list.toMutableList()

    for (i in _lo until _hi) {
        for (j in _lo until _hi - i) {
            cnt++
            if (ml[j] > ml[j + 1]) ml[j] = ml[j + 1].also {
                ml[j + 1] = ml[j]
            }
        }
    }

    println(cnt)

    return ml
}

/**
 * 插入排序
 * @author xmmmmmovo
 * @date 2020/8/5 8:05
 * @param list 列表
 * @param _lo 左范围 默认为0
 * @param _hi 右范围 默认为list.size - 1
 * @return 排序后数组
 * @since version-1.0
 */
fun <T : Comparable<T>> insertSort(
    list: List<T>, _lo: Int = 0, _hi: Int = list.size - 1
): List<T> {

}
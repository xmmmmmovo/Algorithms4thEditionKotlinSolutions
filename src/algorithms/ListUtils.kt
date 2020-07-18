package algorithms

/**
 * 二分法查找元素是否在列表中
 * */
fun <T : Comparable<T>> containsInList(list: List<T>, key: T): Boolean {
    val sorted = list.sorted()
    val res = binarySearch(sorted, key)
    return res != -1
}

/**
 * 查找已排序列表中是否有重复元素O(N)
 * */
fun <T : Comparable<T>> containsDuplicatesInSorted(list: List<T>): Boolean {
    for (i in 0 until list.size - 1) {
        if (list[i] == list[i + 1]) return true
    }
    return false
}

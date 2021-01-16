/*
 * Copyright (c) 2021. xmmmmmovo
 */

package ds

/**
 * 并查集（已合并优化）
 * @property N Int 点的个数
 * @property p MutableList<Int> 维护列表
 * @property _count Int 集合数量
 * @property count Int 集合数量（只读）
 * @constructor
 */
class UF constructor(private val N: Int = 0) {
    private val p = MutableList(N) { it }
    private var _count = N
    val count: Int
        get() = _count

    /**
     * 查找根节点
     * @param x Int 查找节点
     * @return Int 根节点
     */
    fun find(x: Int): Int {
        if (p[x] != x) p[x] = find(p[x])
        return p[x]
    }

    /**
     * 查找是否属于同一集合
     * @param x Int 节点x
     * @param y Int 节点y
     * @return Boolean 是否同属于
     */
    fun connected(x: Int, y: Int): Boolean = find(x) == find(y)

    /**
     * 合并集合
     * @param x Int 节点a
     * @param y Int 节点b
     */
    fun union(x: Int, y: Int) {
        p[find(x)] = find(y)
        _count--
    }
}
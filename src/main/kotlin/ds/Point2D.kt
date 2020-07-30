/*
 * Copyright (c) 2020. xmmmmmovo
 */
package ds

import edu.princeton.cs.algs4.StdRandom

/**
 * 2D点类
 * @author xmmmmmovo
 * @date 2020/7/28 16:45
 * @since version-1.0
 */
class Point2D constructor(
    /**
     * x坐标
     */
    val x: Double = 0.0,
    /**
     * y坐标
     */
    val y: Double = 0.0
) : Comparable<Point2D> {

    /**
     * 比较方法
     */
    override fun compareTo(other: Point2D): Int {
        if (this.x < other.x || this.y < other.y) {
            return -1
        }
        if (this.x > other.x || this.y > other.y) {
            return 1
        }
        return 0
    }

    /**
     * 转字符串方法
     */
    override fun toString(): String {
        return "x=${String.format("%.2f",x)}, y=${String.format("%.2f",y)}"
    }
}
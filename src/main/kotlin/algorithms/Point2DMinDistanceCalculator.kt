/*
 * Copyright (c) 2020. xmmmmmovo
 */
package algorithms

import ds.Point2D
import edu.princeton.cs.algs4.StdDraw
import edu.princeton.cs.algs4.StdRandom
import kotlin.math.sqrt

/**
 * 平面最近点问题类
 * @author xmmmmmovo
 * @date 2020/7/28 16:45
 * @since version-1.0
 */
class Point2DMinDistanceCalculator constructor(
    /**
     * 点个数
     */
    private val N: Int = 0
) {
    /**
     * 最近点对
     */
    private var minPointPair = Pair(Point2D(0.0, 0.0), Point2D(0.0, 0.0))

    /**
     * 随即最近点s
     */
    private val list = Array(N) {
        Point2D(
            StdRandom.uniform(0.0, N.toDouble()),
            StdRandom.uniform(0.0, N.toDouble())
        )
    }

    /**
     * 构造函数 初始化画布
     * @author xmmmmmovo
     * @date 2020/7/30 9:05
     * @since version-1.0
     */
    init {
        StdDraw.setXscale(0.0, N.toDouble())
        StdDraw.setYscale(0.0, list.maxBy { it.y }!!.y + 0.3)
        StdDraw.setPenRadius(.005)
        StdDraw.setPenRadius(.01)
        StdDraw.setPenColor(StdDraw.RED)
    }


    /**
     * 计算距离
     * @author xmmmmmovo
     * @date 2020/7/30 9:05
     * @param lp 左点
     * @param rp 右点
     * @return 返回距离
     * @since version-1.0
     */
    private fun getDistance(lp: Point2D, rp: Point2D): Double {
        return sqrt(((rp.x - lp.x) * (rp.x - lp.x)) + ((rp.y - lp.y) * (rp.y - lp.y)))
    }


    /**
     * 最近点对
     * @author xmmmmmovo
     * @date 2020/7/30 9:07
     * @return 返回最近点对
     * @since version-1.0
     */
    fun getMinPointPair(): Pair<Point2D, Point2D> {
        return minPointPair
    }


    /**
     * 显示最近点
     * @author xmmmmmovo
     * @date 2020/7/30 9:07
     * @since version-1.0
     */
    fun showPoints() {
        list.forEach {
            StdDraw.point(it.x, it.y)
        }
    }

    /**
     * 蛮力法求最近点
     * @author xmmmmmovo
     * @date 2020/7/30 9:07
     * @return 最近点距离
     * @since version-1.0
     */
    fun minDistanceForce(): Double {
        var minDistance = Double.MAX_VALUE

        if (N == 0) {
            return 0.0
        }

        for (lp in list) {
            for (rp in list) {
                if (lp != rp && getDistance(lp, rp) < minDistance) {
                    minDistance = getDistance(lp, rp)
                    minPointPair = Pair(lp, rp)
                }
            }
        }

        StdDraw.line(
            minPointPair.first.x, minPointPair.first.y,
            minPointPair.second.x, minPointPair.second.y
        )

        return minDistance
    }

    private fun divide(l: Int, r: Int): Double {
        if (r - l == 1) {
            return getDistance(list[r], list[l])
        } else if (r - l == 2) {
            return minOf(
                getDistance(list[l], list[l + 1]),
                getDistance(list[l], list[l + 2]),
                getDistance(list[l + 1], list[l + 2])
            )
        } else {

        }
        return 0.0
    }

    /**
     * TODO:分治法解最近点距离
     */
    fun minDistanceDivide(): Double {
        if (N == 0) {
            return 0.0
        }
        list.sort()
        return divide(0, list.size - 1)
    }
}
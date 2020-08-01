/*
 * Copyright (c) 2020. xmmmmmovo
 */
package ds

import edu.princeton.cs.algs4.StdDraw
import kotlin.math.sqrt

/**
 * 可视化累加器
 * @author xmmmmmovo
 * @date 2020/7/28 16:43
 * @since version-1.0
 */
class VisualAccumulator constructor(
    /**
     * X轴最大
     */
    private val xMax: Int = 100,
    /**
     * Y轴最大值
     */
    private val yMax: Double = 100.0
) {
    /**
     * 添加次数
     */
    private var times: Int = 0

    /**
     * 总值
     */
    private var total: Double = 0.0

    /**
     * 平均数
     */
    private var mean: Double = 0.0

    /**
     * 方差*([times]-1)
     */
    private var s: Double = 0.0

    init {
        try {
            StdDraw.setXscale(0.0, xMax.toDouble())
            StdDraw.setYscale(0.0, yMax)
            StdDraw.setPenRadius(.01)
        } catch (e: Exception) {
            println("No GUI!")
        }
    }

    /**
     * 添加新值
     * @author xmmmmmovo
     * @date 2020/7/28 16:40
     * @param value 添加的值
     * @since version-1.0
     */
    fun <T : Number> addDataValue(value: T) {
        times++
        val dv = value.toDouble()
        total += dv

        s += 1.0 * (times - 1) / times * (dv - mean) * (dv - mean)
        mean += (dv - mean) / times

        try {
            StdDraw.setPenColor(StdDraw.DARK_GRAY)
            StdDraw.point(times.toDouble(), value.toDouble())
            StdDraw.setPenColor(StdDraw.RED)
            StdDraw.point(times.toDouble(), mean())
            StdDraw.setPenColor(StdDraw.BLUE)
            StdDraw.point(times.toDouble(), stddev())
        } catch (e: Exception) {
            println("No GUI!")
        }
    }

    fun mean(): Double = mean

    fun variance(): Double = if (times <= 1) 0.0 else s / (times - 1)

    fun stddev(): Double = sqrt(variance())

    fun total(): Double = total

    override fun toString(): String {
        return "Mean ($times times, ${String.format("%.2f", total)} values): " +
                "${String.format("%7.5f", mean())}"
    }
}
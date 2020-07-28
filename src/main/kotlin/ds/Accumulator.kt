/*
 * Copyright (c) 2020. xmmmmmovo
 */
package ds

import kotlin.math.sqrt

/**
 * 累加器 已经增加防抖动
 * @author xmmmmmovo
 * @date 2020/7/28 16:11
 * @since version-1.0
 */
class Accumulator constructor(
    /**
     * 总值
     */
    private var total: Double = 0.0
) {
    /**
     * 添加次数
     */
    private var times: Int = 0

    /**
     * 平均数
     */
    private var mean: Double = 0.0

    /**
     * 方差*([times]-1)
     */
    private var s: Double = 0.0

    /**
     * 添加新值
     * @author xmmmmmovo
     * @date 2020/7/28 16:40
     * @param value 添加的值
     * @since version-1.0
     */
    fun <T : Number> addDataValue(value: T) {
        times += 1
        val dv = value.toDouble()
        total += dv

        s += 1.0 * (times - 1) / times * (dv - mean) * (dv - mean)
        mean += (dv - mean) / times
    }


    /**
     * 返回平均数
     * @author xmmmmmovo
     * @date 2020/7/28 16:40
     * @return 返回平均数
     * @since version-1.0
     */
    fun mean(): Double = mean

    /**
     * 返回方差
     * @author xmmmmmovo
     * @date 2020/7/28 16:40
     * @return 返回方差
     * @since version-1.0
     */
    fun variance(): Double = if (times <= 1) Double.NaN else s / (times - 1)

    /**
     * 返回标准差
     * @author xmmmmmovo
     * @date 2020/7/28 16:40
     * @return 返回标准差
     * @since version-1.0
     */
    fun stddev(): Double = sqrt(variance())

    /**
     * 返回总值
     * @author xmmmmmovo
     * @date 2020/7/28 16:40
     * @return 返回总值
     * @since version-1.0
     */
    fun total(): Double = total

    /**
     * 转字符串
     * @author xmmmmmovo
     * @date 2020/7/28 16:40
     * @return 返回字符串
     * @since version-1.0
     */
    override fun toString(): String {
        return "Mean ($times times, ${String.format("%.2f", total)} values): " +
                "${String.format("%7.5f", mean())}"
    }
}

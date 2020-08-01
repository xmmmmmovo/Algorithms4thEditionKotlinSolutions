/*
 * Copyright (c) 2020. xmmmmmovo
 */

package utils

import java.lang.management.ManagementFactory
import java.lang.management.ThreadMXBean


class StopwatchCPU {
    /**
     * 纳秒转换秒进制
     */
    private val NANOSECONDS_PER_SECOND = 1000000000.0

    /**
     * 线程计时器
     */
    private var threadTimer: ThreadMXBean = ManagementFactory.getThreadMXBean()

    /**
     * 开始标志位
     */
    private var start: Long = threadTimer.currentThreadCpuTime

    /**
     * 计算cpu使用的时间
     * @author xmmmmmovo
     * @date 2020/7/30 8:34
     * @return 返回cpu使用时间
     * @since version-1.0
     */
    fun elapsedTime(): Double {
        val now: Long = threadTimer.currentThreadCpuTime
        return (now - start) / NANOSECONDS_PER_SECOND
    }

    override fun toString(): String {
        return "${elapsedTime()}秒"
    }
}
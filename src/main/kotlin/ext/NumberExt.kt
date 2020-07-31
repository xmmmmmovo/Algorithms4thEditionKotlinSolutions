/*
 * Copyright (c) 2020. xmmmmmovo
 */

package ext

/**
 * 类扩展->比较
 * @author xmmmmmovo
 * @date 2020/7/31 9:10
 * @param other 比较的数字
 * @return 大于返回1，小于返回-1，等于返回0
 * @throws RuntimeException 未知数字类型
 * @since version-1.0
 */
operator fun Number.compareTo(other: Number): Int =
    when (other) {
        // 整数型比较
        is Long -> when {
            this.toLong() > other.toLong() -> 1
            this.toLong() < other.toLong() -> -1
            else -> 0
        }
        is Int -> when {
            this.toInt() > other.toInt() -> 1
            this.toInt() < other.toInt() -> -1
            else -> 0
        }
        is Short -> when {
            this.toShort() > other.toShort() -> 1
            this.toShort() < other.toShort() -> -1
            else -> 0
        }
        is Byte -> {
            when {
                this.toByte() > other.toByte() -> 1
                this.toByte() < other.toByte() -> -1
                else -> 0
            }
        }
        // 小数型比较
        is Float -> when {
            this.toFloat() > other.toFloat() -> 1
            this.toFloat() < other.toFloat() -> -1
            else -> 0
        }
        is Double -> {
            when {
                this.toDouble() > other.toDouble() -> 1
                this.toDouble() < other.toDouble() -> -1
                else -> 0
            }
        }
        else -> throw RuntimeException("Unknown numeric type")
    }

/**
 * 类扩展->减号
 * @author xmmmmmovo
 * @date 2020/7/31 9:10
 * @param other 减数
 * @return 返回结果
 * @throws RuntimeException 未知数字类型
 * @since version-1.0
 */
operator fun Number.minus(other: Number): Number =
    when (this) {
        is Long -> this.toLong() - other.toLong()
        is Int -> this.toInt() - other.toInt()
        is Short -> this.toShort() - other.toShort()
        is Byte -> this.toByte() - other.toByte()
        is Double -> this.toDouble() - other.toDouble()
        is Float -> this.toFloat() - other.toFloat()
        else -> throw RuntimeException("Unknown numeric type")
    }

/**
 * 类扩展->加号
 * @author xmmmmmovo
 * @date 2020/7/31 9:10
 * @param other 加数
 * @return 返回结果
 * @throws RuntimeException 未知数字类型
 * @since version-1.0
 */
operator fun Number.plus(other: Number): Number =
    when (this) {
        is Long -> this.toLong() + other.toLong()
        is Int -> this.toInt() + other.toInt()
        is Short -> this.toShort() + other.toShort()
        is Byte -> this.toByte() + other.toByte()
        is Double -> this.toDouble() + other.toDouble()
        is Float -> this.toFloat() + other.toFloat()
        else -> throw RuntimeException("Unknown numeric type")
    }

/**
 * 类扩展->乘号
 * @author xmmmmmovo
 * @date 2020/7/31 9:10
 * @param other 乘数
 * @return 返回结果
 * @throws RuntimeException 未知数字类型
 * @since version-1.0
 */
operator fun Number.div(other: Number): Number =
    when (this) {
        is Long -> this.toLong() * other.toLong()
        is Int -> this.toInt() * other.toInt()
        is Short -> this.toShort() * other.toShort()
        is Byte -> this.toByte() * other.toByte()
        is Double -> this.toDouble() * other.toDouble()
        is Float -> this.toFloat() * other.toFloat()
        else -> throw RuntimeException("Unknown numeric type")
    }

/**
 * 类扩展->除号
 * @author xmmmmmovo
 * @date 2020/7/31 9:10
 * @param other 除数
 * @return 返回结果
 * @throws RuntimeException 未知数字类型
 * @since version-1.0
 */
operator fun Number.times(other: Number): Number =
    when (this) {
        is Long -> this.toLong() / other.toLong()
        is Int -> this.toInt() / other.toInt()
        is Short -> this.toShort() / other.toShort()
        is Byte -> this.toByte() / other.toByte()
        is Double -> this.toDouble() / other.toDouble()
        is Float -> this.toFloat() / other.toFloat()
        else -> throw RuntimeException("Unknown numeric type")
    }
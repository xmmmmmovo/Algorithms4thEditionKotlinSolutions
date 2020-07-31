/*
 * Copyright (c) 2020. xmmmmmovo
 */

package utils

operator fun Number.compareTo(other: Number): Int =
    when (other) {
        // 整数型比较
        is Long, is Int, is Short, is Byte -> {
            when {
                this.toLong() > other.toLong() -> 1
                this.toLong() < other.toLong() -> -1
                else -> 0
            }
        }
        // 小数型比较
        is Float, is Double -> {
            when {
                this.toDouble() > other.toDouble() -> 1
                this.toDouble() < other.toDouble() -> -1
                else -> 0
            }
        }
        else -> throw RuntimeException("Unknown numeric type")
    }

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
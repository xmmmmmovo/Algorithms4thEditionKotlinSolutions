/*
 * Copyright (c) 2020. xmmmmmovo
 */
package utils

/**
 * @author xmmmmmovo
 * @date 2020/7/28 11:45
 * @description 用于调试类内的log
 * @param [msg]调试信息
 * @since version-1.0
 */
inline fun <reified R : Any> R.debug(msg: () -> Any?) {
    println("${R::class.qualifiedName}: ${msg().toString()}")
}

/**
 * @author xmmmmmovo
 * @date 2020/7/28 11:45
 * @description 用于调试类外的log
 * @param tag 标签
 * @param msg 调试信息
 * @since version-1.0
 */
inline fun debug(tag: String, msg: () -> Any?) {
    println("$tag: ${msg().toString()}")
}
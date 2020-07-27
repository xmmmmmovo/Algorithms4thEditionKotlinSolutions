package utils

/**
 * 用于调试
 * */
inline fun <reified R : Any> R.debug(msg: () -> Any?) {
    println("${R::class.qualifiedName}: ${msg().toString()}")
}

/**
 * 用于类外调试
 * */
inline fun debug(tag: String, msg: () -> Any?) {
    println("$tag: ${msg().toString()}")
}
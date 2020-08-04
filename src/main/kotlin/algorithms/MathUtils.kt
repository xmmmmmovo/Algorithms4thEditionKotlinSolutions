/*
 * Copyright (c) 2020. xmmmmmovo
 */
package algorithms

import ds.Stack
import java.lang.UnsupportedOperationException
import kotlin.math.abs
import kotlin.math.min
import kotlin.text.StringBuilder

/**
 * 普通gcd模板(辗转相除法)
 * @author xmmmmmovo
 * @date 2020/7/28 11:51
 * @param a 数字a
 * @param b 数字b
 * @return 返回最大公因数
 * @since version-1.0
 */
fun <T : Number> gcd(a: T, b: T): Long {
    if (a == 0) return b.toLong()
    if (b == 0) return a.toLong()
    var ta = abs(a.toLong())
    var tb = abs(b.toLong())
    while (tb != 0L) {
        ta = tb.also {
            tb = ta % tb
        }
    }
    return ta
}

/**
 * 快速gcd主函数
 * @author xmmmmmovo
 * @date 2020/7/28 11:52
 * @param a 数字a
 * @param b 数字b
 * @return 返回最大公因数
 * @since version-1.0
 */
private fun qgcd_(a: Long, b: Long): Long {
    if (a == 0L) return b
    if (b == 0L) return a

    if ((a and 1) == 0L && (b and 1) == 0L)
        return qgcd_(a shr 1, b shr 1) shl 1
    else if ((b and 1) == 0L)
        return qgcd_(a, b shr 1)
    else if ((a and 1) == 0L)
        return qgcd_(a shr 1, b)
    else
        return qgcd_(abs(a - b), min(a, b))
}

/**
 * 快速gcd对外函数
 * @author xmmmmmovo
 * @date 2020/7/28 12:15
 * @param a 数字a
 * @param b 数字b
 * @return 返回最大公因数
 * @since version-1.0
 */
fun <T : Number> qgcd(a: T, b: T): Long {
    if (a == 0) return b.toLong()
    if (b == 0) return a.toLong()
    val ta = a.toLong()
    val tb = b.toLong()
    return qgcd_(abs(ta), abs(tb))
}

/**
 * 优先级
 * 加减优先级最低
 * 然后就是乘除
 * 括号优先级最高
 * @author xmmmmmovo
 * @date 2020/7/28 12:16
 * @since version-1.0
 */
val priority = mapOf(
    '+' to 0,
    '-' to 0,
    '*' to 1,
    '/' to 1,
    '(' to 2,
    ')' to 2
)

/**
 * 中缀转后缀
 * @author xmmmmmovo
 * @date 2020/7/28 16:07
 * @param expr 表达式
 * @return 后缀表达式
 * @since version-1.0
 */
private fun infixToPostfix(expr: String): String {
    val sb = StringBuilder()
    val s = Stack<Char>()

    expr.forEach { c: Char ->
        when (c) {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> sb.append(c)
            '+', '-', '*', '/' -> {
                while (!s.isEmpty()
                    && s.peek() != '('
                    && priority[c]!! <= priority[s.peek()]!!
                ) {
                    sb.append(s.pop())
                }
                s.push(c)
            }
            '(' -> s.push(c)
            ')' -> {
                while (!s.isEmpty()) {
                    if (s.peek() == '(') {
                        s.pop()
                        break
                    } else {
                        sb.append(s.pop())
                    }
                }
            }
            else -> throw UnsupportedOperationException("未知字符!")
        }
    }
    while (!s.isEmpty()) {
        sb.append(s.pop())
    }
    return sb.toString()
}

/**
 * 计算后缀表达式
 * @author xmmmmmovo
 * @date 2020/7/28 16:07
 * @param expr 后缀表达式
 * @return 计算结果
 * @since version-1.0
 */
private fun evalPostfix(expr: String): Double {
    val s = Stack<Double>()
    expr.forEach { c: Char ->
        when (c) {
            '+' -> s.pop().plus(s.pop()).let { s.push(it) }
            '-' -> s.pop().minus(s.pop()).let { s.push(it) }
            '*' -> s.pop().times(s.pop()).let { s.push(it) }
            '/' -> s.pop().div(s.pop()).let { s.push(it) }
            else -> s.push(Character.getNumericValue(c).toDouble())
        }
    }
    return if (s.isEmpty()) 0.0 else s.pop()
}

/**
 * 四则运算主函数
 * @author xmmmmmovo
 * @date 2020/7/28 16:07
 * @param expr 表达式
 * @return 计算结果
 * @since version-1.0
 */
fun evalIntArithmetic(expr: String): Double =
    evalPostfix(
        infixToPostfix(
            expr.trim().replace(" ", "")
        )
    )

/**
 * 括号是否匹配
 * @author xmmmmmovo
 * @date 2020/7/28 16:08
 * @param expr 表达式
 * @return 返回是否匹配(注意空括号也是匹配的)
 * @since version-1.0
 */
fun isBanlanced(expr: String): Boolean {
    val s = Stack<Char>()

    expr.forEach { c: Char ->
        when (c) {
            '(', '{', '[' -> s.push(c)
            ')' -> if (s.isEmpty() || s.pop() != '(') return false
            ']' -> if (s.isEmpty() || s.pop() != '[') return false
            '}' -> if (s.isEmpty() || s.pop() != '{') return false
        }
    }

    return s.isEmpty()
}

/**
 * 括号补全
 * 双栈解法，一个用于保存数据，一个用于保存运算符
 * @author xmmmmmovo
 * @date 2020/8/4 0:50
 * @param expr 缺陷表达式
 * @return 返回补全后的表达式
 * @since version-1.0
 */
fun compleBrackets(expr: String): String {
    if (expr == "") return ""
    val numStack = Stack<String>()
    val opStack = Stack<Char>()

    var i = 0
    while (i < expr.length) {
        val sbb = StringBuilder()
        while (expr[i].isDigit()) {
            sbb.append(expr[i])
            i++
        }
        if (sbb.isNotEmpty()) numStack.push(sbb.toString())

        when {
            expr[i] == ')' -> {
                val n2 = numStack.pop()
                val n1 = numStack.pop()
                numStack.push("(${n1}${opStack.pop()}${n2})")
            }
            else -> {
                opStack.push(expr[i])
            }
        }
        i++
    }

    /**
     * 这里如果左边没出现括号，运算符栈种存在数据
     * 所以会出错，这里把运算符栈清空放到数据栈种就好了
     */
    while (opStack.isNotEmpty()) {
        val n2 = numStack.pop()
        val n1 = numStack.pop()
        numStack.push("${n1}${opStack.pop()}${n2}")
    }

    return numStack.pop()
}
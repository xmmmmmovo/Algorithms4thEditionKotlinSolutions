package fundamentals

import ds.*
import utils.*

data class tt(var string: String = "") {
}

fun test1() {
    var t = tt("11")

    var tmp = tt("22")
    println(t.string.let {
        t = tmp
    })

    println(tmp)

    for (i in 1..10)
        println(i)
}

fun main() {
    val sdo = StackDequeOpt<Int>()
    for (i in 0 until 20) {
        sdo.pushRight(i)
        if (i in listOf(5, 8, 14, 15, 19))
            for (k in 0 until 2)
                debug("pop()") { sdo.popLeft() }

        for (k in 1 until 10) {
            debug("pop()") { sdo.popLeft() }
        }
    }
}
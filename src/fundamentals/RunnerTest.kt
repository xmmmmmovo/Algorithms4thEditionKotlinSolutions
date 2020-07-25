package fundamentals

import algorithms.JosephusSolutions
import algorithms.fourSumForce
import algorithms.threeSumBinaryFast
import ds.*

data class tt(var string: String = "")

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

fun main(){
    val sq = StackDeque<String>()
    sq.pushLeft("a")
    sq.pushLeft("b")
    sq.pushLeft("c")
    sq.pushLeft("d")
    sq.pushLeft("e")
    println(sq.popRight())
    sq.pushRight("f")
    sq.pushRight("g")
    sq.pushRight("h")
    println(sq.asList())
//    val st = Stack<Int>()
//    st.push(1)
//    st.push(2)
//    st.push(3)
//    println(st)
}
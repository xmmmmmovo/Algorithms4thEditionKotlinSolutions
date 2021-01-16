/*
 * Copyright (c) 2021. xmmmmmovo
 */

package fundamental

import ds.UF
import edu.princeton.cs.algs4.QuickUnionUF
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.platform.commons.logging.LoggerFactory
import java.io.File

internal class UFTest {
    private var N: Int = 0
    private val pl: MutableList<Int>
    private val ql: MutableList<Int>
    private val mediumUF = File("./data/mediumUF.txt").readLines().also {
        pl = MutableList(it.size) { 0 }
        ql = MutableList(it.size) { 0 }
    }.forEachIndexed { index, it ->
        val sps = it.split(" ")
        if (sps.size == 1) {
            N = sps[0].toInt()
        } else {
            pl[index] = sps[0].toInt()
            ql[index] = sps[1].toInt()
        }
    }

    companion object {
        private val log = LoggerFactory.getLogger(UFTest::class.java)

        @BeforeAll
        @JvmStatic
        fun before() {
            log.info { "UFTest start" }
        }

        @AfterAll
        @JvmStatic
        fun after() {
            log.info { "UFTest end" }
        }
    }

    @Test
    fun unionFindTest() {
        log.info { "unionFindTest testing" }
        log.info { "${pl.size}" }

        val uf = UF(N)
        val stduf = QuickUnionUF(N)

        repeat(pl.size) {
            assertEquals(
                uf.connected(pl[it], ql[it]),
                stduf.connected(pl[it], ql[it])
            )
            if (uf.connected(pl[it], ql[it]))
                return
            uf.union(pl[it], ql[it])
            stduf.union(pl[it], ql[it])
        }
    }
}
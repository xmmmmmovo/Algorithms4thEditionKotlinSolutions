/*
 * Copyright (c) 2020. xmmmmmovo
 */

package fundamental

import algorithms.JosephusSolutions
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.platform.commons.logging.LoggerFactory

internal class JosephusSolutionsTest {
    val jo = JosephusSolutions(5, 3)
    val joo = JosephusSolutions(10, 17)

    companion object {
        private val log = LoggerFactory.getLogger(JosephusSolutionsTest::class.java)

        @BeforeAll
        @JvmStatic
        fun before() {
            log.info { "JosephusSolutionsTest start" }
        }

        @AfterAll
        @JvmStatic
        fun after() {
            log.info { "JosephusSolutionsTest end" }
        }
    }

    @Test
    fun changePeopleNumbers() {
        log.info { "changePeopleNumbers testing" }

        val e1 = assertThrows(IllegalArgumentException::class.java) { jo.changePeopleNumbers(-1, -1, -1) }
        assertEquals("人数不能小于等于0！", e1.message)
        val e2 = assertThrows(IllegalArgumentException::class.java) { jo.changePeopleNumbers(2, 1, 10) }
        assertEquals("总人数不能小于剩余人数！", e2.message)
    }

    @Test
    fun queueForceSolution() {
        log.info { "queueForceSolution testing" }

        assertEquals("4号", jo.queueForceSolution())
        assertEquals("3号", joo.queueForceSolution())
    }

    @Test
    fun linkedListForceSolution() {
        log.info { "linkedListForceSolution testing" }

        assertEquals("4号", jo.linkedListForceSolution())
        assertEquals("3号", joo.linkedListForceSolution())
    }

    @Test
    fun mathFastSolution() {
        log.info { "mathFastSolution testing" }

        assertEquals("4号", jo.mathFastSolution())
        assertEquals("3号", joo.mathFastSolution())
    }
}
/*
 * Copyright (c) 2020. xmmmmmovo
 */

package utils

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class LoggerUtilsKtTest {

    @Test
    fun debug() {
        utils.debug("test"){"test debug"}
        debug { "R debug class ext" }
    }
}
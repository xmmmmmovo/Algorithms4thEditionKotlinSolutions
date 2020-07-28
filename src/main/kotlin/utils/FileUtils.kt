/*
 * Copyright (c) 2020. xmmmmmovo
 */
package utils

import edu.princeton.cs.algs4.In

/**
 * 读取文件内容并转换为Int列表
 * @author xmmmmmovo
 * @date 2020/7/28 11:43
 * @param[filename] 读取文件的文件名
 * @return 返回读取列表
 * @since version-1.0
 */
fun readIntList(filename: String): List<Int> =
        In(filename).readAllInts().asList()
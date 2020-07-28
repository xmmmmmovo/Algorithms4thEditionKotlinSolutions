/*
 * Copyright (c) 2020. xmmmmmovo
 */
package utils

import edu.princeton.cs.algs4.In

/**
 * @author xmmmmmovo
 * @date 2020/7/28 11:43
 * @description 读取文件内容并转换为Int数组
 * @param[filename] 读取文件的文件名
 * @return 返回读取列表
 * @since version-1.0
 */
fun readIntList(filename: String): List<Int> =
        In(filename).readAllInts().asList()
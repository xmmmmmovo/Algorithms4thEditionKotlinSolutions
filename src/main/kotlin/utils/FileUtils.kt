package utils

import edu.princeton.cs.algs4.In

inline fun readIntList(filename: String): List<Int> =
        In(filename).readAllInts().asList()
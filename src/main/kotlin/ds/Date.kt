/*
 * Copyright (c) 2020. xmmmmmovo
 */
package ds

/**
 * 日期类
 * @author xmmmmmovo
 * @date 2020/7/28 16:46
 * @since version-1.0
 */
class Date : Comparable<Date> {
    private val _year: Int
    private val _month: Int
    private val _day: Int

    /**
     * 直接输入年月日
     * */
    constructor(
        y: Int = 0,
        m: Int = 0,
        d: Int = 0
    ) {
        if (!isDateValid(d, m, y))
            throw IllegalArgumentException("输入日期错误!")
        _year = y
        _month = m
        _day = d
    }

    /**
     * 字符串解析
     * */
    constructor(
        parseString: String
    ) {
        parseString.split("/").run {
            if (size < 3) {
                throw IllegalArgumentException("输入日期错误！")
            }
            _year = get(0).toInt()
            _month = get(1).toInt()
            _day = get(2).toInt()
            if (!isDateValid(_day, _month, _year))
                throw IllegalArgumentException("输入日期错误！")
        }

    }

    companion object {
        // 每月天数
        val monthDayList = listOf(0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    }

    /**
     * 日期是否合法
     * */
    private fun isDateValid(d: Int, m: Int, y: Int): Boolean {
        if (m > 12 || m < 1) {
            return false
        }
        if (d > monthDayList[m] || d < 1) {
            return false
        }
        if (m == 2 && d == 29 && !isLeapYear(y)) {
            return false
        }
        return true
    }

    /**
     * 判断是否是闰年
     * */
    private fun isLeapYear(y: Int): Boolean {
        if (y % 400 == 0) return true
        if (y % 100 == 0) return false
        return y % 4 == 0
    }

    val year
        get() = _year
    val month
        get() = _month
    val day
        get() = _day

    override fun compareTo(other: Date): Int {
        if (this._year < other._year)
            return -1
        if (this._year > other._year)
            return 1
        if (this._month < other._month)
            return -1
        if (this._month > other._month)
            return 1
        if (this._day < other._day)
            return -1
        if (this._day > other._day)
            return 1
        return 0
    }

    override fun toString(): String {
        return "$_year/$_month/$_day"
    }

    override fun hashCode(): Int {
        return _day + 31 * _month + 31 * 12 * _year
    }
}
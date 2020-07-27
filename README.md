# 算法(第四版)个人题解

![kotlin](https://img.shields.io/badge/language-kotlin-orange.svg) ![apache](https://img.shields.io/badge/license-Apache2.0-brightgreen.svg) ![test](https://github.com/xmmmmmovo/Algorithms4thEditionKotlinSolutions/workflows/Tests%20And%20Documentation%20Workflow/badge.svg)

算法(第四版)个人实现/课后习题/提高题

## 下载

[数据下载](http://algs4.cs.princeton.edu/code/algs4-data.zip)

## 实现

[算法实现](../CompilingPrinciple/algorithm4/src/main/kotlin/algorithms)

[数据结构实现](/ds)

**加粗标星号:star:的是在书中标极难的题目**

### [第一章: 基础](/src/fundamentals)

- [二分搜索](../CompilingPrinciple/algorithm4/src/main/kotlin/algorithms/BinarySearchUtils.kt)
- [累加器](../CompilingPrinciple/algorithm4/src/main/kotlin/ds/Accumulator.kt)
- [可视化累加器](../CompilingPrinciple/algorithm4/src/main/kotlin/ds/VisualAccumulator.kt)
- [计数器](../CompilingPrinciple/algorithm4/src/main/kotlin/ds/Counter.kt)
- [平面点](../CompilingPrinciple/algorithm4/src/main/kotlin/ds/Point2D.kt)
- [日期类](../CompilingPrinciple/algorithm4/src/main/kotlin/ds/Date.kt)
- [账单类](../CompilingPrinciple/algorithm4/src/main/kotlin/ds/Transaction.kt)
- [gcd](../CompilingPrinciple/algorithm4/src/main/kotlin/algorithms/MathUtils.kt#L13)
- [快速gcd](../CompilingPrinciple/algorithm4/src/main/kotlin/algorithms/MathUtils.kt#L29)
- [分数类](../CompilingPrinciple/algorithm4/src/main/kotlin/ds/Rational.kt)
- [背包](../CompilingPrinciple/algorithm4/src/main/kotlin/ds/Bag.kt)
- [栈](../CompilingPrinciple/algorithm4/src/main/kotlin/ds/Stack.kt)
- [队列](../CompilingPrinciple/algorithm4/src/main/kotlin/ds/Queue.kt)
- [括号匹配](../CompilingPrinciple/algorithm4/src/main/kotlin/algorithms/MathUtils.kt#L135)
- [简单计算器](../CompilingPrinciple/algorithm4/src/main/kotlin/algorithms/MathUtils.kt#L125)
  - [中缀转后缀](../CompilingPrinciple/algorithm4/src/main/kotlin/algorithms/MathUtils.kt#L69)
  - [计算后缀](../CompilingPrinciple/algorithm4/src/main/kotlin/algorithms/MathUtils.kt#L108)
- [双向链表](../CompilingPrinciple/algorithm4/src/main/kotlin/ds/LinkedList.kt)
- [双向队列](../CompilingPrinciple/algorithm4/src/main/kotlin/ds/Deque.kt)
- [缓冲区Buffer](../CompilingPrinciple/algorithm4/src/main/kotlin/ds/Buffer.kt)
- [四数之和](../CompilingPrinciple/algorithm4/src/main/kotlin/algorithms/NumUtils.kt#L12)
- [三数之和](../CompilingPrinciple/algorithm4/src/main/kotlin/algorithms/NumUtils.kt#L28)
  - [查找已排序列表中是否有重复元素](../CompilingPrinciple/algorithm4/src/main/kotlin/algorithms/ListUtils.kt#L18)
- [循环链表](../CompilingPrinciple/algorithm4/src/main/kotlin/ds/CircularLinkedList.kt)
- [约瑟夫环问题](../CompilingPrinciple/algorithm4/src/main/kotlin/algorithms/JosephusSolutions.kt)
  - [双向队列解法](../CompilingPrinciple/algorithm4/src/main/kotlin/algorithms/JosephusSolutions.kt#L46)
  - [循环链表解法](../CompilingPrinciple/algorithm4/src/main/kotlin/algorithms/JosephusSolutions.kt#L71)
  - [数学解法](../CompilingPrinciple/algorithm4/src/main/kotlin/algorithms/JosephusSolutions.kt#L97)
- **[:star:利用三个栈实现双向队列，使得所有操作时间复杂度O(1)(均摊后虚假的O(1))](../CompilingPrinciple/algorithm4/src/main/kotlin/ds/StackDeque.kt)**
- **[:star:利用六个栈实现单向队列，使得所有操作时间复杂度O(1)(真正的O(1))](../CompilingPrinciple/algorithm4/src/main/kotlin/ds/StackDequeOpt.kt)**

### 排序

- 排序

### 一些工具类

- [文件工具类](../CompilingPrinciple/algorithm4/src/main/kotlin/utils/FileUtils.kt)
- [调试工具类](../CompilingPrinciple/algorithm4/src/main/kotlin/utils/LoggerUtils.kt)
- [范围工具类](../CompilingPrinciple/algorithm4/src/main/kotlin/utils/RangeUtils.kt)

## 为什么用kotlin

只是因为用起来比较爽罢了，起码比Java用起来爽...
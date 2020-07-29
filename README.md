# 算法(第四版)个人题解

![kotlin](https://img.shields.io/badge/language-kotlin-orange.svg) ![apache](https://img.shields.io/badge/license-Apache2.0-brightgreen.svg) ![test](https://github.com/xmmmmmovo/Algorithms4thEditionKotlinSolutions/workflows/Test%20Workflow/badge.svg) ![doc](https://github.com/xmmmmmovo/Algorithms4thEditionKotlinSolutions/workflows/Doc%20Workflow/badge.svg)

算法(第四版)个人实现/课后习题/部分提高题

API文档地址：https://blog.fivezha.cn/Algorithms4thEditionKotlinSolutions/

题解博客地址：https://blog.fivezha.cn/categories/algorithm4/

现在已完成至1.5

## 资料

[数据下载](http://algs4.cs.princeton.edu/code/algs4-data.zip)

[官方网站](https://algs4.cs.princeton.edu/)

[官方课程](https://www.coursera.org/learn/algorithms-part1)

## 实现

[算法实现](./src/main/kotlin/algorithms)

[数据结构实现](/ds)

**加粗标星号:star:的是在书中标极难的题目**

### [第一章: 基础](./test/kotlin/fundamental)

- [二分搜索](./src/main/kotlin/algorithms/BinarySearchUtils.kt)
- [累加器](./src/main/kotlin/ds/Accumulator.kt)
- [可视化累加器](./src/main/kotlin/ds/VisualAccumulator.kt)
- [计数器](./src/main/kotlin/ds/Counter.kt)
- [平面点](./src/main/kotlin/ds/Point2D.kt)
- [日期类](./src/main/kotlin/ds/Date.kt)
- [账单类](./src/main/kotlin/ds/Transaction.kt)
- [gcd](./src/main/kotlin/algorithms/MathUtils.kt#L13)
- [快速gcd](./src/main/kotlin/algorithms/MathUtils.kt#L29)
- [分数类](./src/main/kotlin/ds/Rational.kt)
- [背包](./src/main/kotlin/ds/Bag.kt)
- [栈](./src/main/kotlin/ds/Stack.kt)
- [队列](./src/main/kotlin/ds/Queue.kt)
- [括号匹配](./src/main/kotlin/algorithms/MathUtils.kt#L135)
- [简单计算器](./src/main/kotlin/algorithms/MathUtils.kt#L125)
  - [中缀转后缀](./src/main/kotlin/algorithms/MathUtils.kt#L69)
  - [计算后缀](./src/main/kotlin/algorithms/MathUtils.kt#L108)
- [双向链表](./src/main/kotlin/ds/LinkedList.kt)
- [双向队列](./src/main/kotlin/ds/Deque.kt)
- [缓冲区Buffer](./src/main/kotlin/ds/Buffer.kt)
- [四数之和](./src/main/kotlin/algorithms/NumUtils.kt#L12)
- [三数之和](./src/main/kotlin/algorithms/NumUtils.kt#L28)
  - [查找已排序列表中是否有重复元素](./src/main/kotlin/algorithms/ListUtils.kt#L18)
- [循环链表](./src/main/kotlin/ds/CircularLinkedList.kt)
- [约瑟夫环问题](./src/main/kotlin/algorithms/JosephusSolutions.kt)
  - [双向队列解法](./src/main/kotlin/algorithms/JosephusSolutions.kt#L46)
  - [循环链表解法](./src/main/kotlin/algorithms/JosephusSolutions.kt#L71)
  - [数学解法](./src/main/kotlin/algorithms/JosephusSolutions.kt#L97)
- **[:star:利用三个栈实现双向队列，使得所有操作时间复杂度O(1)(均摊后虚假的O(1))](./src/main/kotlin/ds/StackDeque.kt)**
- **[:star:利用六个栈实现单向队列，使得所有操作时间复杂度O(1)(真正的O(1))](./src/main/kotlin/ds/StackDequeOpt.kt)**

### 排序

- 排序

### 一些工具类

- [文件工具类](./src/main/kotlin/utils/FileUtils.kt)
- [调试工具类](./src/main/kotlin/utils/LoggerUtils.kt)
- [范围工具类](./src/main/kotlin/utils/RangeUtils.kt)

## 写在最后

如果你发现了代码的一些逻辑错误或者还有其它测试用例，可以在[**Issue**](https://github.com/xmmmmmovo/Algorithms4thEditionKotlinSolutions/issues)里面提出，或者直接发起[**Pull request**](https://github.com/xmmmmmovo/Algorithms4thEditionKotlinSolutions/pulls)

由于一些个人原因，本项目测试文件和文档注释都不全，如有兴趣或能力补全可以直接发起[**Pull request**](https://github.com/xmmmmmovo/Algorithms4thEditionKotlinSolutions/pulls)，在此表示感谢!

## 为什么用kotlin

只是因为用起来比较爽罢了，起码比Java用起来爽...


https://www.coursera.org/learn/algorithms-part1/
## 15 UnionFind 联合查找（并查集）
### 应用
- 网络中：动态连通性
- 图处理：Kruskal最小生成树算法
- 渗滤模型（_渗透概率p曲线非常陡峭_）->蒙特卡罗仿真
### QuickFind 快速查找
- 构造花费O(n)
- 合并花费O(n) **开销太大**
- 查找花费O(1)
### QuickUnion 快速合并
- 构造花费O(n)
- 合并花费O(n) **包含查找根的花销**
- 查找花费O(n) **开销太大**
### WeightedQuickUnion 加权快速合并
- 构造花费O(n)
- 合并花费O(lg(n)) **包含查找根的花销**
- 查找花费O(lg(n))
### WeightedPathCompressionQuickUnion 具有路径压缩的加权快速合并
- 构造花费O(n)
- ~~**可能有问题？**~~
- 合并花费O(lg(n)) **包含查找根的花销**
- 查找花费O(lg(n))
### 测试数据
- tinyUF.txt
- mediumUF.txt
- largeUF.txt
### 复杂度总结
![uf-performance](img/15uf-performance.png)
## 14 Analysis Of Algorithms
- 不同复杂度的图像表现
![](img/14AnalysisOfAlgorithms_1.png)
- 不同复杂度的代码表现
![](img/14AnalysisOfAlgorithms_2.png)
- 不同复杂度的数据范围
![](img/14AnalysisOfAlgorithms_3.png)
- 时间复杂度中三种符号的使用
![](img/14AnalysisOfAlgorithms_4.png)
### ThreeSum 三数求和
- 求解开销O(n³)
### ThreeSumFast 三数快速求和
- 求解开销O(n²lg(n))
### 测试数据
- 1Kints.txt
- 2Kints.txt
- 4ints.txt
- 8Kints.txt
- 16Kints.txt
- 32Kints.txt
- 1Mints.txt
### 补充
- DualPivotQuicksort执行流程
![](img/14DualPivotQuicksort.png)
## 13 StacksAndQueuesAndBags And Queues And Bags
### 应用
#### 栈
- 递归
  - 总能显式的使用栈将递归程序非递归化
- 栈式编程语言
- Dijkstra双栈算术表达式求值算法
  - 双栈：数值栈和操作符栈
### Stack
- 使用静态嵌套类的链表构成的栈
### ResizingArrayStack
- 使用可调整大小的数组构成的栈
### Queue
- 使用静态嵌套类的链表构成的队列
### ResizingArrayQueue
- 使用可调整大小的数组构成的队列
### Bag （多集：可包含重复元素）
- 使用静态嵌套类的链表构成的多集
- 没有删除功能
### ResizingArrayBag
- 使用可调整大小的数组构成的多集
- 没有删除功能
### 测试数据
- tobe.txt
### 补充
#### 栈
- 想要保证每个操作都能很快完成，选用链表（数组分配时会消耗大量时间，变的很慢）
- 只关心总时间选用数组（将调整数组大小的开销平摊，仍比链表开销要小）

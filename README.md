https://www.coursera.org/learn/algorithms-part1/
## UnionFind 联合查找（并查集）
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
### 测试数据
- tinyUF.txt
- mediumUF.txt
- largeUF.txt


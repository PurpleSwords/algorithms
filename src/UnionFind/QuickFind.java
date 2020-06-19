package UnionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author PurpleSword
 * @Date 2020/6/18 23:41
 * @Version 1.0
 */
public class QuickFind {
	private int[] id;
	private int count;

	/**
	 * 初始化每个数字为对应下标
	 *
	 * @param n 总个数
	 */
	public QuickFind(int n) {
		count = n;
		id = new int[n];
		for (int i = 0; i < n; ++i) {
			id[i] = i;
		}
	}

	/**
	 * @return 返回集合数目
	 */
	public int count() {
		return count;
	}

	/**
	 * @param p 输入元素
	 * @return 当前元素所在集合
	 */
	public int find(int p) {
		validate(p);
		return id[p];
	}

	/**
	 * 输入有效性确认
	 *
	 * @param p 输入索引
	 */
	private void validate(int p) {
		int n = id.length;
		if (p < 0 || p >= n) {
			throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
		}
	}

	/**
	 * 判断两个元素是否在同一集合
	 *
	 * @param p 元素1
	 * @param q 元素2
	 * @return 若在同一集合返回true
	 */
	private boolean connected(int p, int q) {
		validate(p);
		validate(q);
		return id[p] == id[q];
	}

	/**
	 * 合并两个元素所在集合
	 *
	 * @param p 元素1
	 * @param q 元素2
	 */
	public void union(int p, int q) {
		validate(p);
		validate(q);
		int pID = id[p];
		int qID = id[q];
		//两个元素已经在同一集合
		if (pID == qID) {
			return;
		}
		for (int i = 0; i < id.length; ++i) {
			if (id[i] == pID) {
				id[i] = qID;
			}
			--count;
		}
	}

	/**
	 * 输入第一行表示最大数+1
	 * 后续每一行由两个数字组成，不在一个集合则合并并输出，否则输出True
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		int n = StdIn.readInt();
		QuickFind qf = new QuickFind(n);
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (qf.find(p) == qf.find(q)) {
				StdOut.println("True");
			} else {
				qf.union(p, q);
				StdOut.println(p + " " + q);
			}
		}
		StdOut.println(qf.count() + " components");
	}
}
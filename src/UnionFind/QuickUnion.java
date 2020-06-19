package UnionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author PurpleSword
 * @Date 2020/6/19 12:08
 * @Version 1.0
 * @Description
 */
public class QuickUnion {
	private int[] parent;
	private int count;

	public QuickUnion(int n) {
		parent = new int[n];
		count = n;
		for (int i = 0; i < n; ++i) {
			parent[i] = i;
		}
	}

	public int count() {
		return count;
	}

	/**
	 * 查找当前集合根结点
	 *
	 * @param p 查找元素
	 * @return 根结点下标
	 */
	public int find(int p) {
		validate(p);
		while (p != parent[p]) {
			p = parent[p];
		}
		return p;
	}

	private void validate(int p) {
		int n = parent.length;
		if (p < 0 || p >= n) {
			throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
		}
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public void union(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		if (rootP == rootQ) {
			return;
		}
		parent[rootP] = rootQ;
		--count;
	}

	/**
	 * 输入第一行表示最大数+1
	 * 后续每一行由两个数字组成，不在一个集合则合并并输出，否则输出True
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		int n = StdIn.readInt();
		QuickUnion qu = new QuickUnion(n);
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (qu.find(p) == qu.find(q)) {
				StdOut.println("True");
			} else {
				qu.union(p, q);
				StdOut.println(p + " " + q);
			}
		}
		StdOut.println(qu.count() + " components");
	}
}


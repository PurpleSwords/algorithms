package UnionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author PurpleSword
 * @Date 2020/6/19 13:35
 * @Version 1.0
 * @Description
 */
public class WeightedQuickUnion {
	private int[] parent;
	private int[] size;    //size[i]是以i为根的子树数
	private int count;

	/**
	 * 初始化操作
	 *
	 * @param n 数组上限
	 */
	public WeightedQuickUnion(int n) {
		count = n;
		parent = new int[n];
		size = new int[n];
		for (int i = 0; i < n; ++i) {
			parent[i] = i;
			//初始每个节点为1个独立子树
			size[i] = 1;
		}
	}

	public int count() {
		return count;
	}

	public int find(int p) {
		validate(p);
		while (p != parent[p]) {
			p = parent[p];
		}
		return p;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	private void validate(int p) {
		int n = parent.length;
		if (p < 0 || p >= n) {
			throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
		}
	}

	public void union(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		if (rootP == rootQ) {
			return;
		}

		//比较两树的高度，将较低的树合并至较高树下
		if (size[rootP] < size[rootQ]) {
			parent[rootP] = rootQ;
			size[rootQ] += size[rootP];
		} else {
			parent[rootQ] = rootP;
			size[rootP] += size[rootQ];
		}
		--count;
	}

	public static void main(String[] args) {
		int n = StdIn.readInt();
		WeightedQuickUnion wqu = new WeightedQuickUnion(n);
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (wqu.find(q) == wqu.find(q)) {
				StdOut.println("True");
			} else {
				wqu.union(p, q);
				StdOut.println(p + " " + q);
			}
		}
		StdOut.println(wqu.count() + " components");
	}
}

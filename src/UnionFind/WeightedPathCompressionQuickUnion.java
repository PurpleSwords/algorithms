package UnionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author PurpleSword
 * @Date 2020/6/19 15:11
 * @Version 1.0
 * @Description
 */
public class WeightedPathCompressionQuickUnion {
	private int[] parent;
	private byte[] rank;    //rank[i]表示以i为根的节点的高度（从下往上计算）
	private int count;

	public WeightedPathCompressionQuickUnion(int n) {
		count = n;
		parent = new int[n];
		rank = new byte[n];
		for (int i = 0; i < n; ++i) {
			parent[i] = i;
			rank[i] = 0;
		}
	}

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

	public int count() {
		return count;
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
		/*
		 * 理想情况下，我们希望每个节点都直接链接到其树的根，
		 * 但是我们不想为更改大量链接付出代价。
		 * 我们可以通过使我们检查的所有节点直接链接到根来简单地实现理想。
		 *
		 * 按秩合并
		 * 总是将较低的子树添加到较高的子树中
		 * 两树高度相同：合并后高度+1
		 * */
		if (rank[rootP] < rank[rootQ]) {
			parent[rootP] = rootQ;
		} else if (rank[rootP] > rank[rootQ]) {
			parent[rootQ] = rootP;
		} else {
			parent[rootQ] = rootP;
			++rank[rootP];
		}
		--count;
	}

	public static void main(String[] args) {
		int n = StdIn.readInt();
		WeightedPathCompressionQuickUnion wpcqu = new WeightedPathCompressionQuickUnion(n);
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (wpcqu.find(p) == wpcqu.find(q)) {
				StdOut.println("True");
			} else {
				wpcqu.union(p, q);
				StdOut.println(p + " " + q);
			}
		}
		StdOut.println(wpcqu.count() + " components");
	}
}

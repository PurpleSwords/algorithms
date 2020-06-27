package Sort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author PurpleSword
 * @Date 2020/6/27 0:06
 * @Version 1.0
 * @Description
 */
public class Insertion {
	public Insertion() {
	}

	//String实现了Comparable接口，所以每一个String对象均可以看作Comparable对象
	public static void sort(Comparable[] a) {
		int n = a.length;

		// 标记，为0表示已排好序
		int exchange = 0;
		// 放置最小元素为哨兵
		// 牺牲最小元素作为哨兵，避免检查时可能出现数组越界的情况
		for (int i = n - 1; i > 0; --i) {
			if (less(a[i], a[i - 1])) {
				exch(a, i, i - 1);
				++exchange;
			}
		}
		if (exchange == 0) {
			return;
		}

		//半交换插入排序（需要前移的元素直接放在最后的位置，而不是一个个前移）
		for (int i = 2; i < n; ++i) {
			// v就是临时变量，将其存储，找到合适的位置直接放下
			// v前方均有序，将大于v的元素后移
			Comparable v = a[i];
			int j = i;
			while (less(v, a[j - 1])) {
				// 这里j不会一直减下去是因为前面有设置哨兵
				a[j] = a[j - 1];
				--j;
			}
			a[j] = v;
		}

		assert isSorted(a);
	}

	/**
	 * v<w时返回True
	 *
	 * @param v 元素v
	 * @param w 元素w
	 * @return
	 */
	private static boolean less(Comparable v, Comparable w) {
		// v<w 返回小于0的值
		return v.compareTo(w) < 0;
	}

	private static void exch(Object[] a, int i, int j) {
		//交换两个元素顺序
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	private static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; ++i) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}

	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; ++i) {
			StdOut.println(a[i]);
		}
	}

	public static void main(String[] args) {
		String[] a = StdIn.readAllStrings();
		Insertion.sort(a);
		show(a);
	}
}

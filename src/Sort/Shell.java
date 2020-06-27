package Sort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author PurpleSword
 * @Date 2020/6/27 12:14
 * @Version 1.0
 * @Description
 */
public class Shell {
	public Shell() {
	}

	public static void sort(Comparable[] a) {
		int n = a.length;

		//增量序列
		int h = 1;
		while (h < n / 3) {
			h = 3 * h + 1;
		}

		while (h >= 1) {
			for (int i = h; i < n; ++i) {
				// 没有哨兵，则要用j>=h来限制，防止数组越界
				for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
					exch(a, j, j - h);
				}
			}
			// 判断该轮排序(每h个元素为一组)是否正确
			assert isHsorted(a, h);
			h /= 3;
		}
		assert isSorted(a);
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	private static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}

	private static boolean isHsorted(Comparable[] a, int h) {
		for (int i = h; i < a.length; i++) {
			if (less(a[i], a[i - h])) {
				return false;
			}
		}
		return true;
	}

	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			StdOut.println(a[i]);
		}
	}

	public static void main(String[] args) {
		String[] a = StdIn.readAllStrings();
		Shell.sort(a);
		show(a);
	}
}

package Sort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author PurpleSword
 * @Date 2020/6/27 9:44
 * @Version 1.0
 * @Description
 */
public class Selection {
	public Selection() {
	}

	public static void sort(Comparable[] a) {
		int n = a.length;
		for (int i = 0; i < n; ++i) {
			// 每次找出剩余序列中最小元素所在位置，直接添加到有序子序列末尾，
			int min = i;
			for (int j = i + 1; j < n; ++j) {
				if (less(a[j], a[min])) {
					min = j;
				}
			}
			exch(a, i, min);
			assert isSorted(a, 0, i);
		}
		assert isSorted(a);
	}

	//Comparator是注重容器的比较接口
	public static void sort(Object[] a, Comparator comparator) {
		int n = a.length;
		for (int i = 0; i < n; ++i) {
			// 每次找出剩余序列中最小元素所在位置，直接添加到有序子序列末尾，
			int min = i;
			for (int j = i + 1; j < n; ++j) {
				if (less(comparator, a[j], a[min])) {
					min = j;
				}
			}
			exch(a, i, min);
			assert isSorted(a, comparator, 0, i);
		}
		assert isSorted(a, comparator);
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static boolean less(Comparator comparator, Object v, Object w) {
		return comparator.compare(v, w) < 0;
	}

	private static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	private static boolean isSorted(Comparable[] a) {
		return isSorted(a, 0, a.length - 1);
	}

	private static boolean isSorted(Comparable[] a, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}

	private static boolean isSorted(Object[] a, Comparator comparator) {
		return isSorted(a, comparator, 0, a.length - 1);
	}

	private static boolean isSorted(Object[] a, Comparator comparator, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++) {
			if (less(comparator, a[i], a[i - 1])) {
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
		Selection.sort(a);
		show(a);
	}
}

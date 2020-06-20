package ThreeSum;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author PurpleSword
 * @Date 2020/6/20 19:59
 * @Version 1.0
 * @Description
 */
public class ThreeSumFast {
	public ThreeSumFast() {
	}

	/**
	 * 检查已排序数组是否有相同的元素
	 *
	 * @param a 需要检查的数组
	 * @return True：有重复的元素
	 */
	private static boolean containsDuplicates(int[] a) {
		for (int i = 1; i < a.length; ++i) {
			if (a[i] == a[i - 1]) {
				return true;
			}
		}
		return false;
	}

	public static void printAll(int[] a) {
		int n = a.length;
		/*
		 * DualPivotQuicksort
		 * 双轴快排(升序)，对快排进行优化：
		 * 使用了两个基准，将原数组分为三个数组进行递归
		 * 快排使用一个基准，将原数组分为两个数组进行递归
		 */
		Arrays.sort(a);
		if (containsDuplicates(a)) {
			throw new IllegalArgumentException("array contains duplicate integers");
		}
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				//二分查找，在i和j后查找到相反数即完成目标（i+j+k=0）
				//不存在则k=-1（必然小于i和j）
				int k = Arrays.binarySearch(a, -(a[i] + a[j]));
				if (k > j) {
					StdOut.println(a[i] + " " + a[j] + " " + a[k]);
				}
			}
		}
	}

	public static int count(int[] a) {
		int n = a.length;
		Arrays.sort(a);
		if (containsDuplicates(a)) {
			throw new IllegalArgumentException("array contains duplicate integers");
		}
		int count = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				//二分查找，在i和j后查找到相反数即完成目标（i+j+k=0）
				//若比j小，则在之前的查找中已经统计过
				//不存在则k=-1（必然小于i和j）
				int k = Arrays.binarySearch(a, -(a[i] + a[j]));
				if (k > j) {
					++count;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		In in = new In(args[0]);
		int[] a = in.readAllInts();

		int count = count(a);
		StdOut.println(count);
	}
}

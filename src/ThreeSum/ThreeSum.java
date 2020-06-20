package ThreeSum;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author PurpleSword
 * @Date 2020/6/20 17:37
 * @Version 1.0
 * @Description
 */
public class ThreeSum {
	public ThreeSum() {
	}

	/**
	 * 暴力计算并输出三数之和为0的情况
	 *
	 * @param a 需要计算的数组
	 */
	public static void printAll(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				for (int k = j + 1; k < n; ++k) {
					if (a[i] + a[j] + a[k] == 0) {
						StdOut.println(a[i] + " " + a[j] + " " + a[k]);
					}
				}
			}
		}
	}

	/**
	 * 暴力计算三数之和为0的种类数
	 *
	 * @param a 需要计算的数组
	 * @return 符合条件的数量
	 */
	public static int count(int[] a) {
		int n = a.length;
		int count = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				for (int k = j + 1; k < n; ++k) {
					if (a[i] + a[j] + a[k] == 0) {
						++count;
					}
				}
			}
		}
		return count;
	}

	/**
	 * 使用命令行将测试文件读取进去
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		In in = new In(args[0]);
		int[] a = in.readAllInts();

		Stopwatch timer = new Stopwatch();
		int count = count(a);
		StdOut.println("elapsed time = " + timer.elapsedTime());
		StdOut.println(count);
	}
}

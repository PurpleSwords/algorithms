package Stacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
/**
 * 血的教训，不知道啥时候导入的这包调试了很久
 * import org.omg.CORBA.Object;
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author PurpleSword
 * @Date 2020/6/21 16:41
 * @Version 1.0
 * @Description
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {
	private Item[] a;
	private int n;

	public ResizingArrayStack() {
		//初始化大小为2
		a = (Item[]) new Object[2];
		n = 0;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public int size() {
		return n;
	}

	/**
	 * 调整数组容量
	 *
	 * @param capacity 调整后的大小
	 */
	private void resize(int capacity) {
		// 断言表达式为True继续执行，
		// False抛出AssertionError
		assert capacity >= n;

		Item[] copy = (Item[]) new Object[capacity];
		for (int i = 0; i < n; ++i) {
			copy[i] = a[i];
		}
		a = copy;
	}

	public void push(Item item) {
		if (n == a.length) {
			resize(2 * a.length);
		}
		//先存放再移动指针
		a[n++] = item;
	}

	public Item pop() {
		if (isEmpty()) {
			throw new NoSuchElementException("Stack underflow");
		}
		Item item = a[--n];
		// 置空让JAVA进行回收
		a[n] = null;

		//数组过大，调整大小
		if (n > 0 && 4 * n == a.length) {
			resize(a.length / 2);
		}
		return item;
	}

	public Item peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("Stack underflow");
		}
		return a[n - 1];
	}

	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}

	private class ReverseArrayIterator implements Iterator<Item> {
		private int i;

		public ReverseArrayIterator() {
			i = n - 1;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean hasNext() {
			return i >= 0;
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return a[i--];
		}
	}

	public static void main(String[] args) {
		ResizingArrayStack<String> stack = new ResizingArrayStack<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) {
				stack.push(item);
			} else if (!stack.isEmpty()) {
				StdOut.print(stack.pop() + " ");
			}
		}
		StdOut.println("(" + stack.size() + " left on stack)");
	}
}


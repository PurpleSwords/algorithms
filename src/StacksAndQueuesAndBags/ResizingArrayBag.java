package StacksAndQueuesAndBags;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author PurpleSword
 * @Date 2020/6/23 11:56
 * @Version 1.0
 * @Description
 */
public class ResizingArrayBag<Item> implements Iterable<Item> {
	private Item[] a;
	private int n;

	public ResizingArrayBag() {
		a = (Item[]) new Object[2];
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public int size() {
		return n;
	}

	private void resize(int capacity) {
		assert capacity >= n;

		Item[] copy = (Item[]) new Object[capacity];
		// 重写了arraycopy方法
		for (int i = 0; i < n; ++i) {
			copy[i] = a[i];
		}
		a = copy;
	}

	public void add(Item item) {
		if (n == a.length) {
			resize(2 * n);
		}
		a[n++] = item;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ArrayIterator();
	}

	private class ArrayIterator implements Iterator<Item> {
		int i = 0;

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean hasNext() {
			return i < n;
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new UnsupportedOperationException();
			}
			return a[i++];
		}
	}

	public static void main(String[] args) {
		ResizingArrayBag<String> bag = new ResizingArrayBag<String>();
		bag.add("Hello");
		bag.add("World");
		bag.add("how");
		bag.add("are");
		bag.add("you");
		bag.add("you");

		for (String s : bag) {
			StdOut.println(s);
		}
	}
}

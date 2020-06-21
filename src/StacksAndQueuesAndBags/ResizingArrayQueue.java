package StacksAndQueuesAndBags;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author PurpleSword
 * @Date 2020/6/21 23:09
 * @Version 1.0
 * @Description
 */
public class ResizingArrayQueue<Item> implements Iterable<Item> {
	private Item[] q;
	private int n;
	private int first;
	private int last;

	public ResizingArrayQueue() {
		q = (Item[]) new Object[2];
		n = 0;
		first = 0;
		last = 0;
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
		for (int i = 0; i < n; ++i) {
			copy[i] = q[(first + i) % q.length];
		}
		q = copy;
		first = 0;
		last = n;
	}

	public void enqueue(Item item) {
		if (n == q.length) {
			resize(2 * n);
		}
		//先入队后移动指针,测试是否正常
		q[(last++) % q.length] = item;
		++n;
	}

	public Item dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue underflow");
		}
		Item item = q[first];
		q[(first++) % q.length] = null;
		--n;

		if (n > 0 && 4 * n == q.length) {
			resize(q.length / 2);
		}
		return item;
	}

	public Item peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue underflow");
		}
		return q[first];
	}

	@Override
	public Iterator<Item> iterator() {
		return new ArrayIterator();
	}

	private class ArrayIterator implements Iterator<Item> {
		private int i = 0;

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
				throw new NoSuchElementException();
			}

			return q[((i++) + first) % q.length];
		}
	}

	public static void main(String[] args) {
		ResizingArrayQueue<String> queue = new ResizingArrayQueue<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) {
				queue.enqueue(item);
			} else if (!queue.isEmpty()) {
				StdOut.print(queue.dequeue() + " ");
			}
		}
		StdOut.println("(" + queue.size() + " left on queue)");
	}
}

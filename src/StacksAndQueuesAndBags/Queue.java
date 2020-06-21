package StacksAndQueuesAndBags;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author PurpleSword
 * @Date 2020/6/21 22:44
 * @Version 1.0
 * @Description
 */
public class Queue<Item> implements Iterable<Item> {
	private Node<Item> first;
	private Node<Item> last;
	private int n;

	private static class Node<Item> {
		private Item item;
		private Node<Item> next;
	}

	public Queue() {
		first = null;
		last = null;
		n = 0;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return n;
	}

	public void enqueue(Item item) {
		Node<Item> oldLast = last;
		last = new Node<Item>();
		last.item = item;
		last.next = null;
		// 入队前为空的特殊处理
		if (isEmpty()) {
			first = last;
		} else {
			oldLast.next = last;
		}
		++n;
	}

	public Item dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue underflow");
		}
		Item item = first.item;
		first = first.next;
		--n;
		// 出队后为空的特殊处理
		if (isEmpty()) {
			last = null;
		}
		return item;
	}

	public Item peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue underflow");
		}
		return first.item;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Item item : this) {
			s.append(item);
			s.append(' ');
		}
		return s.toString();
	}

	@Override
	public Iterator<Item> iterator() {
		return new LinkedIterator(first);
	}

	private class LinkedIterator implements Iterator<Item> {
		private Node<Item> current;

		public LinkedIterator(Node<Item> first) {
			current = first;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	public static void main(String[] args) {
		Queue<String> queue = new Queue<String>();
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

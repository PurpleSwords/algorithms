package StacksAndQueuesAndBags;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author PurpleSword
 * @Date 2020/6/23 11:25
 * @Version 1.0
 * @Description
 */
public class Bag<Item> implements Iterable<Item> {
	private Node<Item> first;
	private int n;

	private static class Node<Item> {
		private Item item;
		private Node<Item> next;
	}

	public Bag() {
		first = null;
		n = 0;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return n;
	}

	public void add(Item item) {
		Node<Item> oldfirst = first;
		first = new Node<>();
		first.item = item;
		first.next = oldfirst;
		++n;
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
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new UnsupportedOperationException();
			}
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	public static void main(String[] args) {
		Bag<String> bag = new Bag<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			bag.add(item);
		}

		StdOut.println("size of bag = " + bag.size());
		for (String s : bag) {
			StdOut.println(s);
		}
	}
}

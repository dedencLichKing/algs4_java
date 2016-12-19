import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Queue<Item> implements Iterable<Item> {

	private node first;//!!!!!!!!!!!只是声明 并没没有new!!!!!!!!!!!!!!!!!!!
	private node last;
	private int n;

	private class node {
		Item item;
		node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return n;

	}

	public void enqueue(Item item) {
		
	  if(isEmpty()){
			  last= new node();
			  last.item=item;
			  last.next=null;
		  first=last;
	  }
	  else {
		
		      node oldlast=last;
			  last= new node();
			  last.item=item;
			  last.next=null;
		oldlast.next=last;
		
	}
		n++;
	}

	public Item dequeue() {
		Item item = first.item;
		first = first.next;
		if (isEmpty())
			last = null;
		n--;
		return item;
	}

	/**********************************************/
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator<Item>();
	}

	/********************************************************/
	private class ListIterator<Item> implements Iterator<Item> {

		private node current = first;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		public Item next() {
			// TODO Auto-generated method stub
			Item item = (Item) current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<String> s = new Queue<String>();

		while (!StdIn.isEmpty()) {
			String a = StdIn.readString();
			if (!a.equals("-")) {
				s.enqueue(a);
			} else if (!s.isEmpty()) {
				StdOut.println(s.dequeue() + ' ');
			}
		StdOut.println("(" + s.size() + " left on stack)");	
		}
	}
}

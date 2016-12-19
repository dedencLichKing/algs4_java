import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class ResizingArrayStackIterator<Item> implements Iterable<Item> {
/**********************与ResizingArrayStack相同的函数****************************/
	private Item[] a = (Item[]) new Object[1];
	private int n=0;

	public boolean IsEmpty() {
		return n==0;
		
	}
	public void  resize(int max) {
		Item[] temp=(Item[]) new Object[max];
		for (int i = 0; i < n; i++) {
			temp[i]=a[i];
		}
		a=temp;
	}
	public void push (Item item) {
		if(n==a.length)
			resize(a.length*2);
		 a[n++]=item;
		
	}
	public Item pop() {
		Item item;
		item=a[--n];
		a[n]=null;
		if(n>0&&n==a.length/4) resize(a.length/2);
		return item;
		
	}
	public int size(){
	return n;}
	public ResizingArrayStackIterator() {
		// TODO Auto-generated constructor stub

	}
/**************************************************************************/
	
	
/**********************iterator****************************/
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ReverseArrayIterator();
	}
/****************************************************/
	
/**********************ReverseArrayIterator类 重写一些方法****************************/
	private class ReverseArrayIterator implements Iterator<Item> {

		private int i=n;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i>0;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			return a[--i];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
	}
	
/********************************************************/
	
	
/**********************main****************************/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ResizingArrayStackIterator<String> s= new ResizingArrayStackIterator<String>();
		
		while(!StdIn.isEmpty()){
			String a=StdIn.readString();
			if(!a.equals("-")){
				s.push(a);
			}
			else if (!s.IsEmpty()) {
				StdOut.println(s.pop()+' ');	
			}
			
		}StdOut.println("(" + s.size() + " left on stack)");
		
	}

}

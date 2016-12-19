import java.security.acl.LastOwnerException;
import java.util.Currency;
import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Stack<Item> implements Iterable<Item> {
/**************************************************/
	private node first;
	private int n;
	private class node{
		Item item;
		node next;
	}
	public boolean isEmpty() {
		return first==null;
		
	}
	public int size() {
		return n;
	}
	public void push(Item item) {
		node oldfist=first;
		first =new node();//!!!!!!!!!!!!!!!create a node!!!!!!!!!!!!!!!
		first.item=item;
		first.next=oldfist;
		n++;
	}
	public Item pop() {
		Item item;
		item=first.item;
		first=first.next;
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
     private class ListIterator<Item> implements Iterator<Item>{

    	private node current = first;
		@Override
		
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current!=null;
		}

		
		public Item next() {
			// TODO Auto-generated method stub
			Item item = (Item) current.item;
			current=current.next;
			return item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
     }

/***************************************************/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<String> s= new Stack<String>();
		
		while(!StdIn.isEmpty()){
			String a=StdIn.readString();
			if(!a.equals("-")){
				s.push(a);
			}
			else if (!s.isEmpty()) {
				StdOut.println(s.pop()+' ');	
			}
			StdOut.println("(" + s.size() + " left on stack)");
		}
	}
}
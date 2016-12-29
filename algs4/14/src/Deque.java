import java.util.Iterator;


public class Deque<Item> implements Iterable<Item> {
	   private node first;
	   private node last;
	   private int n;
	   private class node{
		   Item item;
		   node pre;
		   node next;	   
	   }
	   public Deque(){                           // construct an empty deque
		   first=null;
		   last=null;
		   int n=0;
	   }
	   public boolean isEmpty() {// is the deque empty?
		   return n==0;
	   }
	   
	   
	   
	   public int size()     {
		   // return the number of items on the deque
		   return n;
	   }
	   public void addFirst(Item item)  {
		   // add the item to the front
		   if(isEmpty()){
			   first.item=item;
			   first.next=null;
			   first.pre=null;
			   first=last;
		   }
		    node oldfirst= first;
		    first =new node();
		    first.item=item;
		    first.next=oldfirst;
		    first.pre=null;
		    n++;
	   }
	   public void addLast(Item item)  {
		   // add the item to the end
		   if(isEmpty()){
			   last.item=item;
			   last.pre=null;
			   last.pre=null;
			   first=last;
		   }
		   node oldlast= last;
		   last =new node();
		   last.item =item;
		   last.pre=oldlast;
		   last.next=null;
		   n++;
	   }
	   public Item removeFirst()     {
		   // remove and return the item from the front
		   Item item = first.item;
		   first=first.next;
		   first.pre=null;
		   n--;
		   if(isEmpty())
			   last=null;
		   return item;
	   }
	   public Item removeLast()       { 
	   // remove and return the item from the end
		   Item item =last.item;
		   last=last.pre;
		   last.next=null;
		   n--;
		   if(isEmpty())
			   first=null;
		   return item;
	   }
		   
	   public Iterator<Item> iterator() {
	   // return an iterator over items in order from front to end
		   return new DequeIterator();
	   }
	   private class DequeIterator<Item> implements Iterator<Item> {
		   
		private node current= first;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if(current.next!=null)
				return true;
			return false;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
		    current= current.next;
			return (Item) current.item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}

	
		   
	   public void main(String[] args){   // unit testing
	   
	   }

	   }

}

import java.util.Iterator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class ResizingArrayQueue<Item> implements Iterable<Item> {

	private Item[] a;
	private int first;
	private int last;
	private int n;
	public boolean isEmpty() {return n==0;}
	public int size(){return n;}
	public void resize(int max){
		Item temp[]= (Item[])  new Object[max];
		for (int i = 0; i < n; i++) {
			temp[i]=a[i];
		}
		a=temp;
		first=0;//!!!!!!!!!!!!!!!!!!!!!!!!
		last=n;//!!!!!!!!!!!!!!!!!!!!!!!!!!
	}
	public void enque(Item item){
		if(n==a.length) resize(2*a.length);
		a[last++]=item;
		if(last==a.length) last=0;//wrap round
		n++;
	}
	public Item deque(){
		Item item=a[first];
		a[first]=null;
		first++;
		if(first==a.length) first=0;
		n--;
		if(n==a.length/4) resize(a.length/2);
		return item;
	}
	public ResizingArrayQueue() {
		// TODO Auto-generated constructor stub
	 a =(Item[])new Object[2];
	 last=0;
	 first=0;
	 n=0;
	}

	@Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }
    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;
        public boolean hasNext()  { return i < n;                               }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            Item item = a[(i + first) % a.length];
            i++;
            return item;
        }
    }

	/**
	 * @param args
	 */
    public static void main(String[] args) {
        ResizingArrayQueue<String> queue = new ResizingArrayQueue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) queue.enque(item);
            else if (!queue.isEmpty()) StdOut.print(queue.deque() + " ");
        }
        StdOut.println("(" + queue.size() + " left on queue)");
    }

}

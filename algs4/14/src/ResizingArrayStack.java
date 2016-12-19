import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class ResizingArrayStack<Item>  {

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
	return n;
	}
	public ResizingArrayStack() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
        ResizingArrayStack<String> s=new ResizingArrayStack<>();//create class
        while(!StdIn.isEmpty()){
       	 String item = StdIn.readString();
       	 if(!item.equals("-"))
       		 s.push(item);
       	 else if (!s.IsEmpty()) {
       		 StdOut.println(s.pop()+" ");
			}
       
       	 
        }	StdOut.println("(" + s.size()+" left on stack)");
	}

	

}

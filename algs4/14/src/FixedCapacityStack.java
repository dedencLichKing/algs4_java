import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class FixedCapacityStack<Item> {

	private Item[] a;
	private int n=0;
	public FixedCapacityStack(int cap) {
		// TODO Auto-generated constructor stub
		a=(Item[])new Object[cap];
	}
	public void push(Item item){
		a[n++]=item; //  a[n]=item; n++;
	}
	public Item pop(){
		return a[--n];//n--; rerurn a[n];
	}
	public boolean isEmpty(){
	return n==0;
	}
	public int size(){
		return n;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         FixedCapacityStack<String> s=new FixedCapacityStack<String>(100);//create class
         while(!StdIn.isEmpty()){
        	 String item = StdIn.readString();
        	 if(!item.equals("-"))
        		 s.push(item);
        	 else if (!s.isEmpty()) {
        		 StdOut.println(s.pop()+" ");
			}
        	
        	 
         }StdOut.println("(" + s.size()+" left on stack)");
	}

}
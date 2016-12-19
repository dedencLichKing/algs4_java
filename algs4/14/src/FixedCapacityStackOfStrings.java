import java.security.PrivateKey;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


class FixedCapacityStackOfStrings {
	
	private String[] a;
	private int n=0;
	public FixedCapacityStackOfStrings(int cap) {
		// TODO Auto-generated constructor stub
		a=new String[cap];
	}
	public void push(String item){
		a[n++]=item; //  a[n]=item; n++;
	}
	public String pop(){
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
         FixedCapacityStackOfStrings s=new FixedCapacityStackOfStrings(100);//create class
         while(!StdIn.isEmpty()){
        	 String item = StdIn.readString();
        	 if(!item.equals("-"))
        		 s.push(item);
        	 else if (!s.isEmpty()) {
        		 StdOut.println(s.pop()+" ");
			}
        	StdOut.println("(" + s.size()+" left on stack)");
        	 
         }
	}

}

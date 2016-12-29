import edu.princeton.cs.algs4.StdOut;


public class HeapSort<Key extends Comparable<Key>> {
	private static Comparable[] pq;
	private int n;
	public HeapSort(int max){
		 pq=  new Comparable[max+1];
	}
	public boolean IsEmpty(){
		return n==0;
		
	}
	public int size(){
		return n;
	}
    public static void sort(Comparable[] a){
    	int n=a.length;
    	for(int k=n/2;k>0;k--)//heap construction
    		sink(pq,k,n);
    	while(n>1){//sortdown
    		exch(pq, 1, n--);
    		sink(a, 1,n);
    	}
    }
    private static void sink(Comparable[] pq,int k,int n){
    	while(k*2<=n){
    		int j= k*2;
    		if(less(pq[j],pq[j+1])) j++;
    		if(!less(pq[k], pq[j])) break;
    		exch(pq,k,j);
    		k=j;
    	}
    }
    
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
private static void exch(Comparable[] a,int i,int j){
	Comparable t= a[i];a[i]=a[j];a[j]=t;    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a={"this"," sio"," s","jh"," fjhj","  d"};
		for (int i = 0; i < a.length; i++) {
			StdOut.println(a[i]+" ");
		}
      sort(a);
      for (int i = 0; i < a.length; i++) {
		StdOut.println(a[i]+" ");
	}
	}

}

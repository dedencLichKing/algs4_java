import edu.princeton.cs.algs4.StdOut;


public class MergeBU {
	private static Comparable[] aux;
	private static void merge(Comparable[] a ,int lo,int mid,int hi){
		int i=lo;
		int j=mid+1;
		for (int k =lo; k <= hi; k++) 
			aux[k]=a[k];//copy the a
		for(int k=lo;k<=hi;k++){
			if(i>mid) a[k]=aux[j++];
			else if(j>hi)a[k]=aux[i++];
			else if(less(a[i],a[j])) a[k]=aux[i++];
			else a[k]=aux[j++];
		}	
		
	}
	public static void sort(Comparable[] a){
		
		int n=a.length;
		aux=new Comparable[a.length];
		for(int sz=1;sz<n;sz=sz+sz){
			for(int lo=0;lo<n-sz;lo+= sz+sz)
	         merge(a, lo, lo+sz-1,Math.min(lo+sz+sz-1, n-1));			
		}
	}
	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w)<0;
		
	}
	private static void exch(Comparable[] a,int i,int j){
		Comparable t= a[i];a[i]=a[j];a[j]=t;
	}
	private static void show(Comparable[] a){
		for (int i = 0; i < a.length; i++) 
			StdOut.println(a[i]+" ");
		//StdOut.println();
	}
	public MergeBU() {
		
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a ={"gc","d","h","d","d","a","s","a","c","t"};	
		sort(a);
		show(a);
			
	}

}

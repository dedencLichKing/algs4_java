import org.omg.PortableServer.ServantLocatorPackage.CookieHolder;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;


public class Example {

	public static void selection_sort(Comparable[] a){
		int n=a.length;
		for(int i=0;i<n;i++){
			int min = i;
			for (int j = i+1; j <n; j++) {
				if(less(a[j], a[min])) min=j;
				exch(a, i, min);
			   }
		}
	}
	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w)<0;
		
	}
	private static void exch(Comparable[] a,int i,int j){
		Comparable t= a[i];a[i]=a[j];a[j]=t;
	}
	private static void show(Comparable[] a){
		for (int i = 0; i < a.length; i++) {
			StdOut.println(a[i]+" ");
		//StdOut.println();
		}
	}
	public  static boolean  isSorted(Comparable[] a ) {
		for (int i = 0; i < a.length; i++) {
			if(less(a[i], a[i+1]))
				return true;
		}
		return false;
		
	}
	public Example() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Comparable[]  a;
		a= new Comparable[6];
		for (int i = 0; i < a.length; i++) {
			a[i]=i;
		}
		assert isSorted(a);
		
		
		 if(isSorted(a))
		 StdOut.print("sorted");
		 else {
			 selection_sort(a);
			show(a);
		}
	}

}

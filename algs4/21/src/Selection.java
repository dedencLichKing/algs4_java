import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;


public class Selection {
	
	public static void sort(Comparable[] a){
		int n=a.length;
		for (int i = 0; i < a.length; i++) {
			int min=i;
			for (int j = i+1; j < a.length; j++) 
				if(less(a[j],a[min])) min=j;
			exch(a,i,min);
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
	public Selection() {
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
			a[i]=-i;
		}
		show(a);
		sort(a);
		show(a);
	}

}

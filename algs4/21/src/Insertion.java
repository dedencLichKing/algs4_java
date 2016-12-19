import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;


public class Insertion {

	public static void sort(Comparable[] a ){
		int n =a.length;
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j >0; j--) {//!!!!!!!!!j--
				if(less(a[j],a[j-1]))
				exch(a,j,j-1);
				else break;
			}
		}
	}
	public static boolean less(Comparable v,Comparable w){
		return v.compareTo(w)<0;
	}
	public static boolean isSort(Comparable[]a){
		for (int i = 0; i < a.length; i++) {
			if(less(a[i], a[i+1]))
				return true;
		}
		return false;
	}
	public static void exch(Comparable[] a,int i,int j){
		Comparable t =a[i];a[i]=a[j];a[j]=t;
	}
	public static void show(Comparable[] a){
		for (int i = 0; i < a.length; i++) {
			StdOut.println(a[i]+" ");
		}
	}
	public Insertion() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    String[] a ={"g","d","h","a","c"};
		//int[]a={1,2,3,4,6};
    sort(a);
    assert isSort(a);
    show(a);
	}

}

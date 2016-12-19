import edu.princeton.cs.algs4.StdOut;


public class Shell {

	public static void sort(Comparable[] a){
		//Éú³Éh 1,3,
		int n =a.length;
		int h=0;
		while(h<(n/3)) h=h*3+1;
		//h loop
		for(;h>0;h/=3){
			//insertion
			for (int i = h; i < a.length; i++) {
				for (int j = i; j >= h; j=j-h) {
					if(less(a[j],a[j-h]))
						exch(a,j,j-h);
				}
			}
			
		}
	}
	public static boolean less(Comparable v,Comparable w){
		return v.compareTo(w)<0;	}
	public static boolean isSorted(Comparable[]a){
		for (int i = 0; i < a.length; i++) {
			if(less(a[i], a[i+1]))
				return true;
			
		}
		return false;
	}
	public static void exch(Comparable[] a,int i,int j){
		Comparable t =a[i];a[i]=a[j];a[j]=t;
	}
	public static void show(Comparable[] a ){
		for (int i = 0; i < a.length; i++) {
			StdOut.println(a[i]+" ");
		}
	}
	public Shell() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String[] a ={"g","d","h","a","c","t"};
		
		 sort(a);
		// if(isSorted(a))
		 //StdOut.print("sorted");
		 //else {
			 sort(a);
			show(a);
	//}

	}
}

import edu.princeton.cs.algs4.StdOut;


public class Quick3way {

	public Quick3way() {
		// TODO Auto-generated constructor stub
	}
    private static void sort(Comparable[] a,int lo,int hi){
    	int lt =lo,i=lo+1,gt= hi;
    	if(lo>=hi) return ;
    	Comparable v =a[lo];
        
        while(i<=gt){
        	int cmp=v.compareTo(a[i]); //a[lo]>a[i]  cmp>0;
    		if(cmp>0) exch(a,lt++,i++);
    		else if(cmp<0) exch(a,i,gt--);
    		else i++;
    	}
        sort(a, lo, lt-1);
        sort(a,gt+1,hi);
    }
    public static void sort(Comparable[] a){
    	sort(a, 0, a.length-1);
    }
    private static void exch(Comparable[] a,int i,int j){
    	Comparable tComparable=a[i];a[i]=a[j];a[j]=tComparable;
    }
    private static void show(Comparable[] a){
    	
    	for (int i = 0; i < a.length; i++) {
			StdOut.println(a[i] +" ");
		}}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a ={"c","d","h","d","d","a","s","a","c","t"};
        sort(a);
		show(a);
			//}

	}

}

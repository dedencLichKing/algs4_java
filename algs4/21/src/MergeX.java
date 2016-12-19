import edu.princeton.cs.algs4.StdOut;


public class MergeX {

	public MergeX() {
		// TODO Auto-generated constructor stub
	}

	private static 	Comparable[] aux;
	private static  int cutoff=3;
	private static void sort(Comparable[] a,int lo ,int hi){
	  if(hi-lo<cutoff){//  小数据用插入排序
			Insertion.sort(a);
			return;
		}
		//if(hi==lo)return;  //原始排序
		int mid = lo+(hi-lo)/2;
		sort(a, lo, mid);
		sort(a, mid+1, hi);
		if(less(a[mid], a[mid+1])){// 如果子序列已经有序，不merge
			return;
		}
		merge(a, lo, mid, hi);
		
	}
	public static void merge(Comparable[] a,int lo,int mid,int hi){
		for (int i = lo; i <=hi; i++) {
			aux[i]=a[i];
		}
		int i=lo;
		int j=mid+1;
	    for (int j2 = lo; j2 <= hi; j2++) {
	    	if(i>mid) a[j2]=aux[j++];
	    	else if (j>hi) a[j2]=aux[i++];
	    	else if(less(aux[j],aux[i]))a[j2]=aux[j++];
	    	else a[j2]=aux[i++];
	
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
	public static void sort(Comparable[] a){
		aux=new Comparable[a.length];
		sort(a, 0, a.length-1);
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] a ={"g","d","h","d","d","a","s","a","c","t"};
	
		sort(a);
		// if(isSorted(a))
		 //StdOut.print("sorted");
		//else {
		sort(a);
		show(a);
			//}

			}

	}

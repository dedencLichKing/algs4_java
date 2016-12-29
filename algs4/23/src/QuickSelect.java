
import java.awt.print.Printable;
import java.util.Random;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


public class QuickSelect  {

	public QuickSelect() {
		// TODO Auto-generated constructor stub
	}
	public static 	Comparable select(Comparable[]  a,int k){
		StdRandom.shuffle(a);
		int lo=0,hi=a.length-1;
		
		while(lo<hi){
			int j = partion(a, lo, hi);
			if(j<k) lo= j+1;
			else if(j>k) hi=j-1;
			else return a[k];
		}
		return a[k];
		
	}
	
	
	
	
    private static int partion(Comparable[] a,int lo,int hi){
    	int i=lo,j=hi+1;
        Comparable v=a[lo];
    	while(true){
    		
    		while(less(a[++i],v)) if(i==hi) break;
    		while(less(v,a[--j])) if(j==lo) break;
    		if(i>=j) break;
    		exch(a,i,j);
    	}
    	exch(a,lo,j);
    	return j;
    }
    private static int medianOf3(Comparable[] a, int i, int j, int k) {
        return (less(a[i], a[j]) ?
                (less(a[j], a[k]) ? j : less(a[i], a[k]) ? k : i) :
                (less(a[k], a[j]) ? j : less(a[k], a[i]) ? k : i));
     }
    private static void sort(Comparable a[],int lo,int hi){
    	
    	if(lo>=hi)return;
    	int m= medianOf3(a, lo, lo + (hi - lo)/2, hi);
    	int j=partion(a, lo, hi);
    	sort(a, lo, j-1);
    	sort(a, j+1, hi);	
    	
    }
    public static void sort(Comparable[] a){
    	StdRandom.shuffle(a);
    	sort(a,0,a.length-1);
    }
    private static boolean less(Comparable v, Comparable w){
    	return v.compareTo(w)<0;
    }
    private static void exch(Comparable[] a,int i,int j){
    	Comparable t= a[i];a[i]=a[j];a[j]=t;    }
    private static void show(Comparable[] a){
    	for (int i = 0; i < a.length; i++) {
    		StdOut.println(a[i]+" ");
			
		}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] a ={"c","d","h","d","d","a","s","a","c","t"};
		//sort(a);
		//show(a);
		int k=1;
	    StdOut.print(select(a, k));
			}

}


import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;


public class SortCompare {
	public static double time (String alg ,Comparable[] a){
		Stopwatch timer=new Stopwatch();
		if(alg.equals("Insertion")) Insertion.sort(a);
		if(alg.equals("Selection")) Selection.sort(a);
		if(alg.equals("Shell")) Shell.sort(a);
		if(alg.endsWith("Merge")) ;
		if(alg.equals("Quick")) ;
		if(alg.equals("Heap"));
		return timer.elapsedTime();
	}
	public static double timeRandomInput(String als,int N,int T){
		double total=0.0;
		Double[] a =new Double[N];
		for (int t = 0; t <T; t++) {
			for (int i = 0; i < N; i++) 
				a[i]=StdRandom.uniform();
			total+=time(als, a);
		}
		return total;
	}


	public SortCompare() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String alg1=args[0];
		String alg2=args[1];
		int n = Integer.parseInt(args[2]);
		int t = Integer.parseInt(args[3]);
		double t1 = timeRandomInput(alg1, n, t);
		double t2 = timeRandomInput(alg2, n, t);
		StdOut.printf("for %d  random doubles\n %s is", n,alg1);
		StdOut.printf("%1f  times faster than  %s\n", t2/t1,alg2);
		
		

	}

}

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;


public class ThreeSum {

	/**
	 * @param args
	 */
	public static int  count(int[] a) {
		// TODO Auto-generated method stub
		int n =a.length;
		int cnt=0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				for (int j2 = j+1; j2 < a.length; j2++) {
					if(a[i]+a[j]+a[j2]==0)
						cnt++;
				}
			}
		}
		return cnt;
	}
	public static void main(String[] args) {
		int n= In.readInts(args[0]);
		int[] a =
		StdOut.println(count(a));
	}

}

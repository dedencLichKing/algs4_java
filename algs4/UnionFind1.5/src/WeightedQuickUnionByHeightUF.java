import java.security.PublicKey;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnionByHeightUF {

	/**
	 * UF(int n) initialize N sites with integer names(0 to n-1) void union(int
	 * p,int q) add connection between p and q int find(int p )
	 * componentidertifier for p(0 to n-1) boolean connected(int p,int q) return
	 * true if p and q are same componnet int count() number of component int
	 * count()
	 * 
	 * @param args
	 */
	private int[] id;
	private int count;
	private int[] hight;//��ʾ������ȣ�������������

	public WeightedQuickUnionByHeightUF(int n) {
		id = new int[n];
		count = n;
		hight = new int[n];
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
			hight[i] = 1;
		}
	}

	public int find(int p) {
		while (p != id[p]) {
			p = id[p];
		}
		return p;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public void union(int p, int q) {
		int proot = find(p);
		int qroot = find(q);
		if (proot == qroot)
			return;
		if (hight[proot] > hight[qroot])// ���p�ĸ߶ȸ�
			id[qroot] = proot; // ��qroot���ӵ�proot����
		else if (hight[proot] < hight[qroot])
			id[proot] = qroot;
		else {// ���PROOT ==QROOT���ĸ߶ȼ�1
			id[proot] = qroot;
			hight[qroot] = +1;
		}
		count--;
	}

	public int count() {
		return count;
	}

	public static void main(String[] args) {
		int n = StdIn.readInt();

		WeightedQuickUnionByHeightUF uf = new WeightedQuickUnionByHeightUF(n);

		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (uf.connected(p, q))
				continue;
			uf.union(p, q);
		}
		StdOut.println("weighted by hight " + uf.count() + " components");
	}

}

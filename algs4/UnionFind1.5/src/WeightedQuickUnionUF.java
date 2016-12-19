import java.security.PublicKey;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class WeightedQuickUnionUF {
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
	private int[] sz;//�������ʾ�������Ĵ�С �����Ǹ߶ȣ�����������������
              // number of sites in subtree rooted at i  ����������ʾÿ���ڵ�ĸ߶ȱȽϺ�
	public void WeightedQuickUnionUF(int n){
		id = new int[n];
		count = n;
	    sz = new int[n];
	   for (int i = 0; i < id.length; i++) {
		id[i]=i;
		sz[i]=1;
	}	
	}
	public int find(int p) {
		while(p!=id[p]){
			p=id[p];
		}
	return p;
	}
	public boolean connected(int p, int q ) {
		return find(p)==find(q);
	}
	public void union(int p ,int q ) {
		int proot=find(p);
	    int	qroot=find(q);
	    if(proot==qroot) return;
	    if(sz[proot]>sz[qroot]){//���p�ĸ߶ȸ�
	    	id[qroot]=proot;  //��qroot���ӵ�proot����
	    	sz[proot]+=sz[qroot];//p�ĸ߶�����
	    }
	    else {
	    	id[proot]=qroot;
	    	sz[qroot]+=proot;
			
		}
	 count--;
	}
	public int count() {
		return count;
	}

	public static void main(String[] args) {
		int n = StdIn.readInt();

		QuickUnionUF uf = new QuickUnionUF(n);

		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (uf.connected(p, q))
				continue;
			uf.union(p, q);
		}
		StdOut.println("weighted "+uf.count() + " components");
	}

}

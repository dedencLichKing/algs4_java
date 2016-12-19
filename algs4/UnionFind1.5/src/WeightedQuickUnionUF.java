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
	private int[] sz;//用数组表示的是树的大小 而不是高度！！！！！！！！！
              // number of sites in subtree rooted at i  用数组来表示每个节点的高度比较好
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
	    if(sz[proot]>sz[qroot]){//如果p的高度高
	    	id[qroot]=proot;  //把qroot连接到proot下面
	    	sz[proot]+=sz[qroot];//p的高度增加
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

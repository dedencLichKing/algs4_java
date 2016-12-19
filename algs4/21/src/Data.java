
public class Data implements Comparable<Data>{
	private final int day;
	private final int month;
	private final int year;
	
	public Data(int d, int m,int y) {// 初始化日期
		day=d;month=m;year=y;
		// TODO Auto-generated constructor stub
	}

	public int compareTo(Data that) {
		if(this.year>that.year) return +1;
		if(this.year<that.year) return -1;
		if(this.month>that.month) return +1;
		if(this.month<that.month) return -1;
		if(this.day>that.day) return +1;
		if(that.day<that.day) return -1;
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @param args
	 */
	public String tostring(){
		return month +"/"+day+"/"+year;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

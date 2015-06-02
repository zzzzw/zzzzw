//3.140000 这个比较难一点
public class oj1002 {
	public static void main(String args[])
	{
		char A='A';
		//double b=3.140000;
		System.out.println(100);
		System.out.println(A);
		//String b1 = new Double(b).toString();
		//System.out.println(b1.substring(b1.lastIndexOf(".")+1,3));
		//System.out.println((double) (Math.round(b*1000)/1000.0)); 
		String pattern="0.000000";
		java.text.DecimalFormat df=new java.text.DecimalFormat(pattern);
		String s=df.format(3.140000);
		System.out.println(s);
		
	}

}

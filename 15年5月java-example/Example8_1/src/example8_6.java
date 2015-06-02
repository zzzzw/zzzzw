
public class example8_6 
{
	@SuppressWarnings("unused")
	public static  void main(String args[])
	{
		try{
			String s=args[0];
			int a=Integer.parseInt(s);
			int b=100/a;
			System.out.println("除法结束。");
		}catch(ArithmeticException e){//捕获除数为零的异常
			System.out.println("捕捉到异常");
			System.out.println("toString()信息："+e.toString());
			System.out.println("getMessage()信息："+e.getMessage());
		}catch(ArrayIndexOutOfBoundsException e2){
			System.out.println(e2.toString());
		}
	
		System.out.println("主程序结束。");
	}

}

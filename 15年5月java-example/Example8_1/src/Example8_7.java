
public class Example8_7 
{
	@SuppressWarnings("unused")
	public static  void main(String args[])
	{
		try{
			String s=args[0];
			int a=Integer.parseInt(s);
			int b=100/a;
			
		}catch(ArithmeticException e){//�������Ϊ����쳣
			
			System.out.println(e.toString());
			
		}catch(ArrayIndexOutOfBoundsException e2){
			System.out.println(e2.toString());
		}finally{
			System.out.println("ִ��finally���");
		}
	
		
	}


}


public class example8_6 
{
	@SuppressWarnings("unused")
	public static  void main(String args[])
	{
		try{
			String s=args[0];
			int a=Integer.parseInt(s);
			int b=100/a;
			System.out.println("����������");
		}catch(ArithmeticException e){//�������Ϊ����쳣
			System.out.println("��׽���쳣");
			System.out.println("toString()��Ϣ��"+e.toString());
			System.out.println("getMessage()��Ϣ��"+e.getMessage());
		}catch(ArrayIndexOutOfBoundsException e2){
			System.out.println(e2.toString());
		}
	
		System.out.println("�����������");
	}

}

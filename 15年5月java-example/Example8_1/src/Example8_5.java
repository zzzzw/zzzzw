
public class Example8_5 
{
	@SuppressWarnings("unused")
	public static  void main(String args[])
	{
		int a=0;
		try{
			int b=100/a;
			System.out.println("����������");
		}catch(ArithmeticException e){//�������Ϊ����쳣
			System.out.println("��׽���쳣");
			System.out.println("toString()��Ϣ��"+e.toString());
			System.out.println("getMessage()��Ϣ��"+e.getMessage());
		}
		System.out.println("�����������");
	}

}

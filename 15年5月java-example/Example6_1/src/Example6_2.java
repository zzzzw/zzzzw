class Wardrobe extends Chest
{
	public void storage()
	{
		System.out.println("�¹��ܴ���·�");
	}
}
class Cupboard extends Chest
{
	public void storage()
	{
		System.out.println("�����ܴ�����Ӻ���");
	}
	
}
public class Example6_2 
{
	public static void main(String args[])
	{
		Wardrobe w=new Wardrobe();
		w.open();
		w.storage();
		Cupboard c=new Cupboard();
		c.open();
		c.storage();
	}

}

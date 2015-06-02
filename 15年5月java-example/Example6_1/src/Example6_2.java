class Wardrobe extends Chest
{
	public void storage()
	{
		System.out.println("衣柜能存放衣服");
	}
}
class Cupboard extends Chest
{
	public void storage()
	{
		System.out.println("橱柜能存放盘子和碗");
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

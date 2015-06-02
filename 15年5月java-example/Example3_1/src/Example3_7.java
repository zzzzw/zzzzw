
public class Example3_7
{
	public static void main(String args[])
	{
		int score=100;
		switch(score/10)
		{
		case 10:case 9:
			System.out.println("your score is perfect and gain a A");
			break;
		case 8: case 7:
			System.out.println("your score is great and gain a B");
			break;
		case 6:case 5:
			System.out.println("you should work harder to gain a more beautiful socre! you just gain a C");
			
		}
	}

}

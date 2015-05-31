package entity.exam;

public class Teacher extends User
{
	private String tid;
	private String title;
	public Teacher(String tid,String name,String sex,String cardNumber,String password,String title,String phone)
	{
		super(cardNumber,name,sex,password,phone);
		this.tid=tid;
		this.title=title;
		
	}
	public String getTid()
	{
		return tid;
	}
	public void setTid(String tid) 
	{
		this.tid = tid;
	}
	public String getTitle() 
	{
		return title;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}
}

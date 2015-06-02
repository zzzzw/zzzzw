package entity.exam;

public class Student extends User
{
	private String sid;
	private String dept;
	public Student()
	{
		super();
	}
	public Student(String sid,String name,String sex,String cardNumber,String password,String dept,String phone)
	{
		super(cardNumber,name,sex,password,phone);
		this.sid=sid;
		this.dept=dept;
	}
	public String getSid()
	{
		return sid;
	}
	public void setSid(String sid) 
	{
		this.sid = sid;
	}
	public String getDept() 
	{
		return dept;
	}
	public void setDept(String dept) 
	{
		this.dept = dept;
	}
}

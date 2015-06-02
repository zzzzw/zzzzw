package entity.exam;

public class User 
{
	protected String name;
	protected String sex;
	protected String cardNumber;
	protected String password;
	protected String phone;
	public User(String cardNumber,String name, String sex,String password,String phone)
	{
		super();
		this.cardNumber=cardNumber;
		this.name=name;
		this.sex=sex;
		this.password=password;
		this.phone=phone;
	}
	public User()
	{
		super();
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone=phone;
	}
	public String getCardNumber()
	{
		return cardNumber ;
	}
	public void setCardNumber(String cardNumber)
	{
		this.cardNumber=cardNumber;
	}
	public String getName()
	{
		return name ;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex )
	{
		this.sex=sex;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}
}

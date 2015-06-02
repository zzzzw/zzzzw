package entity.exam;

public class Administrator extends User 
{
	private String adid;
	public Administrator(String adid,String name,String sex,String cardNumber,String password,String phone)
	{
		super(cardNumber,name,sex,password,phone);
		this.adid=adid;
	}
	public String getAdid() 
	{
		return adid;
	}
	public void setAdid(String adid) 
	{
		this.adid = adid;
	}
}

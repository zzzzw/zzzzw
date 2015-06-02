package Example5_1;

public class Example5_1
{
	public static void main(String args[])
	{
		Telephone2 t=new Telephone2("TCL","123123123",100);
		t.setRate(0.2);
		t.setDialledTime(150);
		t.display();
		t.callCost();
		t.recharge(50);
	}

}
class Telephone2
{
	private String brand;
	private String number;
	private double dialledTime;
	private double rate;
	private double balance;
	
	public Telephone2(String brand,String number,double balance)
	{
		this.brand=brand;
		this.number=number;
		this.balance=balance;
		
	}
	public void setBrand(String brand)
	{
		this.brand=brand;
	}
	public String getBrand()
	{
		return brand;
	}
	public void setNumber(String number)
	{
		this.number=number;
	}
	public String getNumber()
	{
		return number;
	}
	public void setDialledTime(double dialledTime)
	{
		this.dialledTime=dialledTime;
	}
	public double getDialledTime()
	{
		return dialledTime;
	}
	public void setRate(double rate)
	{
		this.rate=rate;
	}
	public double getRate()
	{
		return rate;
	}
	
	
	
	public double getBalance()
	{
		return balance;
	}
	public void recharge(double cost)
	{
		balance=balance+cost;
		System.out.println("��ֵ�����"+balance);
		
	}
	
	public void callCost()
	{
		double callcost=dialledTime*rate;
		balance=balance-callcost;
		System.out.println("���ѣ�"+callcost);
		System.out.println("��"+balance);
	}
	public void display()
	{
		System.out.println("�绰Ʒ�ƣ�"+brand+"�绰����:"+number);
		System.out.println("ͨ��ʱ�䣺"+dialledTime+"����"+rate);
	}
}

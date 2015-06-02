package example4_11;

public class Example4_11 
{
	public static void main(String args[])
	{
		Telephone tel=new Telephone("ZFL","12341234",100);
		tel.rate=0.2;
		tel.dialledTime=150;
		tel.display();
		tel.callCost();
		tel.recharge(50);
	}
	

}
class Telephone
{
	String brand;
	String number;
	double dialledTime;
	double rate;
	double balance;
	public Telephone(String brand,String number,double balance)
	{
		this.brand=brand;
		this.number=number;
		this.balance=balance;
	}
	public void recharge(double cost)
	{
		balance=balance+cost;
		System.out.println("充值后的余额："+balance);
	}
	public void callCost()
	{
		double callcost=dialledTime*rate;
		balance=balance-callcost;
		System.out.println("话费:"+callcost);
		System.out.println("余额"+balance);
	}
	public void display()
	{
		System.out.println("电话品牌"+brand+"电话号码："+number);
		System.out.println("通话时间"+dialledTime+"费率："+rate);
	}
}

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
		System.out.println("��ֵ�����"+balance);
	}
	public void callCost()
	{
		double callcost=dialledTime*rate;
		balance=balance-callcost;
		System.out.println("����:"+callcost);
		System.out.println("���"+balance);
	}
	public void display()
	{
		System.out.println("�绰Ʒ��"+brand+"�绰���룺"+number);
		System.out.println("ͨ��ʱ��"+dialledTime+"���ʣ�"+rate);
	}
}

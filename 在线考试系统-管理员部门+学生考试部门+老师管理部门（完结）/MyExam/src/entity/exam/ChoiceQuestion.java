package entity.exam;

public class ChoiceQuestion 
{
	private int c_id;
	private String c_question;
	private String c_choiceA;
	private String c_choiceB;
	private String c_choiceC;
	private String c_choiceD;
	private String c_answer;
	public ChoiceQuestion(int c_id,String c_question,String c_choiceA,String c_choiceB,String c_choiceC,String c_choiceD, String c_answer)
	{
		super();
		this.c_id=c_id;
		this.c_question=c_question;
		this.c_choiceA=c_choiceA;
		this.c_choiceB=c_choiceB;
		this.c_choiceC=c_choiceC;
		this.c_choiceD=c_choiceD;
		this.c_answer=c_answer;
	}
	public  ChoiceQuestion(String c_question,String c_choiceA,String c_choiceB,String c_choiceC,String c_choiceD, String c_answer)
	{
		super();
		this.c_question=c_question;
		this.c_choiceA=c_choiceA;
		this.c_choiceB=c_choiceB;
		this.c_choiceC=c_choiceC;
		this.c_choiceD=c_choiceD;
		this.c_answer=c_answer;
	}
	public int getC_id() 
	{
		return c_id;
	}
	public void setC_id(int c_id) 
	{
		this.c_id = c_id;
	}
	public String getC_question()
	{
		return c_question;
	}
	public void setC_question(String c_question) 
	{
		this.c_question = c_question;
	}
	public String getC_choiceA() 
	{
		return c_choiceA;
	}
	public void setC_choiceA(String c_choiceA) 
	{
		this.c_choiceA = c_choiceA;
	}
	public String getC_choiceB() 
	{
		return c_choiceB;
	}
	public void setC_choiceB(String c_choiceB) 
	{
		this.c_choiceB = c_choiceB;
	}
	public String getC_choiceC() 
	{
		return c_choiceC;
	}
	public void setC_choiceC(String c_choiceC) 
	{
		this.c_choiceC = c_choiceC;
	}
	public String getC_choiceD() 
	{
		return c_choiceD;
	}
	public void setC_choiceD(String c_choiceD)
	{
		this.c_choiceD = c_choiceD;
	}
	public String getC_answer() 
	{
		return c_answer;
	}
	public void setC_answer(String c_answer)
	{
		this.c_answer = c_answer;
	}
}

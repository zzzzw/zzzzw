package entity.exam;

public class FillQuestion 
{
	private int f_id;
	private String f_question;
	private String f_answer;
	public FillQuestion(int f_id,String f_question,String f_answer)
	{
		super();
		this.f_id=f_id;
		this.f_question=f_question;
		this.f_answer=f_answer;
	}
	public FillQuestion(String f_question,String f_answer)
	{
		super();
		this.f_question=f_question;
		this.f_answer=f_answer;
	}
	public int getF_id() 
	{
		return f_id;
	}
	public void setF_id(int f_id) 
	{
		this.f_id = f_id;
	}
	public String getF_question() 
	{
		return f_question;
	}
	public void setF_question(String f_question) 
	{
		this.f_question = f_question;
	}
	public String getF_answer() 
	{
		return f_answer;
	}
	public void setF_answer(String f_answer) 
	{
		this.f_answer = f_answer;
	}
}

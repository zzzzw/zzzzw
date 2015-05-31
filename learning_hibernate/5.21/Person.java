package com.henu.domain;

import java.io.Serialize;
//import java.util.ArrayList;
//import java.util.HashMap;
import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
import java.util.Set;

public class Person implements Serialize
{
	private static final long serialVersionUID=1L;
	private int id;
	private String name;
	private int age;
	private String major;

    //private List courses = new ArrayList();
	//private String[] courses;
	//private Map courses = new HashMap();
	private Set course=new HashSet();

	public Person()
	{}
	public Person(int id,String name,int age,String major,Set courses)
	{
		super();
		this.id=id;
		this.name=name;
		this.age=age;
		this.major=major;
		this.courses=courses;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age=age;
	}
	public String getMajor(String major)
	{
		this.major=major;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id=id;
	}

	public Set getCourse()
	{
		return courses;
	}
	public void setCourses(set courses)
	{
		this.courses=courses;
	}
package com.henu.app;
import java.util.*;
public class CollectionObj {
	//声明java.util.Properties类型的属性fieldProp
	private Properties fieldProp;
	//声明java.util.List类型的属性fieldList
	private List fieldList;
	//声明java.util.Set类型的属性fieldSet
	private Set fieldSet;
	//声明java.util.Map类型的属性fieldMap
	private Map fieldMap;
	//声明数组类型的属性fieldArray
	private String[] fieldArray;
	//省略各属性的setter和getter方法
	public Properties getFieldProp() {
		return fieldProp;
	}
	public void setFieldProp(Properties fieldProp) {
		this.fieldProp = fieldProp;
	}
	public List getFieldList() {
		return fieldList;
	}
	public void setFieldList(List fieldList) {
		this.fieldList = fieldList;
	}
	public Set getFieldSet() {
		return fieldSet;
	}
	public void setFieldSet(Set fieldSet) {
		this.fieldSet = fieldSet;
	}
	public Map getFieldMap() {
		return fieldMap;
	}
	public void setFieldMap(Map fieldMap) {
		this.fieldMap = fieldMap;
	}
	public String[] getFieldArray() {
		return fieldArray;
	}
	public void setFieldArray(String[] fieldArray) {
		this.fieldArray = fieldArray;
	}
}

package com.henu.app;
import java.util.*;
public class CollectionObj {
	//����java.util.Properties���͵�����fieldProp
	private Properties fieldProp;
	//����java.util.List���͵�����fieldList
	private List fieldList;
	//����java.util.Set���͵�����fieldSet
	private Set fieldSet;
	//����java.util.Map���͵�����fieldMap
	private Map fieldMap;
	//�����������͵�����fieldArray
	private String[] fieldArray;
	//ʡ�Ը����Ե�setter��getter����
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

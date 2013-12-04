package com.jerome.basic.beans;

public class Student extends Person {
	private static final long serialVersionUID = -6919920116083009512L;
	private String schoolName;

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public Student(String name, int age, String idNum, String schoolName) {
		super(name, age, idNum);
		this.schoolName = schoolName;
	}

	@Override
	public String toString() {
		return super.toString() + "Student [schoolName=" + schoolName + "]";
	}
}

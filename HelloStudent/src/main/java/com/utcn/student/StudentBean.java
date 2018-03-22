/*package com.utcn.student;

import javax.faces.bean.ManagedBean;

//@ManagedBean(name = "studentBean", eager = true)
public class StudentBean {

	private String name;
	private int age;

	public StudentBean() {
		System.out.println("HelloStudent Application started!");
	}

	public String getMessage() {
		return "Please register here";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRegistrationMessage() {
		return "Thanks for registering " + name + " !";
	}

	public void save() {
		Student student = Student.createStudent(name, age);
		System.out.println("Over 20 years: " + student.checkStudentOverTwentyYears());
		student.save();
	}

}
*/

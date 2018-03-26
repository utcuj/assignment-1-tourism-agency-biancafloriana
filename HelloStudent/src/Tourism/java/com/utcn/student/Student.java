package com.utcn.student;

import com.utcn.student.db.DatabaseConnection;

public class Student {

	private String name;
	private int age;
	private static DatabaseConnection databaseConnection = new DatabaseConnection();

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
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

	public static Student createStudent(String name, int age) {
		Student student = new Student(name, age);
		return student;
	}

	public boolean checkStudentOverTwentyYears(){
		return age > 20;
	}

	public void save() {
		databaseConnection.openConnectionToDatabase();
		databaseConnection.executeQuery("INSERT INTO student.student (name, age)" + ""
				+ " VALUES ( '"+ name + "', '" + age + "' )", "update");
		System.out.println("Saved new student in database: Name= " + name + "Age= " + age);

		databaseConnection.closeConnectionToDatabase();
	}
}

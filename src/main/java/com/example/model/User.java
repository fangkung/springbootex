package com.example.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class User implements Serializable {	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	
	@NotNull(message = "User name is required.")
	private String name;
	
	@NotNull(message = "User age is required.")
	private int age;
	
	@NotNull(message = "User salary is required.")
	private double salary;

	public User() {
		id = 0;
	}

	public User(long id, String name, int age, double salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}

}

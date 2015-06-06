package com.modSys.model;

public class User {

	private String name;
	private String email;
	private String password;
	private Remidne remidne;
	private int id;

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public User(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
	}

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Remidne getRemidne() {
		return remidne;
	}

	public void setRemidne(Remidne remidne) {
		this.remidne = remidne;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}

}

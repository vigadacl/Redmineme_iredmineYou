package com.modSys.model;

import java.util.LinkedList;
import java.util.List;

public class Remidne {

	private String name;
	private String start;
	private String end;
	private String delay;
	private List<User> users = new LinkedList<User>();
	private int id;
	
	public Remidne(String name,String start, String end,String delay) {
		this.name= name;
		this.start = start;
		this.end = end;
		this.delay = delay;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getDelay() {
		return delay;
	}

	public void setDelay(String delay) {
		this.delay = delay;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
}


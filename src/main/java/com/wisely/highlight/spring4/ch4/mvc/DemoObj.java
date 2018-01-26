package com.wisely.highlight.spring4.ch4.mvc;
public class DemoObj {
	
	private Long id;
	private String name;
	
	public DemoObj() {
		super();
	}
	
	public DemoObj(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}

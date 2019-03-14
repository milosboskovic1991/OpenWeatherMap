package com.example.demo.entity;

public class Clouds {

	private Long all;

	public Clouds() {
		super();
	}

	public Clouds(Long all) {
		super();
		this.all = all;
	}

	public Long getAll() {
		return all;
	}

	public void setAll(Long all) {
		this.all = all;
	}

	@Override
	public String toString() {
		return "Clouds [all=" + all + "]";
	}
	
}

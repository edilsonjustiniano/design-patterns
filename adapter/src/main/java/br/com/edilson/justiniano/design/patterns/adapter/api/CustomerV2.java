package br.com.edilson.justiniano.design.patterns.adapter.api;

import java.util.UUID;

public class CustomerV2 {

	private UUID id;
	private String name;
	private int age;

	public CustomerV2(UUID id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
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

	@Override
	public String toString() {
		return "CustomerV2 [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}

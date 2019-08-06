package br.com.spc;

import br.com.spc.Main.Genre;

public class Person{
	String name;
	Genre genre;
	float weight;
	float height;
	int age;
	
	public Person(String name, Genre genre, float weight, float height, int age) {
		super();
		this.name = name;
		this.genre = genre;
		this.weight = weight;
		this.height = height;
		this.age = age;
	}
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
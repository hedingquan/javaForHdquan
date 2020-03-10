package com.hdquan.pojo;

public class PeopleFactory {
	public People createPeople(String witch){
		switch (witch) {
		case "A":
			return new A();
		case "B":
			return new B();
		default:
			return null;
		}
	}
	public People createPeople(){
	return new A();
	}
}

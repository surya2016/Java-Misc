package example.java8.model;

import java.util.ArrayList;
import java.util.List;

public class Foo {

	private String name;
	
	public List<Bar> bars = new ArrayList<Bar>();
	
	public Foo(String name)
	{
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

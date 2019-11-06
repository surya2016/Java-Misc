package example.java8;

public class Person {
	
	
	private String firstname;
	private String lastname;
	private int age;
	private String hobby;
	
	
	public Person(String first, String last, int age, String hobby)
	{
		this.firstname = first;
		this.lastname = last;
		this.age = age;
		this.hobby = hobby;
	}
	
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Person : [firstname= "+firstname+", lastname = "+lastname+ ", age = "+age+ "]";
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	

}

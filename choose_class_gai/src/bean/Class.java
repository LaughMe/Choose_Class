package bean;

public class Class {
	private String number;
	private String name;
	private int people;
	private String teacher;
	private int nowpeople;
	
	public Class() {
		// TODO Auto-generated constructor stub
	}
	public Class( String number,	String name,int people,	 String teacher,int nowpeople) 
	{
	    this.number=  number;
		this.name= name;
		this.people= people;
		this.teacher= teacher;
		this.nowpeople=nowpeople;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getNowpeople() {
		return nowpeople;
	}
	public void setNowpeople(int nowpeople) {
		this.nowpeople = nowpeople;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	

}

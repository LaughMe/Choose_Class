package bean;

public class Teacher {
	private String number;
	private String name;
	private String sex;
	private String college ;
	private String place;
	
	public Teacher() {
		// TODO Auto-generated constructor stub
	}
	public Teacher( String number,	String name,String sex,	 String college,String place) 
	{
	this.number=  number;
		this.name= name;
		this.sex= sex;
		this.college= college;
		this.place= place;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}

}

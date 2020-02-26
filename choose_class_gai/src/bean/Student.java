package bean;

public class Student {
	private String number;
	private String name;
	private String sex;
	private String studentclass;
	private String major;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student( String number,	String name,String sex,	 String studentclass,String major) 
	{
	this.number=  number;
		this.name= name;
		this.sex= sex;
		this.studentclass= studentclass;
		this.major= major;
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
	public String getStudentclass() {
		return studentclass;
	}
	public void setStudentclass(String studentclass) {
		this.studentclass = studentclass;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}

}

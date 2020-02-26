package dao;
import bean.*;
import bean.Class;
import util.DButil;
import java.sql.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DButil;

public class UserDao {
	DButil DB =new DButil();
	  private static UserDao userDao =new UserDao();

	  public static UserDao getUserDao()
	  {
		return userDao;
		  
	  }
	 
	  public int  checkUsers(String  username  ,String password) {
			DButil DB = new DButil();
			String sql="select username,password ,power from account where username=? and password=?";
			//String sql = "select username,password,jurisdiction from account where username='"+username+"' and password='"+password+"'";
			Connection conn = null;
			PreparedStatement ps = null;
			int  flag = -1;
				try {
				conn = DB.getConn();
				ps = conn.prepareStatement(sql);
				ps.setString(1, username);
				ps.setString(2, password);
				//ps.setInt(3, jurisdiction);
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
				
					flag=rs.getInt("power");
				}
				
			} catch (Exception e) {
				
				flag=-1;
				e.printStackTrace();
			} finally {
				DB.close(conn);
				DB.close(ps);
			}
			return flag;
		}
	  
	  public String  find_name(String  username) {
			DButil DB = new DButil();
			String sql="select realname from account where username=?";
			Connection conn = null;
			PreparedStatement ps = null;
			String flag=null;
				try {
				conn = DB.getConn();
				ps = conn.prepareStatement(sql);
				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
				
					flag=rs.getString("realname");
				}
				
			} catch (Exception e) {
				
				flag=null;
				e.printStackTrace();
			} finally {
				DB.close(conn);
				DB.close(ps);
			}
			return flag;
		}
	  
	  public int  get_nowpeople(String name) {
			DButil DB = new DButil();
			String sql="select nowpeople from class where name=?";
			Connection conn = null;
			PreparedStatement ps = null;
			int  flag =-1;
				try {
				conn = DB.getConn();
				ps = conn.prepareStatement(sql);
				ps.setString(1, name);
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
				
					flag=rs.getInt("nowpeople");
				}
				
			} catch (Exception e) {
				
				flag=-1;
				e.printStackTrace();
			} finally {
				DB.close(conn);
				DB.close(ps);
			}
			return flag;
		}
	  
	  public void  change_people(int nowpeople,String name) {
			DButil DB = new DButil();
			String sql="update class set nowpeople='" + nowpeople+ "' where name='"+name+"'";
			int a=0;
			Connection conn = null;
			Statement state = null;
				try {
					conn = DB.getConn();
					state = conn.createStatement();
					a = state.executeUpdate(sql);
				
			} catch (Exception e) {
				
				
				e.printStackTrace();
			} finally {
				DB.close(conn);
				
			}
	  }
	  
	  
	  
	  public int  checkusername(String  username) {
			DButil DB = new DButil();
			String sql="select * from account where username=?";
			//String sql = "select username,password,jurisdiction from account where username='"+username+"' and password='"+password+"'";
			Connection conn = null;
			PreparedStatement ps = null;
			int  flag = 0;
				try {
				conn = DB.getConn();
				ps = conn.prepareStatement(sql);
				ps.setString(1, username);
				//ps.setInt(3, jurisdiction);
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
				
					flag=1;
				}
				
			} catch (Exception e) {
				
				flag=0;
				e.printStackTrace();
			} finally {
				DB.close(conn);
				DB.close(ps);
			}
			return flag;
		}

	  
	  
	  public boolean  addClass(Class x) {
		  DButil DB = new DButil();
			String sql = "insert into class(number,name,people, teacher,nowpeople) values(?,?,?,?,?)";
			Connection conn = null;
			PreparedStatement ps = null;
			boolean flag = false;
			int a = 0;

			try {
				conn = DB.getConn();
				ps = conn.prepareStatement(sql);
				ps.setString(1, x.getNumber());
				ps.setString(2, x.getName());
				ps.setInt(3, x.getPeople());
				ps.setString(4, x.getTeacher());
				ps.setInt(5, x.getNowpeople());
			
				a = ps.executeUpdate();
				
				if (a != 0) {
					flag = true;
				}
			} catch (Exception e) {
				System.out.println( "添加失败");
				flag=false;
				e.printStackTrace();
			} finally {
				DB.close(conn);
				DB.close(ps);
			}
			return flag;
		}
	  
	  
	  public boolean  addrecrod(String studentname,String classname) {
		  DButil DB = new DButil();
			String sql = "insert into record(studentname,classname) values(?,?)";
			Connection conn = null;
			PreparedStatement ps = null;
			boolean flag = false;
			int a = 0;
			try {
				conn = DB.getConn();
				ps = conn.prepareStatement(sql);
				ps.setString(1, studentname);
				ps.setString(2, classname);			
				a = ps.executeUpdate();
				
				if (a != 0) {
					flag = true;
				}
			} catch (Exception e) {
				System.out.println( "添加失败");
				flag=false;
				e.printStackTrace();
			} finally {
				DB.close(conn);
				DB.close(ps);
			}
			return flag;
		}
	  public boolean  removerecrod(String studentname,String classname) {
		  DButil DB = new DButil();
			Connection conn = null;
			Statement state = null;
			String sql = "";
			boolean flag = false;
			try {
				conn = DB.getConn();
				sql = "delete from record where studentname ='" + studentname + "' and classname='"+classname+"'";
				state = conn.createStatement();
				int a = 0;
				a = state.executeUpdate(sql);
				if (a != 0) {
					flag = true;
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				DB.close(conn);
				DB.close(state);
			}
			
			return flag;
		}

	 
	  
	  public int  getrecord(String  studentname, String classname) {
			DButil DB = new DButil();
			String sql="select id from record where studentname=? and classname=?";
         	Connection conn = null;
			PreparedStatement ps = null;
			int  flag = -1;
				try {
				conn = DB.getConn();
				ps = conn.prepareStatement(sql);
				ps.setString(1, studentname);
				ps.setString(2, classname);
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
				
					flag=rs.getInt("id");
				}
				
			} catch (Exception e) {
				
				flag=-2;
				e.printStackTrace();
			} finally {
				DB.close(conn);
				DB.close(ps);
			}
				System.out.println("flag="+flag);
			return flag;
		}

	public boolean addTeacher(Teacher teacher) {
		DButil DB = new DButil();
		String sql = "insert into teacher(number,name,sex,college,place) values(?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		boolean flag = false;
		int a = 0;

		try {
			conn = DB.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, teacher.getNumber());
			ps.setString(2, teacher.getName());
			ps.setString(3, teacher.getSex());
			ps.setString(4, teacher.getCollege());
			ps.setString(5, teacher.getPlace());
			a = ps.executeUpdate();
			
			if (a != 0) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println( "添加失败");
			flag=false;
			e.printStackTrace();
		} finally {
			DB.close(conn);
			DB.close(ps);
		}
		return flag;
	}
	public boolean addStudent(Student student) {
		DButil DB = new DButil();
		String sql = "insert into student(number,name,sex,class,major) values(?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		boolean flag = false;
		int a = 0;

		try {
			conn = DB.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, student.getNumber());
			ps.setString(2, student.getName());
			ps.setString(3, student.getSex());
			ps.setString(4, student.getStudentclass());
			ps.setString(5, student.getMajor());
			a = ps.executeUpdate();
			
			if (a != 0) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println( "添加失败");
			flag=false;
			e.printStackTrace();
		} finally {
			DB.close(conn);
			DB.close(ps);
		}
		return flag;
	}

	


	
	public boolean deleteUser(String name) {
		DButil DB = new DButil();
		Connection conn = null;
		Statement state = null;
		String sql = "";
		boolean flag = false;
		try {
			conn = DB.getConn();
			sql = "delete from middle_text where name ='" + name + "'";
			state = conn.createStatement();
			int a = 0;
			a = state.executeUpdate(sql);
			if (a != 0) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DB.close(conn);
			DB.close(state);
		}
		
		return flag;
	}
	
	
	
	
	

	

	
	
}
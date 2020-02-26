package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import bean.Teacher;
import dao.UserDao;
import util.DButil;

/**
 * Servlet implementation class Update_student_information
 */
@WebServlet("/Update_student_information")
public class Update_student_information extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_student_information() {
        super();
        // TODO Auto-generated constructor stub
    }

  
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		// TODO Auto-generated method stub
   		request.setCharacterEncoding("utf-8");
   		String  studentname = null;
   		Student student = new Student();
   		UserDao x=new UserDao();
   		HttpSession session =request.getSession(false);
   		String username=(String)session.getAttribute("name");
   		if(session!=null) {
   		
   		studentname=x.find_name(username);
   		
   		
   	
   		}
   		DButil DB1 = new DButil();
   		Connection conn1= null;
   		PreparedStatement ps1 = null;
           String sql1="select number,name,sex,class,major from student where name=?";
   		try {
   			conn1 = DB1.getConn();
   			ps1 = conn1.prepareStatement(sql1);
   			ps1.setString(1, studentname);
   			ResultSet rs1 = ps1.executeQuery();
   			
   			if(rs1.next())
   			{
   			student.setNumber(rs1.getString("number"));
   			student.setName(rs1.getString("name"));
   			student.setSex(rs1.getString("sex"));
   			student.setStudentclass(rs1.getString("class"));
   			student.setMajor(rs1.getString("major"));
   			
   			
   		}
   		}
   		catch (Exception e) {
   			
   			
   			e.printStackTrace();
   		} finally {
   			DB1.close(conn1);
   			DB1.close(ps1);
   		}
   		
   		
   		
   		
   		request.setAttribute("student", student);

   		//这里是转发，从Servlet跳转到showinfo.jsp页面，并且带上request和response对象中原有的参数
   		  response.setContentType("text/html;charset=utf-8");
   		request.getRequestDispatcher("/update_student_information.jsp").forward(request, response);
   		
   	}
       
       


   	/**
   	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   	 */
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		
   		doPost(request, response);
   	}

}

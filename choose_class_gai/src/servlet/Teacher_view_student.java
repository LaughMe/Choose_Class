package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Class;
import bean.Student;
import util.DButil;

/**
 * Servlet implementation class Teacher_view_student
 */
@WebServlet("/Teacher_view_student")
public class Teacher_view_student extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teacher_view_student() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
    	String name=request.getParameter("class_name");
    	System.out.println(name);
    	DButil DB = new DButil();
		String sql="select studentname from record where classname=?";
		Connection conn = null;
		 List<Student> list =new ArrayList<Student>();
		PreparedStatement ps = null;
		int i=0;
			try {
			conn = DB.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			  while(rs.next())
	            {
	                String name1=rs.getString("studentname");
	               String number=null;
	              String sex=null;
	           String studentclass=null;
	            String major=null;
	              
	                
	               
	               Student tl=new Student( number,name1,sex,studentclass,major);
	                list.add(tl);
	            }
			
			
		} catch (Exception e) {
			
			
			e.printStackTrace();
		} finally {
			DB.close(conn);
			DB.close(ps);
		}
			
			request.setAttribute("list", list);

			//这里是转发，从Servlet跳转到showinfo.jsp页面，并且带上request和response对象中原有的参数
			  response.setContentType("text/html;charset=utf-8");
				request.getRequestDispatcher("/show_student.jsp").forward(request, response);
			
		}
		
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

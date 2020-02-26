package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Class;
import bean.Teacher;
import dao.UserDao;
import util.DButil;

/**
 * Servlet implementation class Teacher_most_information
 */
@WebServlet("/Teacher_most_information")
public class Teacher_most_information extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teacher_most_information() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
    	String name=request.getParameter("teacher_name");
    	System.out.println(name);
    	DButil DB = new DButil();
		String sql="select * from teacher where name=?";
		Connection conn = null;
		Teacher teacher_info=new Teacher();
		PreparedStatement ps = null;
			try {
			conn = DB.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
			
			teacher_info.setNumber(rs.getString("number"));
			teacher_info.setName(rs.getString("name"));
			teacher_info.setSex(rs.getString("sex"));
			teacher_info.setCollege(rs.getString("college"));
			teacher_info.setPlace(rs.getString("place"));
			
			}
			
			
		} catch (Exception e) {
			
			
			e.printStackTrace();
		} finally {
			DB.close(conn);
			DB.close(ps);
		}
			
			request.setAttribute("teacher_info", teacher_info);

			//这里是转发，从Servlet跳转到showinfo.jsp页面，并且带上request和response对象中原有的参数
			  response.setContentType("text/html;charset=utf-8");
			request.getRequestDispatcher("/show_teacher_most_information.jsp").forward(request, response);
			
		}
		
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

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
import javax.servlet.http.HttpSession;

import bean.*;
import bean.Class;
import dao.UserDao;
import util.DButil;

/**
 * Servlet implementation class Addclass
 */
@WebServlet("/Addclass")
public class Addclass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addclass() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	int s=0;
    	request.setCharacterEncoding("utf-8");
    	String number=request.getParameter("number");
    	String name=request.getParameter("name");
    	int people=Integer.parseInt(request.getParameter("people")); 
    	HttpSession session =request.getSession(false);
		String username=(String)session.getAttribute("name");
		String teacher = null;
		int nowpeople=0;
		if(session!=null) {
		
		//System.out.println(username);
		
		
		DButil DB = new DButil();
		String sql="select realname from account where username=?";
		Connection conn = null;
		PreparedStatement ps = null;
			try {
			conn = DB.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
			
			teacher	=rs.getString("realname");
			
			}
			
			
		} catch (Exception e) {
			
			
			e.printStackTrace();
		} finally {
			DB.close(conn);
			DB.close(ps);
		}
		}
		Class x=new Class();
		x.setName(name);
		x.setNumber(number);
		x.setPeople(people);
		x.setTeacher(teacher);
		x.setNowpeople(nowpeople);
		//UserDao userDao=UserDao.getUserDao();
		UserDao userDao=new UserDao();
		if(userDao.addClass(x))
		{
			
			//request.setAttribute("message", "添加成功");
			  response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
              //out.print("<script language='javascript'>alert('添加成功');window.location.href='main_menu.jsp';</script>");
			out.print("<script language='javascript'>alert('添加成功');window.location.href='addclass.jsp';</script>");
			}
			
		else 
		{
			
			//request.setAttribute("message", "添加成功");
			  response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
            //out.print("<script language='javascript'>alert('添加成功');window.location.href='main_menu.jsp';</script>");
			out.print("<script language='javascript'>alert('添加失败');window.location.href='addclass.jsp';</script>");
			
			
			
			}
	
	
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

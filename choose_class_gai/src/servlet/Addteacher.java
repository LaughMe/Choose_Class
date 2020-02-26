package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.*;
import dao.UserDao;

/**
 * Servlet implementation class Addteacher
 */
@WebServlet("/Addteacher")
public class Addteacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addteacher() {
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
    	String sex=request.getParameter("sex");
    	String name=request.getParameter("name");
    	String college=request.getParameter("college");
    	String place=request.getParameter("place");
		Teacher teacher=new Teacher();
		teacher.setName(name);
		teacher.setNumber(number);
		teacher.setSex(sex);
		teacher.setCollege(college);
		teacher.setPlace(place);
		
		//UserDao userDao=UserDao.getUserDao();
		UserDao userDao=new UserDao();
		if(userDao.addTeacher(teacher))
		{
			
			//request.setAttribute("message", "添加成功");
			  response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
              //out.print("<script language='javascript'>alert('添加成功');window.location.href='main_menu.jsp';</script>");
			out.print("<script language='javascript'>alert('添加成功');window.location.href='addteacher.jsp';</script>");
			}
			
		else 
		{
			
			//request.setAttribute("message", "添加成功");
			  response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
            //out.print("<script language='javascript'>alert('添加成功');window.location.href='main_menu.jsp';</script>");
			out.print("<script language='javascript'>alert('添加失败');window.location.href='addteacher.jsp';</script>");
			
			
			
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

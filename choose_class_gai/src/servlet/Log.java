package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Log")
public class Log extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		UserDao x=new UserDao();
	int  flag=x.checkUsers(name, password);

		if(flag==1){
			System.out.println("ture");
			HttpSession session=request.getSession(true);
			session.setAttribute("name", name);
			session.setAttribute("password", password);
			response.sendRedirect("admin_main_menu.jsp");
		}
		else if(flag==-1){
			System.out.println("false");
			HttpSession session=request.getSession();
			session.setAttribute("name", name);
			session.setAttribute("password", password);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
		out.print("<script language='javascript'>alert('登录信息存在错误');window.location.href='log.jsp';</script>");
		}
		else if(flag==2)
		{
			System.out.println("ture");
			HttpSession session=request.getSession(true);
			session.setAttribute("name", name);
			session.setAttribute("password", password);
			response.sendRedirect("teacher_main_menu.jsp");
		}
		else if(flag==3)
		{
			System.out.println("ture");
			HttpSession session=request.getSession();
			session.setAttribute("name", name);
			session.setAttribute("password", password);
			response.sendRedirect("student_main_menu.jsp");
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

}

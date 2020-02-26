package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * Servlet implementation class Deleterecord
 */
@WebServlet("/Deleterecord")
public class Deleterecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deleterecord() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String studentname=request.getParameter("studentname");
		String classname=request.getParameter("classname");
		UserDao x=new UserDao();
		int ss;
	    ss =x.getrecord(studentname, classname);
		if(ss>=0){
			System.out.println("存在可删除记录");
			
			response.getWriter().print(ss);
			x.removerecrod(studentname, classname);
			
		}
		else if(ss<0){
			System.out.println("不存在可删除记录");
			
			response.getWriter().print(ss);
			
		}
	
	}


  	/**
  	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  	 */
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		
  		doPost(request, response);
  	}

}

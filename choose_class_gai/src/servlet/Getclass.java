package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;

/**
 * Servlet implementation class Getclass
 */
@WebServlet("/Getclass")
public class Getclass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Getclass() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		UserDao x=new UserDao();
		int nowpeople;
		HttpSession session =request.getSession(false);
   		String username=(String)session.getAttribute("name");
		String realname=null;
	    realname =x.find_name(username);
		nowpeople=x.get_nowpeople(name);
		nowpeople++;
		x.change_people(nowpeople, name);
	if(realname!=null){
			System.out.println("addnowpeople_true");
			
			response.getWriter().print(realname);
			
		}
		else if(realname==null){
			System.out.println("addnowpeople_false");
			
			response.getWriter().print(realname);
			
		}
	
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

}

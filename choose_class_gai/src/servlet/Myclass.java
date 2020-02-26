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
import javax.servlet.http.HttpSession;

import bean.Class;
import bean.Student;
import dao.UserDao;
import util.DButil;

/**
 * Servlet implementation class Myclass
 */
@WebServlet("/Myclass")
public class Myclass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Myclass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		// TODO Auto-generated method stub
   		request.setCharacterEncoding("utf-8");
   		String  studentname = null;
   	 List<String> list =new ArrayList<String>();
   	HttpSession session =request.getSession(false);
	String username=(String)session.getAttribute("name");
UserDao x=new UserDao();
	if(session!=null) {
   		
   		studentname=x.find_name(username);
   		
   		
   	
   		}
	  DButil DB = new DButil();
		Connection conn= null;
		PreparedStatement ps = null;
		conn = DB.getConn();
		
		
	
	 String sql="select classname from record where studentname=?";
	  try {
		  ps = conn.prepareStatement(sql);
		  ps.setString(1, studentname);
			ResultSet rs = ps.executeQuery();    
           while(rs.next())
           {
               String classname=rs.getString("classname");
              
             
               list.add(classname);
            
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
	request.getRequestDispatcher("/myclass.jsp").forward(request, response);
   		
   	}
       
       


   	/**
   	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   	 */
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		
   		doPost(request, response);
   	}

}

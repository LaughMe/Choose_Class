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
import dao.UserDao;
import util.DButil;

/**
 * Servlet implementation class View_student_info
 */
@WebServlet("/View_student_info")
public class View_student_info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View_student_info() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		UserDao x=new UserDao();
		HttpSession session =request.getSession(false);
   		String username=(String)session.getAttribute("name");
		String realname=null;
	    realname =x.find_name(username);
		 List<Class> list =new ArrayList<Class>();
		  DButil DB = new DButil();
			Connection conn= null;
			PreparedStatement ps = null;
			conn = DB.getConn();
			
			
		
		 String sql="select * from class where teacher=?";
		
		  try {
			  ps = conn.prepareStatement(sql);
				ps.setString(1, realname);
				ResultSet rs = ps.executeQuery();    
	            while(rs.next())
	            {
	                
	                String name=rs.getString("name");
	                int people=rs.getInt("people");
	                String number=rs.getString("number");
	                String teacher=rs.getString("teacher");
	                int nowpeople=rs.getInt("nowpeople");
	              
	                
	               
	               Class tl=new Class( number,name,people,teacher,nowpeople);
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
		request.getRequestDispatcher("/view_own_classs.jsp").forward(request, response);
		
	}
    
    


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

}

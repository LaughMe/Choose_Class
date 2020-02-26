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
import util.DButil;

/**
 * Servlet implementation class Choose_class
 */
@WebServlet("/Choose_class")
public class Choose_class extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Choose_class() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		 List<Class> list =new ArrayList<Class>();
		  DButil DB = new DButil();
			Connection conn= null;
			PreparedStatement ps = null;
			conn = DB.getConn();
		 String sql="select * from class";
		
		  try {
			  ps = conn.prepareStatement(sql);
		        
				ResultSet rs = ps.executeQuery();    
	            while(rs.next())
	            {
	                
	                String name=rs.getString("name");
	                int people=rs.getInt("people");
	                String number=rs.getString("number");
	                String teacher=rs.getString("teacher");
	                int nowpeople=rs.getInt("nowpeople");
	               if(nowpeople<people)
	               {Class tl=new Class( number,name,people,teacher,nowpeople);
	                list.add(tl);
	                
	               }
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
		request.getRequestDispatcher("/choose_class.jsp").forward(request, response);
		
	}
    
    


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

}

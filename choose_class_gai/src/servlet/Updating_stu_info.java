package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import util.DButil;

/**
 * Servlet implementation class Updating_stu_info
 */
@WebServlet("/Updating_stu_info")
public class Updating_stu_info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updating_stu_info() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String sex=request.getParameter("sex");
		String number=request.getParameter("number");
		String name=request.getParameter("name");
		String room=request.getParameter("room");
		String major=request.getParameter("major");
		DButil DB = new DButil();
		Connection conn = null;
		Statement state = null;
		int a;
		PreparedStatement ps = null;
		
		String sql="update student set sex='" + sex + "',number='"+number+"' ,class='"+room+"',major='"+major+"'  where name='"+name+"'  ";
		
		try {
			
			conn = DB.getConn();
			state = conn.createStatement();
			a = state.executeUpdate(sql);
			if(a==0)
			{
				
				 response.setContentType("text/html;charset=utf-8");
					PrintWriter out = response.getWriter();
				out.print("<script language='javascript'>alert('更改失败');window.location.href='update_student_information.jsp';</script>");
			}
			else if(a!=0)
			
			
			{
				
				 response.setContentType("text/html;charset=utf-8");
					PrintWriter out = response.getWriter();
				out.print("<script language='javascript'>alert('更改成功');window.location.href='student_main_menu.jsp';</script>");
			
				
			}
			
			
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	
	}
	
			  //response.setContentType("text/html;charset=utf-8");
			//request.getRequestDispatcher("/updating.jsp").forward(request, response);
		

					

		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

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

import bean.Teacher;
import util.DButil;

/**
 * Servlet implementation class Updating_te_info
 */
@WebServlet("/Updating_te_info")
public class Updating_te_info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updating_te_info() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String sex=request.getParameter("sex");
		String number=request.getParameter("number");
		String name=request.getParameter("name");
		String college=request.getParameter("college");
		String place=request.getParameter("place");
		DButil DB = new DButil();
		Connection conn = null;
		Statement state = null;
		int a;
		PreparedStatement ps = null;
		
		String sql="update teacher set sex='" + sex + "',number='"+number+"' ,college='"+college+"',place='"+place+"'  where name='"+name+"'  ";
		
		try {
			
			conn = DB.getConn();
			state = conn.createStatement();
			a = state.executeUpdate(sql);
			if(a==0)
			{
				
				 response.setContentType("text/html;charset=utf-8");
					PrintWriter out = response.getWriter();
				out.print("<script language='javascript'>alert('更改失败');window.location.href='update_teacher_information.jsp';</script>");
			}
			else if(a!=0)
			
			
			{
				
				 response.setContentType("text/html;charset=utf-8");
					PrintWriter out = response.getWriter();
				out.print("<script language='javascript'>alert('更改成功');window.location.href='teacher_main_menu.jsp';</script>");
			
				
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

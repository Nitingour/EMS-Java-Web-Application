package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.EmpBean;
import dao.MyDAO;

/**
 * Servlet implementation class ViewEmp
 */
@WebServlet("/ViewEmp")
public class ViewEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewEmp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		
		      MyDAO m=new MyDAO();
		      ArrayList<EmpBean> list= m.viewEmp();

		      RequestDispatcher rd=request.getRequestDispatcher("View.jsp");
		     request.setAttribute("LIST", list);
		      rd.forward(request, response);
		      
		      
		
		/*	PrintWriter out=response.getWriter();
		 HttpSession session=request.getSession();
			String uid=(String)session.getAttribute("uid");
    	  out.println("<center><font color=red><h1>Welcome,"+uid+"</h1></font><hr/>");
*/
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

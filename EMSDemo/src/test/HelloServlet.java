package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MyDAO;

import java.sql.*;
/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          PrintWriter out=response.getWriter();
		    out.println("<font color=red><h1>Hello Servlet</h1></font>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  PrintWriter out=response.getWriter();
			
		String u=request.getParameter("uid");
		String p=request.getParameter("pass");
	     MyDAO m=new MyDAO();
	   int x=m.loginCheck(u, p);
		if(x==1)
		{
		   //Session code here
			HttpSession session=request.getSession();
			session.setAttribute("uid",u);
			response.sendRedirect("AdminHome.jsp");
			
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg","Login fail try again...");
			rd.forward(request,response);
			  //response.sendRedirect("index.jsp");
		}
		
	}

}

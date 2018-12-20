package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.EmpBean;
import dao.MyDAO;


/**
 * Servlet implementation class EmpInsert
 */
@WebServlet("/EmpInsert")
public class EmpInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
		String eid=request.getParameter("eid");
		String name=request.getParameter("name");
		String sal=request.getParameter("salary");
		String add=request.getParameter("address");
		
		EmpBean e=new EmpBean();
		e.setEid(Integer.parseInt(eid));
		e.setEname(name);
		e.setSalary(Double.parseDouble(sal));
		e.setAddress(add);
		
		
		    MyDAO m=new MyDAO();
			int x= m.insertEmp(e);
	         if(x==1)
	         {
	        	 RequestDispatcher rd=request.getRequestDispatcher("Emp.jsp");
                request.setAttribute("msg", "Data Inserted Successfully...");
               rd.forward(request, response);
	         }// out.println("<h1>Data Inserted</h1>");
			
				
		
	
	}

}

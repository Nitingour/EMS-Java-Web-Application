package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.EmpBean;
import dao.MyDAO;

/**
 * Servlet implementation class EmpUpdate
 */
@WebServlet("/EmpUpdate")
public class EmpUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
			int x= m.updateEmp(e);
	         if(x==1)
	         {
	        	 RequestDispatcher rd=request.getRequestDispatcher("View.jsp");
	        	 ArrayList<EmpBean> list= m.viewEmp();
			     request.setAttribute("LIST", list);
	        	 request.setAttribute("msg", "Data Updated Successfully...");
               rd.forward(request, response);
	         }// out.println("<h1>Data Inserted</h1>");
			
			
	}

}

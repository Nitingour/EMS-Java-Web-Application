 
 
 
 <%@page import="java.util.ArrayList,beans.EmpBean" %>
 <%@include file="Header.jsp" %>
 
 	  <%
 	  String uid=(String)session.getAttribute("uid");
 	 if(uid==null)
		 response.sendRedirect("index.jsp");
	   %>
	<center><font color=red><h1>Welcome,<%=uid%></h1></font><hr/>
	
	 ${msg}
	</center>
 <div class="container">
  
 <table class="table table-hover">
 <tr><th>EID</th><th>Name</th><th>Salary</th><th>Address</th><th></th></tr>
 <% 
 ArrayList<EmpBean> list=(ArrayList<EmpBean>)request.getAttribute("LIST");
 
 %>
 
 <%
   for(EmpBean ee:list)
   {
	  %>
   	 <tr>
   	<td> <%=ee.getEid()%> </td>
	<td> <%=ee.getEname()%> </td>
	 <td><%=ee.getSalary()%> </td>
	 <td><%=ee.getAddress()%> </td>

	  <td> <a href="EmpDeleteServlet?empid=<%=ee.getEid()%>" class="glyphicon glyphicon-remove-sign"  onClick="return confirm('Do you really want to delete this record?')"></a> </td>
	 <tr/>
	 <%
	 }
  %>
  </table></div>
  
  
  
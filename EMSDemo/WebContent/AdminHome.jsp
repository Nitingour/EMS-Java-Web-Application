<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
   <%@include file="Header.jsp" %>
   
   <% 
	  	String uid=(String)session.getAttribute("uid");
	 if(uid==null)
		 response.sendRedirect("index.jsp");
   %>
	<center><font color=red><h1>Welcome,<%=uid%> at Admin Home</h1></font><hr/>
	</center>
</body>
</html>
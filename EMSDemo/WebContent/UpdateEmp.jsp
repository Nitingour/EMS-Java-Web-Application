<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <%@include file="Header.jsp" %>
   
       <% 
	  	String uid=(String)session.getAttribute("uid");
       if(uid==null)
  		 response.sendRedirect("index.jsp");
	   %>
	<center><font color=red><h1>Welcome,<%=uid%></h1></font><hr/>
	
	</center>
	
<% String m=(String)request.getAttribute("msg"); 
    if(m!=null)
    {
  %>	
	<div class="alert alert-success alert-dismissible">
  <strong><%=m%></strong> 
</div>
<%
}
    %>


	<div class="container">
	<div class="col-sm-3">
 
 <%@page import="beans.EmpBean" %>
 <%
 EmpBean e=(EmpBean)request.getAttribute("emp");
 %>
 
    <form action="./EmpUpdate" method="post">
 
  <div class="form-group">
    <label for="email">EID:</label>
    <input type="text"  value="<%=e.getEid()%>" readonly  class="form-control" name="eid" id="email">
  </div>
 
  <div class="form-group">
    <label for="pwd">Name:</label>
    <input type="text"  value="<%=e.getEname()%>"  class="form-control" id="pwd" name="name" />
  </div>
  <div class="form-group">
    <label for="email">Salary:</label>
    <input type="text" class="form-control"  value="<%=e.getSalary()%>"  name="salary" id="email">
  </div>
 
  <div class="form-group">
    <label for="email">Address:</label>
    <textarea name="address" class="form-control" > <%=e.getAddress()%> </textarea>
  </div>
 
  <button type="submit" class="btn btn-default">Update</button>
</form>
</div>
</div>
	
</body>
</html>
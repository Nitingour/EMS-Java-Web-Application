<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Admin Login </h1>
<hr/>
<pre>
<font color="red">
 <strong> <%
/* String m=(String)request.getAttribute("msg");
if(m!=null)
	out.println(m); */
 %>
 ${msg}
 </strong>
</font>
<form action="HelloServlet"  method="post">

  UID      <input type="text" name="uid" />

  Password <input type="password" name="pass" />

           <input type="submit" value="Login"/>
</form>
</pre>
</center>
</body>
</html>
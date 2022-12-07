<html>
<body>

<%
String username=request.getParameter("username");
String password=request.getParameter("password");

if(username.equals("tom")&& password.equals("tommy")){
	session.setAttribute("username", username);
	RequestDispatcher dispatcher=request.getRequestDispatcher("/loggedIn.jsp");
	dispatcher.forward(request, response);
}
else{
	session.invalidate();
	RequestDispatcher dispatcher=request.getRequestDispatcher("/login.html");
	dispatcher.forward(request, response);
}
%>

</body>
</html>
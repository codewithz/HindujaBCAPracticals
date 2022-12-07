<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	String text=request.getParameter("text");
	int length=text.length();
	
	if(length>=6){
		%>
		<h1><%=text %> length is greater or equal than 6</h1>
		<% 
	}
	else{
		%>
		<h1><%=text %> length is lesser than 6</h1>
		<% 
		
	}

%>

</body>
</html>
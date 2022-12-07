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
	int number=Integer.parseInt(request.getParameter("number"));

	boolean flag = false;
	for (int i = 2; i <= number / 2; ++i) {
	  // condition for nonprime number
	  if (number % i == 0) {
	    flag = true;
	    break;
	  }
	}
	
	if(!flag) {
		%>
		<h1><%= number %> is a Prime Number</h1>
		<% 
	}
	else {
		%>
		
			<h1><%= number %> is NOT a Prime Number</h1>
		<% 
	}
		
%>

</body>
</html>
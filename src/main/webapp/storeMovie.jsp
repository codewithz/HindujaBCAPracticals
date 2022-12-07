<%@ page  language="java"  import="java.sql.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String name=request.getParameter("name");
String actor=request.getParameter("actor");
String actress=request.getParameter("actress");
String director=request.getParameter("director");
String releaseDate=request.getParameter("rDate");
String rPoints=request.getParameter("rPoint");
float ratePoints=Float.parseFloat(rPoints);
try {
Class.forName("com.mysql.cj.jdbc.Driver");
String url="jdbc:mysql://localhost:3306/hindujabca2022";
String username="root";
String password="admin";

Connection con=DriverManager.getConnection(url,username,password);

String query="Insert into movie(name,actor,actress,director,releaseDate,ratePoints) values "
		+ "(?,?,?,?,?,?);";

PreparedStatement pstmt=con.prepareStatement(query);
pstmt.setString(1,name);
pstmt.setString(2,actor);
pstmt.setString(3,actress);
pstmt.setString(4,director);
pstmt.setString(5,releaseDate);
pstmt.setFloat(6, ratePoints);

int rowsInserted=pstmt.executeUpdate();

if(rowsInserted==1) {
	%>
	<h3>Record Inserted Successfully</h3>
	
	<% 
}

				
}
catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
}

%>

</body>
</html>
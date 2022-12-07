

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertMovieServlet
 */
@WebServlet("/InsertMovieServlet")
public class InsertMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMovieServlet() {
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
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		
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
			pw.print("Record Stored Successfully");
		}
		
						
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		

	}

}

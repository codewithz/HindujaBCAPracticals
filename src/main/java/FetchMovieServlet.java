

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FetchMovieServlet
 */
@WebServlet("/FetchMovieServlet")
public class FetchMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/hindujabca2022";
			String username="root";
			String password="admin";
			
			Connection con=DriverManager.getConnection(url,username,password);
			
			String query="Select * from movie where id=?";
			
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1,id);
			
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) {
				pw.println("Name:"+rs.getString("name")+"<br>");
				pw.println("Actor:"+rs.getString("actor")+"<br>");
				pw.println("Actress:"+rs.getString("actress")+"<br>");
				pw.println("Director:"+rs.getString("director")+"<br>");
				pw.println("Release Date:"+rs.getString("releaseDate")+"<br>");
				pw.println("Rating Points:"+rs.getString("ratePoints")+"<br>");
			}
			else {
				pw.print("No record found..");
			}
			
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowAllEmployees
 */
@WebServlet("/ShowAllEmployees")
public class ShowAllEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllEmployees() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		try {
			Connection con=MySQLConnectionITP.getConnection();
			Statement st=con.createStatement();
			String query="select * from emp";
			ResultSet rs=st.executeQuery(query);
			out.print("<head>");
			out.print("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT\" crossorigin=\"anonymous\">");
			out.print("</head>");
			out.print("<a href='/ITPMarchFirstServlet/addemp.html' class='btn btn-primary'>Add Employee</a>"); 
			out.print("<table border='1' class='table'>");
			out.print("<thead class='thead-dark'>");
			out.print("<tr>");
			out.print("<td>Employee No</td>");
			out.print("<td>Employee Name</td>");
			out.print("<td>Employee Salary</td>");
			out.print("</tr>");
			out.print("</thead>");
			while(rs.next())
			{
				out.print("<tr>");
				out.print("<td>"+ rs.getInt(1) +"</td>");
				out.print("<td>"+ rs.getString(2) +"</td>");
				out.print("<td>"+ rs.getInt(3) +"</td>");
				out.print("</tr>");
			}
			out.print("</table>");
		}
		catch(Exception e1) {
			out.print(e1.getMessage());
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

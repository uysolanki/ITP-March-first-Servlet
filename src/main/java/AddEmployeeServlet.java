

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddEmployeeServlet
 */
@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int eno=Integer.parseInt(request.getParameter("t1"));
		String ename=request.getParameter("t2");
		int salary=Integer.parseInt(request.getParameter("t3"));
		
		try {
			Connection con=MySQLConnectionITP.getConnection();
			String query="insert into emp values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, eno);
			ps.setString(2, ename);
			ps.setInt(3, salary);
			
			int rows=ps.executeUpdate();
			if(rows>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("showAllEmployees");
				rd.forward(request, response);
			}
			else
				out.print("Record Not Inserted");
		} catch (Exception e) {
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

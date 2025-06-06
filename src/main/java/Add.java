

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int n1=Integer.parseInt(request.getParameter("t1"));
		int n2=Integer.parseInt(request.getParameter("t2"));
		int sum=n1+n2;
		out.print(sum);
		
		ServletContext context=getServletContext();
		int numL=Integer.parseInt(context.getInitParameter("l"));
		int numM=Integer.parseInt(context.getInitParameter("m"));
		System.out.println(numL);
		System.out.println(numM);
		out.print(numL+"<br>");
		out.print(numM+"<br>");
		
		ServletConfig config=getServletConfig();
		int numX=Integer.parseInt(config.getInitParameter("x"));
		int numY=Integer.parseInt(config.getInitParameter("y"));
		System.out.println(numX);
		System.out.println(numY);
		out.print(numX+"<br>");
		out.print(numY+"<br>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

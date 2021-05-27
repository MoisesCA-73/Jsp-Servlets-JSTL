package pe.unsa.epc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
/**
 * Servlet implementation class MiServlet
 */
@WebServlet("/MiServlet")
public class MiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MiServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String yourName = request.getParameter("yourName");
		
		List<Person> persons = new ArrayList<>();
		Person person = new Person();
		person.setName(yourName);
		person.setEdad(17);
		request.setAttribute("person", person);
		
		persons.add(person);
		
		person.setName("Juancito");
		person.setEdad(19);
		
		persons.add(person);
		
		request.setAttribute("persons", persons);
		
		RequestDispatcher dispatcher =
			request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		/*
		PrintWriter writer = response.getWriter();
		writer.println("<h1>Hello " + name + "</h1>");
		writer.close();
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package presentation;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import business.richiesteEJBLocal;
import data.Contatto;

public class ModificaContattoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	richiesteEJBLocal ejb;
       
    public ModificaContattoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("metodo").equals("direziona")) {
			direziona(request, response);
		}
		else {
			PrintWriter out=response.getWriter();
	        try {
				modifica(request, response);
	        }catch (Exception e) {
	            out = response.getWriter();
	            response.setContentType("text/html");
	            out.println("<h1>" +"Si e' verificato un errore nell'inserimento dati"+ "</h1>");
	            out.println("<a href="+"index.html"+">" +"Home di Daniele Liburdi"+"</a>");
	            e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void direziona(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		session.setAttribute("contatto", ejb.getContattoById(Long.parseLong(request.getParameter("id"))));
		try {request.getRequestDispatcher("modificaContatto.jsp").forward(request, response);} 
		catch (ServletException e) {e.printStackTrace();} 
		catch (IOException e) {e.printStackTrace();}
	}
	
	private void modifica(HttpServletRequest request, HttpServletResponse response) {
		ejb.modificaContatto((Contatto)request.getSession().getAttribute("contatto"),
				request.getParameter("nome"),
				request.getParameter("cognome"),
				request.getParameter("email"),
				request.getParameter("numero1"),
				request.getParameter("numero2"));
		try {response.sendRedirect("index.html");}catch (Exception e) {}
	}

}

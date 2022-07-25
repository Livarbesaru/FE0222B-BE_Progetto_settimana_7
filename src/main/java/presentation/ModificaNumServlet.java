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

/**
 * Servlet implementation class ModificaNumServlet
 */
public class ModificaNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	richiesteEJBLocal ejb;

    public ModificaNumServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("metodo").equals("direziona")) {
			direziona(request, response,request.getParameter("num"));
		}
		else {
			PrintWriter out=response.getWriter();
	        try {
				modifica(request, response);
	        }catch (Exception e) {
	            out = response.getWriter();
	            response.setContentType("text/html");
	            out.println("<h1>" +"Si e' verificato un errore nell'inserimento dati"+ "</h1>");
	            out.println("<a href="+"index.html"+">" +"Home"+"</a>");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void direziona(HttpServletRequest request, HttpServletResponse response,String numero) {
		HttpSession session=request.getSession();
		session.setAttribute("vecchioNumero", numero);
		try {request.getRequestDispatcher("modificaNum.jsp").forward(request, response);} 
		catch (ServletException e) {e.printStackTrace();} 
		catch (IOException e) {e.printStackTrace();}
	}
	
	private void modifica(HttpServletRequest request, HttpServletResponse response) {
		ejb.editNumeroByContatto((String)request.getSession().getAttribute("vecchioNumero"), request.getParameter("numNuovo"));
		try {response.sendRedirect("index.html");}catch (Exception e) {}
	}

}

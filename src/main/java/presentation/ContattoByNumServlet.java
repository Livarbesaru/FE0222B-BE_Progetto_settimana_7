package presentation;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import business.richiesteEJBLocal;
import data.Contatto;

public class ContattoByNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	richiesteEJBLocal ejb;
       
    public ContattoByNumServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getContattiByNum(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void getContattiByNum(HttpServletRequest request, HttpServletResponse response) {
		List<Contatto> con=(List<Contatto>) ejb.getContattoByNumero(request.getParameter("numero"));
		HttpSession session=request.getSession();
		session.setAttribute("contatti", con);
		try {request.getRequestDispatcher("allContatti.jsp").forward(request, response);}
		catch (ServletException e) {e.printStackTrace();}
		catch (IOException e) {e.printStackTrace();}
	}

}

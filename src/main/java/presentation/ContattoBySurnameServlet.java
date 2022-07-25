package presentation;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import business.richiesteEJBLocal;
import data.Contatto;

public class ContattoBySurnameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	richiesteEJBLocal ejb;
       
    public ContattoBySurnameServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getContattiBySurname(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void getContattiBySurname(HttpServletRequest request, HttpServletResponse response) {
		List<Contatto> con=ejb.getContattoBySurname(request.getParameter("cognome").toUpperCase()+"");
		HttpSession session=request.getSession();
		session.setAttribute("contatti", con);
		try {response.sendRedirect("allContatti.jsp");}catch (Exception e) {}
	}

}

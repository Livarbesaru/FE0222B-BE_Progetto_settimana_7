package presentation;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import business.richiesteEJBLocal;


public class EliminaContattoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	richiesteEJBLocal ejb;
       

    public EliminaContattoServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ejb.eliminaContatto(Long.parseLong(request.getParameter("id")));
		try {response.sendRedirect("index.html");}catch (Exception e) {}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

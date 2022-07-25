package presentation;

import java.io.IOException;

import business.richiesteEJBLocal;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AllContattiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	richiesteEJBLocal ejb;
       

    public AllContattiServlet() {
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.setAttribute("contatti", ejb.getAllContatti());
		request.getRequestDispatcher("allContatti.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

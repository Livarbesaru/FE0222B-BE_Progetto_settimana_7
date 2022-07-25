package presentation;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import business.richiesteEJBLocal;

/**
 * Servlet implementation class eliminaNumeroServlet
 */
public class eliminaNumeroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	richiesteEJBLocal ejb;

    public eliminaNumeroServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
        try {
    		ejb.eliminaNumero(Long.parseLong(request.getParameter("id")),
    		Long.parseLong(request.getParameter("idcontatto")));
    		try {response.sendRedirect("index.html");}catch (Exception e) {}
        }catch (Exception e) {
            out = response.getWriter();
            response.setContentType("text/html");
            out.println("<h1>" +"Si e' verificato un errore nell'eliminazione del dato"+ "</h1>");
            out.println("<a href="+"index.html"+">" +"Home"+"</a>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

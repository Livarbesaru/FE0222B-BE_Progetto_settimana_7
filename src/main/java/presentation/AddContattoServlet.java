package presentation;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import business.richiesteEJBLocal;
import data.Contatto;
import data.NumTelefono;

public class AddContattoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	richiesteEJBLocal ejb;
       
    public AddContattoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
        try {
    		formaContatto(request, response);
    		try {response.sendRedirect("index.html");}catch (Exception e) {}
        }catch (Exception e) {
            out = response.getWriter();
            response.setContentType("text/html");
            out.println("<h1>" +"Si e' verificato un errore nell'inserimento dati"+ "</h1>");
            out.println("<a href="+"index.html"+">" +"Home"+"</a>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void formaContatto(HttpServletRequest request, HttpServletResponse response) {
		List<NumTelefono> listTel=new ArrayList<>();
		String nome=request.getParameter("nome").toUpperCase()+"";
		String cognome=request.getParameter("cognome").toUpperCase()+"";
		String email=request.getParameter("email").toUpperCase()+"";
		Contatto con=new Contatto(nome,cognome,email);
		listTel.add(new NumTelefono(request.getParameter("num1"),con));
		if((request.getParameter("num2")+"")!=null && (request.getParameter("num2")+"").replaceAll(" ", "")!="") {
			listTel.add(new NumTelefono(request.getParameter("num2"),con));
		}
		con.setNumTelefoni(listTel);
		ejb.insertContatto(con);
		try {response.sendRedirect("index.html");}catch (Exception e) {}
	}
}

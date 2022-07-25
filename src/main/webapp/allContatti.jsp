<%@page import="data.NumTelefono"%>
<%@page import="data.Contatto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<% 
	List<Contatto> contatti=(List<Contatto>)session.getAttribute("contatti");
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Tutti i contatti</title>
</head>
<body>
	<nav>
		<a href="index.html">Home</a>
		<a href="addContatto.jsp">Inserisci Contatto</a>
		<a href="findBySurname.jsp">Cerca Contatto per cognome</a>
		<a href="findByNumber.jsp">Cerca Contatto per numero</a>
	</nav>
	<table>
		<thead>
			<tr>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Email</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<%if(contatti!=null)
			for(Contatto c:contatti){%>
				<tr>
					<td><%=c.getNome()%></td>
					<td><%=c.getCognome()%></td>
					<td><%=c.getEmail()%></td>
					<td>
						<form method="post" action="ModificaContattoServlet?metodo=direziona&id=<%=c.getId()%>">
							<button type="">
								Modifica contatto
							</button>
						</form>
					</td>
					<td>
						<form method="post" action="EliminaContattoServlet?id=<%=c.getId()%>">
							<button type="submit">
								Elimina
							</button>
						</form>
					</td>
				</tr>
				<%for(NumTelefono n:c.getNumTelefoni()){%>
					<tr>
						<td>Numero <%=(c.getNumTelefoni().indexOf(n)+1)%>: <%=n.getNumTel()%></td>
						<td>
						<form method="post" action="ModificaNumServlet?metodo=direziona&num=<%=n.getNumTel()%>">
							<button type="submit">
								Modifica
							</button>
						</form>
						</td>
						<td>
						<form method="post" 
						action="eliminaNumeroServlet?id=<%=n.getIdTelefono() %>&idcontatto=<%=c.getId()%>">
							<button type="submit">
								Elimina
							</button>
						</form>
						</td>
					</tr>
				<%}%>
			  <%}%>
		</tbody>
	</table>
</body>
</html>
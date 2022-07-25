<%@page import="data.Contatto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	Contatto c=(Contatto)session.getAttribute("contatto");
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Modifica contatto</title>
</head>
<body>
	<nav>
		<a href="index.html">Home</a>
		<a href="AllContattiServlet">Visualizza Tutti i contatti</a>
		<a href="addContatto.jsp">Inserisci Contatto</a>
		<a href="findBySurname.jsp">Cerca Contatto per cognome</a>
		<a href="findByNumber.jsp">Cerca Contatto per numero</a>
	</nav>
	<form method="post" action="ModificaContattoServlet?metodo=modifica">
		<fieldset>
		<label for="nome">Nome</label>
			<input type="text" name="nome" placeholder="<%=c.getNome()%>" value="<%=c.getNome()%>" required>
		
		<label for="cognome">Cognome</label>
			<input type="text" name="cognome" placeholder="<%=c.getCognome()%>" value="<%=c.getCognome()%>" required>
			
		<label for="email">Email</label>
			<input type="text" name="email" placeholder="<%=c.getEmail()%>" value="<%=c.getEmail()%>" required>
		</fieldset>
		<fieldset>
			<label>Numero 1</label>
				<input type="number" name="numero1" <%
				if(c.getNumTelefoni().size()>0){%>
				placeholder="<%=c.getNumTelefoni().get(0).getNumTel()%> (Primo numero obbligatorio)"
				value="<%=c.getNumTelefoni().get(0).getNumTel()%>"
				<%}%>
				 required>
				
			<label>Numero 2</label>
				<input type="number" name="numero2" <% 
				if(c.getNumTelefoni().size()>1){%>
					placeholder="<%=c.getNumTelefoni().get(1).getNumTel()%>"
					value="<%=c.getNumTelefoni().get(1).getNumTel()%>"
				<%}%>>
		</fieldset>
		<fieldset>
			<button type="submit">Modifica</button>
		</fieldset>
	</form>

</body>
</html>
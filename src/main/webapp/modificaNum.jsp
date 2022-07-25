<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    	String vecchioNumero=(String)session.getAttribute("vecchioNumero");
    %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Modifica numero</title>
</head>
<body>
	<nav>
		<a href="index.html">Home</a>
		<a href="AllContattiServlet">Visualizza Tutti i contatti</a>
		<a href="addContatto.jsp">Inserisci Contatto</a>
		<a href="findBySurname.jsp">Cerca Contatto per cognome</a>
		<a href="findByNumber.jsp">Cerca Contatto per numero</a>
	</nav>
<h1>Modifica numero</h1>
<form method="post" action="ModificaNumServlet?metodo=modifica?numVecchio=<%=vecchioNumero%>">
	<h3>Vecchio numero: <%=vecchioNumero%></h3>
	<label for="numNuovo">Nuovo numero</label>
	<input type="number" name="numNuovo"
	value="<%=vecchioNumero%>"
	placeholder="<%=vecchioNumero%>"
	 required>
	<button type="submit">Modifica</button>
</form>
</body>
</html>
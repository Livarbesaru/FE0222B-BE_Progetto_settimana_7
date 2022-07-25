<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Trova contatto</title>
</head>
<body>
	<nav>
		<a href="index.html">Home</a>
		<a href="AllContattiServlet">Visualizza Tutti i contatti</a>
		<a href="addContatto.jsp">Inserisci Contatto</a>
		<a href="findByNumber.jsp">Cerca Contatto per numero</a>
	</nav>
	<form action="ContattoBySurnameServlet" method="post">
		<h3>Inserisci il cognome del contatto che si vuole cercare</h3>
		<label for="cognome">Cognome</label>
		<input type="text" name="cognome">
		<button type="submit">Cerca</button>
	</form>
</body>
</html>
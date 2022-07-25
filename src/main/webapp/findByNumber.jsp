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
		<a href="findBySurname.jsp">Cerca Contatto per cognome</a>
	</nav>
	<form action="ContattoByNumServlet" method="post">
		<h3>Inserisci il numero del contatto che si vuole cercare</h3>
		<label for="numero">Numero</label>
		<input type="number" name="numero">
		<button type="submit">Cerca</button>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Aggiungi contatto</title>
</head>
<body>
	<nav>
		<a href="index.html">Home</a>
		<a href="AllContattiServlet">Visualizza Tutti i contatti</a>
		<a href="findBySurname.jsp">Cerca Contatto per cognome</a>
		<a href="findByNumber.jsp">Cerca Contatto per numero</a>
	</nav>
	<form action="AddContattoServlet" method="post">
		<fieldset>
			<h3>Dati dell'utente</h3>
			<div>
				<label for="nome">Nome</label>
				<input type="text" name="nome" placeholder="nome" required>
			</div>
			<div>
				<label for="cognome">Cognome</label>
				<input type="text" name="cognome" placeholder="cognome" required>
			</div>
			<div>
				<label for="email">Email</label>
				<input type="email" name="email" placeholder="esempio@gmail.com" required>
			</div>
		</fieldset>
		<fieldset>
			<div>
				<h3>Inserisci i numeri</h3>
				<input name="num1" type="number" placeholder="Primo numero obbligatorio" required>
				<input name="num2" type="number" placeholder="Secondo numero" >
			</div>
		</fieldset>
		<fieldset><button type="submit">Aggiungi</button></fieldset>
	</form>

</body>
</html>
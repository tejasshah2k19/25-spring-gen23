<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
<h2>Login</h2>

<form action="authenticate" method="post" enctype="multipart/form-data">
	Email : <input type="text" name="email" /><br><br>
	Password : <input type="password" name="password" /><br><br>
	
	<input type="submit" value="Login"/>
	
</form>

<a href="signup">New User?</a>
<br>
${error }

</body>
</html>
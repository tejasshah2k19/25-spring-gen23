<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
<h2>Signup</h2>

<form action="saveuser" method="post" enctype="multipart/form-data">
	FirstName : <input type="text" name="firstName" /><br><br>
	Email : <input type="text" name="email" /><br><br>
	Password : <input type="password" name="password" /><br><br>
	ProfilePic: <input type="file" name="profilePic"/><br><Br> 
	
	<input type="submit" value="Signup"/>
	
</form>

<a href="login">Existing User?</a>
</body>
</html>
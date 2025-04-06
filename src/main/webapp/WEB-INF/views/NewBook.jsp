<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
	<form action="savebook" method="post">
		BookName: <input type="text" name="bookName" value="${book.bookName}" />
		${result.getFieldError("bookName").getDefaultMessage()}
		
		<br>
		<Br> Price: <input type="text" name="price" value="${book.price}"/>
			${result.getFieldError("price").getDefaultMessage()}
	
		<br>
		<Br> Category: <input type="text" name="category" value="${book.category}" />
			${result.getFieldError("category").getDefaultMessage()}
	
		<br>
		<Br> Tax: <input type="text" name="tax" value="${book.tax}" />
			${result.getFieldError("tax").getDefaultMessage()}
	
		<br>
		<Br> <input type="submit" value="Add Book" />
	</form>
</body>
</html>
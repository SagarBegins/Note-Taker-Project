<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet">
<%@include file="allcss.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="navbar.jsp"%>
		<h1>Add Note</h1>
	</div>

	<br>
	<form action="SaveNoteServlet" method="post">
		<div class="container">
			<div class="form-group">
				<label for="title">Note Title</label> 
				<input type="text"
					class="form-control" id="title" name="title"
					placeholder="Enter Note Title">
			</div>
			<div class="form-group">
			<label for="content">Notes Content</label>
			<textarea required id="content" name="content"
				placeholder="Enter your Notes Here!"
				class="form-control" style="height:260px;"></textarea>

		</div>
		</div>
		<div class="container text-centre">
			<button type="submit" class="btn btn-primary p-2 m-3">Add</button>
		</div>
	</form>

</body>
</html>
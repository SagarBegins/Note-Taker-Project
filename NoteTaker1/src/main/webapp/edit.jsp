<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.helper.FactoryProvider,org.hibernate.*,com.entities.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<%@include file="allcss.jsp"%>
<link href="css/style.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<%@include file="navbar.jsp"%><br>
		<h1>This is Update page</h1>
		<%
		int noteId = Integer.parseInt(request.getParameter("note_id").trim());
		Session s = FactoryProvider.getFactory().openSession();
		Note note = (Note) s.get(Note.class, noteId);
		%>
		<form action="UpdateServlet2" method="post">
		<input  value="<%=note.getId()%>" name="noteId" type="hidden"/>
			<div class="container">
				<label for="title">Note Title</label>
				 <input required type="text" name="title" 
				 class="form-control" id="title"
					placeholder="Enetr Here Note Title"
					value="<%=note.getTitle()%>" />


				<div class="form-group">
					<label for="content">Note Content</label>
					<textarea required id="content" name="content"
						placeholder="Enetr your note Content" class="form-control"
						style="height: 300px;"><%=note.getContent()%></textarea>
				</div>
				<div class="container text-center">
					<button type="submit" class="btn btn-success p-2 m-3">Save Your Note</button>
				</div>

			</div>
		</form>


	</div>
</body>
</html>
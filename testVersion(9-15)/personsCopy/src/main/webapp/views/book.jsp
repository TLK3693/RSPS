<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page import="domain.Book"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Книги</title>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Books</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="JSPView/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="JSPView/style.css">

<!-- jQuery -->
<script defer src="js/jquery-3.6.4.js"></script>
<!-- Bootstrap JS + Popper JS -->
<script defer src="js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<jsp:include page="/views/header.jsp" />
		<div class="container-fluid">
			<div class="row justify-content-start ">
				<div class="col-8 border bg-light px-4">
					<h3>Список книг</h3>
					<table class="table">
						<thead>
							<th scope="col">Код</th>
							<th scope="col">Название</th>
							<th scope="col">Переплет</th>
							<th scope="col">Издательство</th>
							<th scope="col">Год</th>
							<th scope="col">Жанр</th>
							<th scope="col">Редактировать</th>
							<th scope="col">Удалить</th>
						</thead>
						<tbody>
							<c:forEach var="book" items="${books}">
								<tr>
									<td>${book.getId()}</td>
									<td>${book.getNameBook()}</td>
									<td>${book.getPereplet()}</td>
									<td>${book.getIzdatelstvo()}</td>
									<td>${book.getYearOfBirth()}</td>
									<td>${book.getGenre()}</td>
									<td width="20"><a href="#" role="button"
										class="btn btnoutline-primary"> <img alt="Редактировать"
											src="JSPView/icon-edit.png" width="15" height="15"></a></td>
									<td width="20"><a href="#" role="button"
										class="btn btnoutline-primary"> <img alt="Удалить"
											src="SPView/icon-delete.png" width="15" height="15"></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="col-4 border px-4">
					<form method="POST" action="">
						<h3>Новая книги</h3>
						<div class="mb-3">
							<br> <label for="inputRole" class="col-sm-3 col-form-label">Название</label>
							<div class="col-sm-6">
								<input type="text" name="inputRole" class="form-control"
									id="personRole" />
							</div>
						</div>
						<p>
							<br> <br> <br>
							<button type="submit" class="btn btn-primary">Добавить</button>
							<br>
						</p>
					</form>
				</div>
			</div>
		</div>
		<jsp:include page="/views/footer.jsp" />
	</div>
</body>
</html>

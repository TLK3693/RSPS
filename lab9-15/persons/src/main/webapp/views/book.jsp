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
<!--<title>Books</title>  -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="JSPView/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="JSPView/style.css">
<!-- jQuery -->
<script defer src="js/jquery-3.6.4.js" type="text/javascript"></script>
<!-- Bootstrap JS + Popper JS -->
<script defer src="js/bootstrap.min.js" type="text/javascript"></script>
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
							<th scope="col">Переплёт</th>
							<th scope="col">Издательство</th>
							<th scope="col">Год</th>
							<th scope="col">Жанр</th>
							<th scope="col">Удалить</th>
						</thead>
						<tbody>
							<c:forEach var="role" items="${roles}">
								<tr>
									<td>${role.getId()}</td>
									<td>${role.getNameBook()}</td>
									<td>${role.getPereplet()}</td>
									<td>${role.getIzdatelstvo()}</td>
									<td>${role.getYearOfBirth()}</td>
									<td>${role.getGenre()}</td>

									<td width="20"><a
										href='<c:url value="/editrole?id=${role.getId()}" />'
										role="button" class="btn btn-outline-primary"> <img
											alt="Редактировать" src="JSPView/icon-edit.png" width="15"
											height="15"></a></td>
									<td width="20"><a
										href="<c:url value="/deleterole?id=${role.getId()}" />"
										role="button" class="btn btn-outline-primary"> <img
											alt="Удалить" width="15" height="15" src="JSPView/icon-delete.png"
											onclick="return confirm('Удалить должность с кодом:'+${role.getId()}+'?')">
									</a></td>
							</c:forEach>
						</tbody>	
					</table>
				</div>
				<div class="col-4 border px-4">
					<form method="POST" action="">
						<h3>Новые книги</h3>
						<div class="mb-3">
							<br> <label for="inputName" class="col-sm-3 col-form-label">Название</label>
							<div class="col-sm-6">
								<input type="text" name="inputName" class="form-control"
									id="personRole" />
							</div>
						</div>
						<p>
						<div class="mb-3">
							<br> <label for="inputPereplet"
								class="col-sm-3 col-form-label">Переплёт</label>
							<div class="col-sm-6">
								<input type="text" name="inputPereplet" class="form-control"
									id="personPereplet" />
							</div>
						</div>
						<p>
						<div class="mb-3">
							<br> <label for="inputIzdatelstvo"
								class="col-sm-3 col-form-label">Издательство</label>
							<div class="col-sm-6">
								<input type="text" name="inputIzdatelstvo" class="form-control"
									id="personIzdatelstvo" />
							</div>
						</div>
						<p>
						<div class="mb-3">
							<br> <label for="inputYearOfBitrth"
								class="col-sm-3 col-form-label">Год</label>
							<div class="col-sm-6">
								<input type="text" name="inputYearOfBitrth" class="form-control"
									id="personYearOfBitrth" />
							</div>
						</div>
						<p>
						<div class="mb-3">
							<br> <label for="inputGenre" class="col-sm-3 col-form-label">Жанр</label>
							<div class="col-sm-6">
								<input type="text" name="inputGenre" class="form-control"
									id="personGenre" />
							</div>
						</div>
						<p>


							<button type="submit" class="btn btn-primary">Добавить</button>
							<br>
						</p>
				</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="/views/footer.jsp" />
	</div>
</body>
</html>
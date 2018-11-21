<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@ taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table class="table">
		<thead>
			<tr>
				<th>Hotel Name</th>
				<th>City</th>
				<th>State</th>
				<th>Price Per Night</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach
				var="item"
				items="${Hotels}"
			>
				<tr>
					<td>${item.name}</td>
					<td>${item.city}</td>
					<td>${item.state}</td>
					<td>$${item.pricePerNight}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form
		action="/hotels"
		method="post"
	>
		<select name="City">
			<option value="All">All cities</option>
			<c:forEach
				var="item"
				items="${ Both }"
			>
				<option value="${ item[0] }">${ item[0] }, ${ item[1] }</option>
			</c:forEach>
		</select>
		<button>Search by City!</button>
	</form>
	<a href="/">Search again?</a>
</body>
</html>
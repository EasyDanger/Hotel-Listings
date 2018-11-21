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
<title>This is an index.</title>
</head>
<body>

	<h2>Hotel Search</h2>
	<form
		action="/hotels"
		method="post"
	>
		<select name="City">
			<option value="all">All cities</option>
			<c:forEach
				var="item"
				items="${ Both }"
			>
				<option value="${ item[0] }">${ item[0] },${ item[1] }</option>
			</c:forEach>
		</select>
		<button>Search by City!</button>
	</form>
</body>
</html>
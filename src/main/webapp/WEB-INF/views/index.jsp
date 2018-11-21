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
				<%--Hey, here was a neat idea! Instead of hardcoding in the names of the cities and states of the hotels, why not make it programmatic? So, I made a list to represent each city and state, and iterated that list inside the option tags. Now, whenever I add a city to the database, this list automatically updates! But wait! Have you been to the HotelsDao, yet? Is that an array on the next line? What's going on here? --%>
				<option value="${ item[0] }">${ item[0] }, ${ item[1] }</option>
			</c:forEach>
		</select>
		<button>Search by City!</button>
	</form>
</body>
</html>
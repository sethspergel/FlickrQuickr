<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
	<jsp:directive.page contentType="text/html; charset=ISO-8859-1" 
		pageEncoding="ISO-8859-1" session="false"/>
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />

 		
<html xmlns="http://www.w3.org/1999/xhtml"
xmlns:c="http://java.sun.com/jsp/jstl/core">

<head>
<title>FlickrQuickr</title>
</head>
<body>
<h1>FlickrQuickr</h1>
<br/>
<br/>
<h3>Title: ${photoList.title}</h3>
<table>
<tr><td>Title</td><td>Image Link</td></tr>
<c:forEach var="photo" items="${photoList.items}">
<tr><td>${photo.title}</td><td><a href='${photo.link}'><img src='${photo.media["m"] }'/></a></td></tr>

</c:forEach>
</table>

</body>
</html>
</jsp:root>
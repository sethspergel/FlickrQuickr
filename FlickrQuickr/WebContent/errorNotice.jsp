<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
	<jsp:directive.page contentType="text/html; charset=ISO-8859-1" 
		pageEncoding="ISO-8859-1" session="false"/>
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Oh no! You broke the Internet!</title>
</head>
<body>
<h1>An error has occurred!</h1>
<h3>Looks like one of the gerbils powering the Internet fell off the treadmill!</h3>
<H4>Please send an email to /dev/null with this message: ${error }</H4>
</body>
</html>
</jsp:root>
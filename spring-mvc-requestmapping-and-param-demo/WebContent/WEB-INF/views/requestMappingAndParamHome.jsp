<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>@RequestMapping and @RequestParam test bed</title>
</head>
<body>
<div align = "left">
	<h2 align = "center">Hello, Welcome to the @RequestMapping and @RequestParam Test Bed</h2>
	<hr/>
	<form action="test1">
		<h3>test 1 : Testing @RequestParam without explicit attributes</h3>
		<label id="organization-name">Organization Name</label>
		<input type="text" name="orgname" size="40"/>
		<input type="submit" value="Submit"/>
	</form>
	<br/>
	<br/>
	<form action="test2">
		<h3>test 2 : Testing @RequestParam method attribute</h3>
		<label id="organization-name">Organization Name</label>
		<input type="text" name="orgname" size="40"/>
		<input type="submit" value="Submit"/>
	</form>
	<br/>
	<br/>
	<form action="test3">
		<h3>test 3 : Testing @RequestMapping fallback feature</h3>
		<input type="submit" value="Submit"/>
	</form>
	<br/>
	<br/>
	<form action="test4">
		<h3>test 4 : Testing @RequestParam defaultValue attributes</h3>
		<label id="organization-name">Organization Name</label>
		<input type="text" name="orgname" size="40"/>
		<input type="submit" value="Submit"/>
	</form>
	<br/>
	<br/>
	<form action="test5">
		<h3>test 5 : Testing @RequestParam without name or value attributes</h3>
		<label id="organization-name">Organization Name</label>
		<input type="text" name="orgname" size="40"/>
		<input type="submit" value="Submit"/>
	</form>
</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dao.body,test.testlogin,util.Query_Map,test.testClient,java.util.List,java.util.Iterator,java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
	<script type="text/javascript" src="js/lib/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="js/lib/jquery-ui.js"></script>
    <script type="text/javascript" src="js/lib/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/lib/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript" src="js/lib/main.js"></script>
    <script src="libs/SuperMap.Include.js"></script>
    
    <script type="text/javascript" src="conf/config.js"></script>
    
    <script type="text/javascript" src="js/init.js"></script>
    <script type="text/javascript" src="js/jbdw.js"></script>
    <script type="text/javascript" src="js/theme.js"></script>
    <script type="text/javascript">

    </script>
</head>
<body>
	<%
	testlogin tl = new testlogin();
	String str = tl.testlogin();
	%>
	
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	http://localhost:8080/SpringMVC/test/forward<br>
	Hello world2!  /test/forward
</h1>

<%
  out.println("name1：");

  //(1)requestオブジェクトのgetAttributeメソッドを使用し、前ページで
  //    登録されたrequestスコープを持つデータを取得します。
  out.println(request.getAttribute("name1"));
  out.println("<BR>");
  out.println("name2：");

  //(2)requestオブジェクトのgetAttributeメソッドを使用し、前ページで
  //   登録されたrequestスコープを持つデータを取得します。
  out.println(request.getAttribute("name2"));
%>
</body>
</html>

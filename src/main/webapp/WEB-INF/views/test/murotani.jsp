<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.util.*"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	http://localhost:8080/SpringMVC/test/murotani<br>
	Hello world!  /test/murotani<br>
	Hello world2!  /test/murotani?cmd1=forward<br>
</h1>
<hr>
<P>  The time on the server is ${serverTime}. </P>
<P>  sending message from servlet -- model.test = ${test}. </P>
<P> JSPでは、宣言せずに使用できるオブジェクトとして9つの暗黙オブジェクト<br>
（request, response, pageContext, session, application, config, page, exception）が用意されています</P> 
<%

	String cmd1 = request.getParameter("cmd1");

	String name1 = "Java";
	String name2 = " Forward";
	
	//(1)pageContextオブジェクトを使用し、requestスコープを
	//   持つデータ値を登録しています。requestスコープの
	//   データ値の登録は、普通requestオブジェクトを使用しますが、
	//   ここでは、あえてpageContextオブジェクトを使用しています。
	pageContext.setAttribute("name1", name1, PageContext.REQUEST_SCOPE);
	pageContext.setAttribute("name2", name2, PageContext.REQUEST_SCOPE);
	
	//(2)forwardメソッドを使用し、リクエストを引数に
	//   指定したページに転送します。
	if(cmd1!= null && cmd1.equals("forward")){
		pageContext.forward("./forward.jsp");
	}else{
		
		  //(3)全てのパラメータを検索して出力
		  Map mpParams = request.getParameterMap();
		  Set stKeys = mpParams.keySet( ); 
		  Iterator i = stKeys.iterator( ); 
		  while (i.hasNext()) { 
			  String key = (String)i.next(); 
			  String par[]=(String[]) mpParams.get(key); 
			  out.print(key+"="+par[0] + "<br>");
			  System.out.println(key+"="+par[0]); 
		  } 
		
	}
%>
<hr>
</body>
</html>

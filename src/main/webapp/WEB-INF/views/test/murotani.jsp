<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.util.*"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<STYLE type="text/css">
span {color:red;   }
</STYLE>
<h1>
	http://localhost:8080/SpringMVC/test/murotani<br>
	Hello world!  /test/murotani<br>
	Hello world2!  /test/murotani?cmd1=forward<br>
</h1>
<hr>
<P>  The time on the server is <span>${serverTime}. </span></P>
<P>  sending message from servlet -- model.test = <span>${test}. </span></P>
<P> JSPでは、宣言せずに使用できるオブジェクトとして9つの暗黙オブジェクト<br>
<span>（request, response, pageContext, session, application, config, page, exception）</span>が用意されています</P> 
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
		// javax.servlet.jsp.PageContext
		pageContext.forward("./forward.jsp");
	}else{
		// ヘッダー追加
		response.addHeader("htest","OK");
		  
		//	sessionの処理	  
		if (session.isNew()) {
			session.setAttribute("id", 0);
			out.println("<span>" + session.getAttribute("id") + " </span>Nice to meet you.<br>");
		} else {
			String id = session.getAttribute("id").toString();
			int a = 0;
			if(id != null && !id.equals("")){
				a = new Integer(id).intValue() + 1;
			}
			session.setAttribute("id", a);
			out.println("Hello! <span>" + session.getAttribute("id") + "</span><br>");
		}
		  
		  
		//(3)全てのパラメータを検索して出力
		Map mpParams = request.getParameterMap();
		Set stKeys = mpParams.keySet( ); 
		Iterator i = stKeys.iterator( ); 
		out.print("<span>");
		while (i.hasNext()) { 
			String key = (String)i.next(); 
			String par[]=(String[]) mpParams.get(key); 
			out.print(key+"="+par[0] + "<br>");
			System.out.println(key+"="+par[0]); 
		}
		out.print("</span>");
	}
%>
<P> web.xmlの値を取得する </P>
<pre>
&lt;context-param&gt;
	&lt;param-name&gt;パラメーター名&lt;/param-name&gt;
	&lt;param-value&gt;パラメーター値&lt;/param-value&gt;
&lt;/context-param&gt;
</pre>
<br>
<%
	//	web.xmlの値を取得する
	String contextParam = application.getInitParameter("contextConfigLocation");
	out.print("<span>contextConfigLocation is " + contextParam.toString() + "</span><br>");

%>
<pre>
&lt;init-param&gt;
	&lt;param-name>contextConfigLocation&lt;/param-name&gt;
	&lt;param-value>/WEB-INF/spring/appServlet/servlet-context.xml&lt;/param-value&gt;
&lt;/init-param&gt;
</pre>
<%
	//	web.xmlの値を取得する
	String initParam = config.getInitParameter("contextConfigLocation");
	out.print("<span>contextConfigLocation is " + config.getServletName() + "</span><br>");

%>

<hr>
</body>
</html>

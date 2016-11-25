<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<c:set var="code" value="<script>alert('hello');</script>"
		scope="request" />
	<c:out value="${code}" escapeXml="false" />
	<br>

	<c:url value="/AServlet" />
	<br> ${pageContext.request.contextPath}/AServlet
	<br>
	<a
		href="<c:url value='/index.jsp'>
		<c:param name="name" value="lalala"/>
	</c:url>">点击这里回到主页</a>
	<br />
	<c:url value='/index.jsp'>
		<c:param name="name" value="bamboo" />
	</c:url>
	<br />

	<c:if test="${empty param.name}">
		您没有给出名为name的参数
	</c:if>
	<hr />

	<c:choose>
		<c:when test="${empty param.name}">
			您没有给出名为name的参数
		</c:when>
		<c:otherwise>
			是谁?是${param.name}
		</c:otherwise>
	</c:choose>
	<br />

	<c:forEach var="i" begin="1" end="10">
		${i}<br />
	</c:forEach>
	<br />

	<%
		String[] strs = { "one", "two", "three", "four" };
		request.setAttribute("strs", strs);
	%>
	<c:forEach items="${strs}" var="str">
		${str}
	</c:forEach>
	<br />

	<%
		ArrayList<String> list = new ArrayList();
		list.add("一");
		list.add("二");
		list.add("三");
		pageContext.setAttribute("list", list);
	%>
	<c:forEach items="${list }" var="ele" varStatus="vs">
		${vs.index} ${vs.count }<br />
	</c:forEach>
</body>
</html>

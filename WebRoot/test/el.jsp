<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.bamboo.user.domain.*" %>
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
    
    <title>My JSP 'el.jsp' starting page</title>
    
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
    <%
    	Address address = new Address();
    	address.setCity("杭州");
    	address.setStreet("滨盛路1505");

    	Employee emp = new Employee();
    	emp.setName("bamboo");
    	emp.setSalary(4514.98);
    	emp.setAddress(address);

    	request.setAttribute("emp", emp);
    %>
    <h3>使用EL获取request域的emp</h3>
    ${requestScope.emp.address.street};<!--reqest.getAttribute("emp").getAddress().getStreet()-->
	<br/>	
  </body>
</html>

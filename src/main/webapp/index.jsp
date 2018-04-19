<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="java.net.InetAddress"%> 

<%  //获取本地ip，在web页面上线上
    InetAddress address = InetAddress.getLocalHost();    
    String ip=address .getHostAddress().toString();    
    //pageContext.setAttribute("ip",ip);

    
%>  

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
   <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>  
  <body>
 		<p>openapi接口自动化测试</p>&nbsp;&nbsp;&nbsp;正在使用的服务器IP：<%=ip%>
 		<br/> <br/> <br/>
   		请注意检查测试用例是否是本IP的数据<br/><br/><br/>
   		<!-- 通过不同的参数，控制不同的数据流向，此处为入口 -->
   		<a href=jsp/menu.jsp?key=test>测试环境</a>&nbsp;&nbsp;&nbsp;
   		<a href=jsp/menu.jsp?key=uat>uat环境</a>&nbsp;&nbsp;&nbsp;
   		<a href=jsp/menu.jsp?key=com>线上环境</a>
  </body>
</html>


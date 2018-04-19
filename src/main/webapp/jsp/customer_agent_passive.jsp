<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String key = request.getParameter("key");
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>  
  	<br/>
  	可以使用扫描枪扫描二维码即可
  	<br/>
  	商户被扫：
  		<br/>
  			<form action="servlet/CustomerPassiveServlet?" method="get">
  				<p>请输入支付码: <input type="text" name="payCode" /></p>  
  				<input type="hidden" name="key" value="<%=key%>" />
  				<input type="submit" value="提交" /> 
			</form>
   		<br/>
  		<br/>
  	代理商被扫：
 		<br/>
  			<form action="servlet/AgentPassiveServlet" method="get">
  				<p>请输入支付码: <input type="text" name="payCode" /></p> 
  				<input type="hidden" name="key" value="<%=key%>" /> 
  				<input type="submit" value="提交" />
			</form> 
  </body>
</html>

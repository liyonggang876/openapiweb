<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="openapiautotest.baselib.BaseLib" %>
<%@ page import="openapiautotest.readcase.ReadAgentCase" %>
<%@ page import="openapiautotest.api.OpenapiDeclare" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String key = request.getParameter("key");
String agentNum = request.getParameter("agentNum");
String customerNum = request.getParameter("customerNum");
String shopName = "哆啦宝超市";
String address = "北京劲松";
String oneIndustry = "美食";
String twoIndustry = "湘菜";
String mobilePhone = "135" + String.valueOf((int)(10000000+Math.random()*(10000000-1+1)));
String mapLng = "121.499641";
String mapLat = "31.238298";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'declare_shop_info.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>Openapi报单店铺信息，文本输入框中的内容皆可修改<br/>
    <form action="servlet/DeclareCustomerServlet?" method="post">
  				<p>代理商编号: <input type="text" name="agentNum" style="width:360px" value=<%=agentNum%> /><font size="3" color="red">*</font></p> 
  				<p>商户编号: <input type="text" name="customerNum" style="width:360px" value=<%=customerNum%> /><font size="3" color="red">*</font></p> 
  				<p>店铺名称: <input type="text" name="shopName" style="width:360px" value=<%=shopName%> /><font size="3" color="red">*</font></p>
  				<p>地址: <input type="text" name="address" style="width:360px" value=<%=address%> /><font size="3" color="red">*</font></p>  
  				<p>一级行业: <input type="text" name="oneIndustry" style="width:360px" value=<%=oneIndustry%> /><font size="3" color="red">*</font></p> 
  				<p>二级行业: <input type="text" name="twoIndustry"  style="width:360px" value=<%=twoIndustry%> /><font size="3" color="red">*</font></p>  
  				<p>店铺联系人手机号: <input type="text" name="mobilePhone"  style="width:360px" value=<%=mobilePhone%> /><font size="3" color="red">*</font></p>  
  				<p>经度: <input type="text" name="mapLng" style="width:360px" value=<%=mapLng%> /><font size="3" color="red">*</font></p>
  				<p>维度: <input type="text" name="mapLat" style="width:360px" value=<%=mapLat%> /><font size="3" color="red">*</font></p>
  				<input type="hidden" name="key" value="<%=key%>" />
  				<input type="submit" value="下一步" /> 
	</form>
	</body>
</html>

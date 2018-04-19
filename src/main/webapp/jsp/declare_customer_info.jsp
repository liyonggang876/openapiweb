<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="openapiautotest.baselib.BaseLib" %>
<%@ page import="openapiautotest.readcase.ReadAgentCase" %>
<%@ page import="openapiautotest.api.OpenapiDeclare" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String key = request.getParameter("key");
String testCasePath = BaseLib.getConfigText("testCasePath");
String fileName = BaseLib.getConfigText(key + "CaseAgent");
String agentNum = ReadAgentCase.getAgentNum(testCasePath + fileName); //获取默认代理商编号
String fullName = OpenapiDeclare.getFullName();
String industry = "10081614701426099160002";
String province = "北京";
String city = "京";
String email = "111111333333@qq.com";
String linkMan = "哆啦宝测试";
//随机生成手机号后8位
String linkPhone = "135" + String.valueOf((int)(10000000+Math.random()*(10000000-1+1)));
String customerType = "NONE";
String certificateType = "IDENTIFICATION";
//身份证后4位随机生成
String certificateCode = "23262219851105" + String.valueOf((int)(1000+Math.random()*(1000-1+1)));

String district = "朝阳";
String certificateName = "王明";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'declare.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>Openapi报单商户信息，文本输入框中的内容皆可修改<br/>
    <form action="servlet/DeclareCustomerServlet?" method="post">
  				<p>代理商编号: <input type="text" name="agentNum" style="width:360px" value=<%=agentNum%> /><font size="3" color="red">*</font></p> 
  				<p>全称: <input type="text" name="fullName" style="width:360px" value=<%=fullName%> /><font size="3" color="red">*</font></p> 
  				<p>简称: <input type="text" name="shortName" style="width:360px" value=<%=fullName%> /><font size="3" color="red">*</font></p>
  				<p>行业: <input type="text" name="industry" style="width:360px" value=<%=industry%> /><font size="3" color="red">*</font></p>  
  				<p>省份: <input type="text" name="province" style="width:360px" value=<%=province%> /><font size="3" color="red">*</font></p> 
  				<p>城市: <input type="text" name="city"  style="width:360px" value=<%=city%> /><font size="3" color="red">*</font></p>  
  				<p>邮箱: <input type="text" name="email"  style="width:360px" value=<%=email%> /></p>  
  				<p>联系人: <input type="text" name="linkMan" style="width:360px" value=<%=linkMan%> /><font size="3" color="red">*</font></p>
  				<p>联系电话: <input type="text" name="linkPhone" style="width:360px" value=<%=linkPhone%> /><font size="3" color="red">*135开头，后面8位随机生成</font></p>
  				<p>商户类型: <input type="text" name="customerType" style="width:360px" value=<%=customerType%> /><font size="3" color="red">*默认NONE</font></p>
  				<p>证件类型: <input type="text" name="certificateType" style="width:360px" value=<%=certificateType%> /><font size="3" color="red">*默认身份证</font></p>
  				<p>证件编号: <input type="text" name="certificateCode" style="width:360px" value=<%=certificateCode%> /><font size="3" color="red">*</font></p>
  				<p>地区: <input type="text" name="district"  style="width:360px" value=<%=district%> /><font size="3" color="red">*</font></p>
  				<p>证件人姓名: <input type="text" name="certificateName" style="width:360px" value=<%=certificateName%> /><font size="3" color="red">*</font></p>
  				<input type="hidden" name="key" value="<%=key%>" />
  				<input type="submit" value="下一步" /> 
	</form>
	<!--  
	<p>行业{"data":{"industryList":[{"industryName":"美食","industryNum":"10081614701426099160002"},{"industryName":"生活方式","industryNum":"10081614701426099190004"},{"industryName":"生活服务","industryNum":"10081614701426099190005"},{"industryName":"购物","industryNum":"10081614701426099450047"},{"industryName":"丽人","industryNum":"10081614701426099560066"},{"industryName":"健身","industryNum":"10081614701426099620076"},{"industryName":"酒店","industryNum":"10081614701426099700090"},{"industryName":"教育","industryNum":"10081614701426099190006"}]},"result":"success"}</p>
  <p>省份{"data":{"addressList":[{"code":"01","name":"北京"},{"code":"02","name":"上海"},{"code":"03","name":"天津"},{"code":"04","name":"重庆"},{"code":"05","name":"河北"},{"code":"06","name":"山西"},{"code":"07","name":"内蒙古"},{"code":"08","name":"辽宁"},{"code":"09","name":"吉林"},{"code":"10","name":"黑龙江"},{"code":"11","name":"江苏"},{"code":"12","name":"浙江"},{"code":"13","name":"安徽"},{"code":"14","name":"福建"},{"code":"15","name":"江西"},{"code":"16","name":"山东"},{"code":"17","name":"河南"},{"code":"18","name":"湖北"},{"code":"19","name":"湖南"},{"code":"20","name":"广东"},{"code":"21","name":"广西"},{"code":"22","name":"海南"},{"code":"23","name":"四川"},{"code":"24","name":"贵州"},{"code":"25","name":"云南"},{"code":"26","name":"西藏"},{"code":"27","name":"陕西"},{"code":"28","name":"甘肃"},{"code":"29","name":"宁夏"},{"code":"30","name":"青海"},{"code":"31","name":"新疆"},{"code":"32","name":"香港"},{"code":"33","name":"澳门"},{"code":"34","name":"台湾"}]},"result":"success"}</p>
  <p>北京区域{"data":{"addressList":[{"code":"010101","name":"东城区"},{"code":"010102","name":"西城区"},{"code":"010103","name":"崇文区"},{"code":"010104","name":"宣武区"},{"code":"010105","name":"朝阳区"},{"code":"010106","name":"丰台区"},{"code":"010107","name":"石景山区"},{"code":"010108","name":"海淀区"},{"code":"010109","name":"门头沟区"},{"code":"010110","name":"房山区"},{"code":"010111","name":"通州区"},{"code":"010112","name":"顺义区"},{"code":"010113","name":"昌平区"},{"code":"010114","name":"大兴区"},{"code":"010115","name":"怀柔区"},{"code":"010116","name":"平谷区"},{"code":"010117","name":"密云县"},{"code":"010118","name":"延庆县"}]},"result":"success"}</p>
  -->
  </body>
</html>

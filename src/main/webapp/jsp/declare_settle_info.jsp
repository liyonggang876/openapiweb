<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String key = request.getParameter("key");
String agentNum = request.getParameter("agentNum");
String customerNum = request.getParameter("customerNum");
String bankAccountName = "哆啦宝";
String bankAccountNum = "452452523452352352";
String province = "北京";
String city = "北京";
String bankBranchName = "招商银行北京分行";
String bankName = "招商银行";
String settleAmount	= "2.00";
String payBankListNumWX = "10031414639876930831004";
String payBankListRateWX = "0.38";	 
String payBankListNumAIP = "10031414639876930831005";
String payBankListRateAIP = "0.38";	
String payBankListNumLPRO = "10031414639876930831011";
String payBankListRateLPRO = "0.38";
String accountType = "PRIVATE";
String phone = "18201223907";
String privateType = "PERSON";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'delclare_settle_info.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
 <body>Openapi结算信息，文本输入框中的内容皆可修改<br/>
    <form action="servlet/DeclareSettleServlet?" method="post">
  				<input type="hidden" name="agentNum" value=<%=agentNum%> />
  				<p>商户编号: <input type="text" name="customerNum" style="width:360px" value=<%=customerNum%> /><font size="3" color="red">*</font></p> 
  				<p>银行账户名称: <input type="text" name="bankAccountName" style="width:360px" value=<%=bankAccountName%> /><font size="3" color="red">*</font></p>
  				<p>银行账户编号: <input type="text" name="bankAccountNum" style="width:360px" value=<%=bankAccountNum%> /><font size="3" color="red">*</font></p>  
  				<p>商户所属省份: <input type="text" name="province" style="width:360px" value=<%=province%> /><font size="3" color="red">*</font></p> 
  				<p>商户所属城市: <input type="text" name="city"  style="width:360px" value=<%=city%> /><font size="3" color="red">*</font></p>  
  				<p>银行分行名称: <input type="text" name="bankBranchName"  style="width:360px" value=<%=bankBranchName%> /><font size="3" color="red">*</font></p>  
  				<p>银行名称: <input type="text" name="bankName" style="width:360px" value=<%=bankName%> /><font size="3" color="red">*</font></p>
  				<p>结算金额: <input type="text" name=settleAmount style="width:360px" value=<%=settleAmount%> /><font size="3" color="red">*</font></p>
  				<input type="hidden" name="payBankListNumWX"  style="width:360px" value=<%=payBankListNumWX%> /> 
  				<p>微信费率: <input type="text" name="payBankListRateWX"  style="width:360px" value=<%=payBankListRateWX%> /><font size="3" color="red">*</font></p>  
                <input type="hidden" name="payBankListNumAIP"  style="width:360px" value=<%=payBankListNumAIP%> /> 
  				<p>支付宝费率: <input type="text" name="payBankListRateAIP"  style="width:360px" value=<%=payBankListRateAIP%> /><font size="3" color="red">*</font></p>  
				<input type="hidden" name="payBankListNumLPRO"  style="width:360px" value=<%=payBankListNumLPRO%> /> 
  				<p>小程序费率: <input type="text" name="payBankListRateLPRO"  style="width:360px" value=<%=payBankListRateLPRO%> /><font size="3" color="red">*</font></p>  
 				<p> 账户类型: <input type="text" name="accountType" style="width:360px" value=<%=accountType%> /><font size="3" color="red">*</font></p>
  				<p>银行预留手机号: <input type="text" name="phone" style="width:360px" value=<%=phone%> /><font size="3" color="red">*</font></p>
   				<p>个人: <input type="text" name="privateType" style="width:360px" value=<%=privateType%> /><font size="3" color="red">*</font></p>
  				
  				<input type="hidden" name="key" value="<%=key%>" />
  				<input type="submit" value="下一步" /> 
	</form>
	</body>
</html>

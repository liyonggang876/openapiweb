<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//获取支付链接
String resWX ="error";
//resWX="InspirySpUrlQuery:http://172.19.24.207:8089/order/inspiry/check";
resWX = request.getParameter("resWX");

String resAIP = "error";
//resAIP="InspirySpUrlDecode:http://172.19.24.207:8093/passive/inspirybox/create";
resAIP =request.getParameter("resAIP");

String refund = "error";
if(session.getAttribute("agentRefund") != null){
	refund = session.getAttribute("agentRefund").toString();
}

//String refund="aaa";
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
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/qrcode.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>本页可进行的操作为---代理商支付&nbsp;&nbsp;&nbsp;&nbsp;代理商退款&nbsp;&nbsp;&nbsp;&nbsp;代理商部分退款<br/>
  如进行退款或者部分退款，请先支付！
  <br/><br/><br/>
  微信结果如下:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  
  
  <br/>
  <%if(resWX.indexOf("http") != -1){
	%>
	<% 
  	if(refund.equals("agentRefund")){
  	%>
  	<a href="servlet/AgentRefundServlet?type=WX"><font size="3" color="red">退款</font></a>
  	<% 
  	}
  %>
   <% 
  	if(refund.equals("agentPartRefund")){
  	%>
  	<a href="servlet/AgentPartRefundServlet?type=WX"><font size="3" color="red">部分退款</font></a>
  	<% 
  	}
  %>
	<input id="WXtext" type="text" value="<%=resWX %>" style="width:80%" /><br />
	<div id="WX" style="width:100px; height:100px; margin-top:15px;"></div>
	<% 		
	} else{
	%>
	<%=resWX%>
	<%
	}%>
<br/><br/><br/><br/><br/><br/><br/><br/><br/>

支付宝结果如下:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  

<br/>
  <%if(resAIP.indexOf("http") != -1){
	%>
	<% 
  	if(refund.equals("agentRefund")){
  	%>
  	<a href="servlet/AgentRefundServlet?type=AIP"><font size="3" color="red">退款</font></a>
  	<% 
  	}
  %>
   <% 
  	if(refund.equals("agentPartRefund")){
  	%>
  	<a href="servlet/AgentPartRefundServlet?type=AIP"><font size="3" color="red">部分退款</font></a>
  	<% 
  	}
  %>
	<input id="text" type="text" value="<%=resAIP %>" style="width:80%" /><br />
	<div id="ALP" style="width:100px; height:100px; margin-top:15px;"></div>
	<% 		
	} else{
	%>
	<%=resAIP%>
	<%
	}%>


<script type="text/javascript">
var qrcode = new QRCode(document.getElementById("WX"), {
	width : 200,
	height : 200
});

function makeCode () {		
	var elText = document.getElementById("WXtext");
	
	if (!elText.value) {
		alert("Input a text");
		elText.focus();
		return;
	}
	
	qrcode.makeCode(elText.value);
}

makeCode();

$("#text").
	on("blur", function () {
		makeCode();
	}).
	on("keydown", function (e) {
		if (e.keyCode == 13) {
			makeCode();
		}
	});
</script>

<script type="text/javascript">
var qrcode = new QRCode(document.getElementById("ALP"), {
	width : 200,
	height : 200
});

function makeCode () {		
	var elText = document.getElementById("text");
	
	if (!elText.value) {
		alert("Input a text");
		elText.focus();
		return;
	}
	
	qrcode.makeCode(elText.value);
}

makeCode();

$("#text").
	on("blur", function () {
		makeCode();
	}).
	on("keydown", function (e) {
		if (e.keyCode == 13) {
			makeCode();
		}
	});
</script>
</body>
</html>

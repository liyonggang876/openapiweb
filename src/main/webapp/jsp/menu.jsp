
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
  String key = request.getParameter("key");
  String data = "";

	if(key.equals("test")){
		data = "测试环境数据";
	}
	if(key.equals("uat")){
		data = "uat环境数据";
	}
	if(key.equals("com")){
		data = "线上环境数据";
	}
	
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
	<link rel="StyleSheet" href="js/dtree.css" type="text/css" />
    <script type="text/javascript" src="js/dtree.js"></script>
  </head>
  
  <body>  
    <div class="cnblogs_Highlighter">
    	<pre class="brush:javascript">
			<script type="text/javascript">
				tree= new dTree('tree');//创建一个对象.
				tree.add("1","-1","openapi--<%=data%>","","","","","",false);
 				tree.add("11","1","商户","","","","","",false);
				tree.add("111","11","主扫","servlet/CustomerServlet?key=<%=key%>&refund=no&amount=0.01","",""); 
				tree.add("112","11","被扫","jsp/customer_agent_passive.jsp?key=<%=key%>","","");
				tree.add("113","11","退款","servlet/CustomerServlet?key=<%=key%>&refund=refund&amount=0.01","","");
				tree.add("114","11","部分退款","servlet/CustomerServlet?key=<%=key%>&refund=partRefund&amount=0.02","","");
				                  
				tree.add("12","1","代理商","","","","","",false);
				tree.add("121","12","主扫","servlet/AgentServlet?key=<%=key%>&agentRefund=no&amount=0.01","","");
				tree.add("122","12","被扫","jsp/customer_agent_passive.jsp?key=<%=key%>","","");
				tree.add("123","12","退款","servlet/AgentServlet?key=<%=key%>&agentRefund=agentRefund&amount=0.01","","");
				tree.add("124","12","部分退款","servlet/AgentServlet?key=<%=key%>&agentRefund=agentPartRefund&amount=0.02","","");
				
				tree.add("13","1","报单","","","","","",false);
				tree.add("131","13","查询省份接口","servlet/DeclareInfoServlet?key=<%=key%>&type=Province&tag=1","","");
				tree.add("132","13","通过省份code查询城市接口","servlet/DeclareInfoServlet?key=<%=key%>&type=City&tag=2","","");
				tree.add("133","13","通过城市code查询地区接口","servlet/DeclareInfoServlet?key=<%=key%>&type=District&tag=3","","");
				tree.add("134","13","查询行业接口","servlet/DeclareInfoServlet?key=<%=key%>&type=Industry&tag=4","","");
				tree.add("135","13","通过一级行业code查询二级行业接口","servlet/DeclareInfoServlet?key=<%=key%>&type=IndustrySecond&tag=5","","");
				tree.add("136","13","查询支付银行接口","servlet/DeclareInfoServlet?key=<%=key%>&type=PayInfo&tag=6","","");
				tree.add("137","13","通过银行关键字查询银行列表接口","servlet/DeclareInfoServlet?key=<%=key%>&type=BankKey&tag=7","","");
				tree.add("138","13","通过银行code和支行关键字查询支行接口","servlet/DeclareInfoServlet?key=<%=key%>&type=BankCode&tag=8","","");
				tree.add("139","13","报单-个人","jsp/declare_customer_info.jsp?key=<%=key%>","","");
				
             
				document.write(tree);
			</script>
		</pre>
	</div>
  </body>
</html>

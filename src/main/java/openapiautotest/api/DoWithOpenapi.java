package openapiautotest.api;


import openapiautotest.baselib.BaseLib;
import openapiautotest.baselib.OutInfo;
import openapiautotest.https.SendReuqest;
import openapiautotest.readcase.ReadAgentCase;
import openapiautotest.readcase.ReadAgentPassiveCase;
import openapiautotest.readcase.ReadCustomerCase;
import openapiautotest.readcase.ReadCustomerPassiveCase;

/*
 * 实现openapi的功能
 */
public class DoWithOpenapi {
	
	//生成一个发生https请求的对象
	SendReuqest sq = new SendReuqest();

	//商户主扫操作
	public String customer(String key,String amount){
		if(amount == null || amount.trim() == "" || amount == "null"){
			amount = "0.01";
		}
		
		String res = "error";//默认值，一旦结果显示error，表示该方法出错
		String token = "testtoken"; //token默认值
		

		String testUrl = BaseLib.getConfigText("testUrlCustomer");//获取测试服务器地址
		OutInfo.msg("==获取测试服务器URL:=" + testUrl);
		
		String accessKey = BaseLib.getConfigText(key + "AccessKey"); //获取测试服务器AccessKey
		OutInfo.msg("==获取" + key + "accessKey:=" + accessKey);		
		
		String testCasePath = BaseLib.getConfigText("testCasePath");//获取测试文件路径		
		OutInfo.msg("==获取测试用例路径:=" + testCasePath);
		
		
		String testCase = key +  "CaseCustomer";   //测试用例名称key
		OutInfo.msg("testCase=" + testCase);
		String testCaseName = BaseLib.getConfigText(testCase);	//获取测试用例的名称
		testCaseName = testCasePath + testCaseName;  //拼装成完整的路径及文件名称
		OutInfo.msg("==获取测试用例路径:=" + testCaseName);
		
		String requestNum = GetRequestNum.getDate();  //获取流水号 ：当前日期+4位随机数
		OutInfo.msg("==获取交易流水号:=" + requestNum);		
		
		//读测试文件内容，拼接成json
		//String amount = "0.01";  //默认支付1分
		String json = ReadCustomerCase.getFileContentByJson(testCaseName, requestNum,amount);
		OutInfo.msg("==请求JSON串:" + json);
		
		OutInfo.msg("==准备请求测试服务器获取token==");		
		
		String onePost ="error";
		onePost = sq.doPostToOpenapi(testUrl,accessKey,json,token);//向测试服务器发起请求，生成token		
		OutInfo.msg("==第一次请求返回结果==" + onePost);
		 
		String tokenPath = BaseLib.getConfigText("tokenPath"); //获取测试服务器token路径
		OutInfo.msg("==获取tokenPath:=" + tokenPath);		 
		token = GetToken.getTestToken(tokenPath);  //读测试服务器token文件，获取token
		
		
		if((token != null) && (token.trim() != "" )){   //获取到token，如获取到token继续执行，判断是否成功，如果失败，直接返回错误信息
			OutInfo.msg("==获取测试服务器token:=" + token);				
			String Url = BaseLib.getConfigText(key + "UrlCustomer"); //向服务器正式发起请求
			OutInfo.msg("==第二次向服务器发起请求URL:=" + Url);		
			res = sq.doPostToOpenapi(Url,accessKey,json,token);  //把url，key，json，token一起做post请求，和工具postman效果一直
			OutInfo.msg("==创建支付链接返回结果=" + res);
			
			//调试使用，发布后注释
			//res = "{\"data\":{\"url\":\"https://order.duolabao.com/active/c?state=152108041867210989%7C10011015178258181970145%7C0.01%7C15%7CAPI\"},\"result\":\"success\"}";
	
			
			//对返回信息进行处理，如果支付成功，直接返回支付链接，否则直接返回错误信息
			if(res.indexOf("\"url\":\"https:") != -1){   //如果有https则表示成功，进行分割截取
			  String urlTemp[] = res.split("\"url\":\"");  //用'"url"'进行第一次分割
	   		  String urlTemp1[] = urlTemp[1].split("\"},");//获取分割的第二部分，在用'"},'进行分割，获取url，把支付新连接返回
	   		  String customerNumAndShopNum = ReadCustomerCase.getCustomerNumAndShopNum(testCaseName);
	   		  OutInfo.msg("获取|customerNum|shopNum=" + customerNumAndShopNum);
	   		  res = urlTemp1[0] + "=====" + requestNum + customerNumAndShopNum;   		 //把支付新连接返回
	   		  OutInfo.msg("返回结果=" + res);
			}		
			
		}else{  //token为空，没有获取到，提示openapi进程是否存在，并且日志级别是否为INFO。
			res = "Get TestServer Token failed Please confirm OpenapiService is exist and log is INFO!";
		}
		
		return res;			
	}
		
	//商户被扫
	public String passvie(String payCode,String key){
		OutInfo.msg("商户被扫获取支付码=" + payCode);
		OutInfo.msg("商户被扫获取key=" + key);
		String res = "error";
		String token = "token";
		
		String tokenPath = BaseLib.getConfigText("tokenPath");
		OutInfo.msg("获取商户被扫测试token路径=" + tokenPath);
		
		String accessKey = BaseLib.getConfigText(key + "AccessKey");
		OutInfo.msg("商户被扫获取accessKey=" + accessKey);
		
		String testCasePath = BaseLib.getConfigText("testCasePath");


		String testCaseName = BaseLib.getConfigText(key  + "CasePassive");		

		testCaseName = testCasePath + testCaseName;
		OutInfo.msg("获取商户被扫测试用例路径=" + testCaseName);
		
		String testUrl = BaseLib.getConfigText("testUrlPassive");
		OutInfo.msg("获取商户被扫测试服务器URL=" + testUrl);
		
		String requestNum = GetRequestNum.getDate();
		OutInfo.msg("获取商户被扫流水号=" + requestNum);
		
		String json = ReadCustomerPassiveCase.getFileContentByJson(testCaseName, requestNum, payCode);
		OutInfo.msg("获取商户被扫json=" + json);
		
		OutInfo.msg("获取商户被扫第一次向服务器发起请=");
		
		String onePost = sq.doPostToOpenapi(testUrl, accessKey, json, token);
		OutInfo.msg("商户被扫第一次请求返回结果=" + onePost);
		
		token = GetToken.getTestToken(tokenPath);
		OutInfo.msg("获取商户被扫token=" + token);
		if((token != null) && (token.trim() != "" )){
			OutInfo.msg("获取商户被扫第二次向服务器请求=");
			String Url = BaseLib.getConfigText(key + "UrlPassive");
			OutInfo.msg("获取商户被扫第二次向服务器地址=" + Url);			
			res = sq.doPostToOpenapi(Url, accessKey, json, token);
			OutInfo.msg("获取商户被扫第二次向服务器请求返回结果=" + res);
		}else{
			
			res = "Get TestServer Token failed，Please confirm OpenapiService is exist and logger is INFO!";
		}
			
		
	
		
		return res;
	}

	//商户退款
	public String customerRefund(String key, String customerNum, String shopNum, String requestNum){
		
		String res = "error";//默认值，一旦结果显示error，表示该方法出错
		String token = "testtoken"; //token默认值		

		String testUrl = BaseLib.getConfigText("testUrlCustomerRefund");//获取测试服务器地址
		OutInfo.msg("==获取测试服务器URL:=" + testUrl);		
		
		String accessKey = BaseLib.getConfigText(key + "AccessKey"); //获取测试服务器AccessKey
		OutInfo.msg("==获取" + key + "accessKey:=" + accessKey);	
		
		String json = CreateJson.customerRefundJson(customerNum, shopNum, requestNum);
		OutInfo.msg("商户退款json=" + json);
		
		//第一次向测试服务器发起请求，获取token
		String onePost ="error";
		onePost = sq.doPostToOpenapi(testUrl,accessKey,json,token);//向测试服务器发起请求，生成token		
		OutInfo.msg("==第一次请求返回结果==" + onePost);
	
		String tokenPath = BaseLib.getConfigText("tokenPath"); //获取测试服务器token路径
		OutInfo.msg("==获取tokenPath:=" + tokenPath);		 
		token = GetToken.getTestToken(tokenPath);  //读测试服务器token文件，获取token
	
		
		if((token != null) && (token.trim() != "" )){   //获取到token，如获取到token继续执行，判断是否成功，如果失败，直接返回错误信息
			OutInfo.msg("==获取测试服务器token:=" + token);				
			String Url = BaseLib.getConfigText(key + "UrlCustomerRefund"); //向服务器正式发起请求
			OutInfo.msg("==第二次向服务器发起请求URL:=" + Url);		
			res = sq.doPostToOpenapi(Url,accessKey,json,token);  //把url，key，json，token一起做post请求，和工具postman效果一直
			OutInfo.msg("商户退款返回结果=" + res);
			
		}else{  //token为空，没有获取到，提示openapi进程是否存在，并且日志级别是否为INFO。
			res = "Get TestServer Token failed Please confirm OpenapiService is exist and log is INFO!";
		}
		
		return res;
	}
	
	//商户部分退款
	public String customerPartRefund(String key, String customerNum, String shopNum, String requestNum){
		String res = "error";//默认值，一旦结果显示error，表示该方法出错
		String token = "testtoken"; //token默认值	
		String refundPartAmount = "0.01";  //部分退款金额

		String testUrl = BaseLib.getConfigText("testUrlCustomerPartRefund");//获取测试服务器地址
		OutInfo.msg("==获取测试服务器URL:=" + testUrl);		
		
		String accessKey = BaseLib.getConfigText(key + "AccessKey"); //获取测试服务器AccessKey
		OutInfo.msg("==获取" + key + "accessKey:=" + accessKey);	
		
		String json = CreateJson.customerPartRefundJson(customerNum, shopNum, requestNum, refundPartAmount);
		OutInfo.msg("商户部分退款json=" + json);
		
		//第一次向测试服务器发起请求，获取token
		String onePost ="error";
		onePost = sq.doPostToOpenapi(testUrl,accessKey,json,token);//向测试服务器发起请求，生成token		
		OutInfo.msg("==第一次请求返回结果==" + onePost);
	
		String tokenPath = BaseLib.getConfigText("tokenPath"); //获取测试服务器token路径
		OutInfo.msg("==获取tokenPath:=" + tokenPath);		 
		token = GetToken.getTestToken(tokenPath);  //读测试服务器token文件，获取token
	
		
		if((token != null) && (token.trim() != "" )){   //获取到token，如获取到token继续执行，判断是否成功，如果失败，直接返回错误信息
			OutInfo.msg("==获取测试服务器token:=" + token);				
			String Url = BaseLib.getConfigText(key + "UrlCustomerPartRefund"); //向服务器正式发起请求
			OutInfo.msg("==第二次向服务器发起请求URL:=" + Url);		
			res = sq.doPostToOpenapi(Url,accessKey,json,token);  //把url，key，json，token一起做post请求，和工具postman效果一直
			OutInfo.msg("商户部分退款返回结果=" + res);
			
		}else{  //token为空，没有获取到，提示openapi进程是否存在，并且日志级别是否为INFO。
			res = "Get TestServer Token failed Please confirm OpenapiService is exist and log is INFO!";
		}
		
		return res;
	}
	
	//代理商主扫

	public String agent(String key, String amount){

		
		String res = "time out";	   
		String token = "testtoken";
		
		String testUrl = BaseLib.getConfigText("testUrlAgent");
		OutInfo.msg("==代理商主扫测试URL:=" + testUrl);		
		
		String accessKey = BaseLib.getConfigText( key + "AccessKey");
		OutInfo.msg("==获取代理商主扫accessKey:=" + accessKey);		
		
		String testCasePath = BaseLib.getConfigText("testCasePath");		
		OutInfo.msg("==获取代理商主扫测试用例路径:=" + testCasePath);
		
		String testCaseName = BaseLib.getConfigText(key + "CaseAgent");	
		testCaseName = testCasePath + testCaseName;
		OutInfo.msg("==获取代理商主扫测试用例名称:=" + testCaseName);
		
		String requestNum = GetRequestNum.getDate();
		OutInfo.msg("==获取交易流水号:=" + requestNum);		
		
		String json = ReadAgentCase.getFileContentByJson(testCaseName, requestNum, amount);
		OutInfo.msg("==请求JSON串:" + json);
		
		OutInfo.msg("==准备请求测试服务器获取token==");		
		
		String onePost ="time out ";
		onePost = sq.doPostToOpenapi(testUrl,accessKey,json,token);		
		OutInfo.msg("==代理商主扫第一次请求返回结果==" + onePost);
		 
		String tokenPath = BaseLib.getConfigText("tokenPath");
		OutInfo.msg("==代理商主扫获取tokenPath:=" + tokenPath);		 
		token = GetToken.getTestToken(tokenPath);	
		
		if((token != null) && (token.trim() != "" )){
			OutInfo.msg("==代理商主扫获取测试服务器token:=" + token);		 
		
			String Url = BaseLib.getConfigText(key + "UrlAgent");
			OutInfo.msg("==代理商主扫第二次向服务器发起请求URL:=" + Url);		
			res = sq.doPostToOpenapi(Url,accessKey,json,token);
			OutInfo.msg("==代理商主扫创建支付链接返回结果=" + res);
			
			//调试使用，发布后注释
			//res = "{\"data\":{\"url\":\"https://order.duolabao.com/active/c?state=152108041867210989%7C10011015178258181970145%7C0.01%7C15%7CAPI\"},\"result\":\"success\"}";
		    
			
			//如果支付成功，直接返回支付链接
			if(res.indexOf("\"url\":\"https:") != -1){
				String urlTemp[] = res.split("\"url\":\"");
				String urlTemp1[] = urlTemp[1].split("\"},");
				String agentNumCustomerNumAndShopNum = ReadAgentCase.getAgentNumCustomerNumAndShopNum(testCaseName);
		   		OutInfo.msg("获取|agentNum|customerNum|shopNum=" + agentNumCustomerNumAndShopNum);
		   		res = urlTemp1[0] + "=====" + requestNum + agentNumCustomerNumAndShopNum;   		 //把支付新连接返回
		   		OutInfo.msg("返回结果=" + res);
					 
			}	
		}else {
			res = "Get TestServer Token failed，Please confirm OpenapiService is exist and logger is INFO!";
		}
		return res;	
	}
	
	
	//代理商被扫
	public String agentPassive(String payCode,String key){
		OutInfo.msg("代理商被扫获取支付码=" + payCode);
		String res = "error";
		String token = "token";		
		
		String accessKey = BaseLib.getConfigText("testAccessKey");
		OutInfo.msg("代理商被扫获取accessKey=" + accessKey);
		
		String testCasePath = BaseLib.getConfigText("testCasePath");
		String testCaseName = BaseLib.getConfigText(key + "CaseAgentPassive");
		testCaseName = testCasePath + testCaseName;
		OutInfo.msg("获取代理商被扫测试用例路径=" + testCaseName);		

		String testUrl = BaseLib.getConfigText("testUrlAgentPassive");
		OutInfo.msg("获取商户被扫URL=" + testUrl);		

		String requestNum = GetRequestNum.getDate();
		OutInfo.msg("获取商户被扫流水号=" + requestNum);
		
		String json = ReadAgentPassiveCase.getFileContentByJson(testCaseName, requestNum, payCode);
		OutInfo.msg("获取代理商被扫json=" + json);
		
		OutInfo.msg("获取商户被扫第一次向服务器发起请=");
		String onePost = sq.doPostToOpenapi(testUrl, accessKey, json, token);
		OutInfo.msg("代理商被扫第一次请求返回结果=" + onePost);
		String tokenPath = BaseLib.getConfigText("tokenPath");
		
		token = GetToken.getTestToken(tokenPath);
		
		OutInfo.msg("获取代理商被扫token=" + token);
		if((token != null) && (token.trim() != "" )){
			String Url = BaseLib.getConfigText(key + "UrlAgentPassive");
			OutInfo.msg("代理商被扫第二次向服务器请求=");
			res = sq.doPostToOpenapi(Url, accessKey, json, token);
			OutInfo.msg("获取代理商被扫第二次向服务器请求返回结果=" + res);	
		}else{			
			res = "Get TestServer Token failed，Please confirm OpenapiService is exist and logger is INFO!";
		}			
		return res;
	}
	
	//代理商退款
	public String agentRefund(String key, String customerNum, String shopNum, String requestNum, String agentNum){
		String res = "error";//默认值，一旦结果显示error，表示该方法出错
		String token = "testtoken"; //token默认值		

		String testUrl = BaseLib.getConfigText("testUrlAgentRefund");//获取测试服务器地址
		OutInfo.msg("==获取测试服务器URL:=" + testUrl);		
		
		String accessKey = BaseLib.getConfigText(key + "AccessKey"); //获取测试服务器AccessKey
		OutInfo.msg("==获取" + key + "accessKey:=" + accessKey);	
		
		String json = CreateJson.agentRefund(customerNum, shopNum, requestNum,agentNum);
		OutInfo.msg("代理商退款json=" + json);
		
		//第一次向测试服务器发起请求，获取token
		String onePost ="error";
		onePost = sq.doPostToOpenapi(testUrl,accessKey,json,token);//向测试服务器发起请求，生成token		
		OutInfo.msg("==第一次请求返回结果==" + onePost);
			
		String tokenPath = BaseLib.getConfigText("tokenPath"); //获取测试服务器token路径
		OutInfo.msg("==获取tokenPath:=" + tokenPath);		 
		token = GetToken.getTestToken(tokenPath);  //读测试服务器token文件，获取token
		
		if((token != null) && (token.trim() != "" )){   //获取到token，如获取到token继续执行，判断是否成功，如果失败，直接返回错误信息
			OutInfo.msg("==获取测试服务器token:=" + token);				
			String Url = BaseLib.getConfigText(key + "UrlAgentRefund"); //向服务器正式发起请求
			OutInfo.msg("==第二次向服务器发起请求URL:=" + Url);		
			res = sq.doPostToOpenapi(Url,accessKey,json,token);  //把url，key，json，token一起做post请求，和工具postman效果一直
			OutInfo.msg("代理商退款返回结果=" + res);
			
		}else{  //token为空，没有获取到，提示openapi进程是否存在，并且日志级别是否为INFO。
			res = "Get TestServer Token failed Please confirm OpenapiService is exist and log is INFO!";
		}
		return res;
	}
	
	//代理商部分退款
	public String agentPartRefund(String key, String customerNum, String shopNum, String requestNum, String agentNum){
		String res = "error";//默认值，一旦结果显示error，表示该方法出错
		String token = "testtoken"; //token默认值		
		String refundPartAmount = "0.01";

		String testUrl = BaseLib.getConfigText("testUrlPartAgentRefund");//获取测试服务器地址
		OutInfo.msg("==获取测试服务器URL:=" + testUrl);		
		
		String accessKey = BaseLib.getConfigText(key + "AccessKey"); //获取测试服务器AccessKey
		OutInfo.msg("==获取" + key + "accessKey:=" + accessKey);	
		
		String json = CreateJson.agentPartRefund(customerNum, shopNum, requestNum,agentNum,refundPartAmount);
		OutInfo.msg("代理商部分退款json=" + json);
		
		//第一次向测试服务器发起请求，获取token
		String onePost ="error";
		onePost = sq.doPostToOpenapi(testUrl,accessKey,json,token);//向测试服务器发起请求，生成token		
		OutInfo.msg("==第一次请求返回结果==" + onePost);
			
		String tokenPath = BaseLib.getConfigText("tokenPath"); //获取测试服务器token路径
		OutInfo.msg("==获取tokenPath:=" + tokenPath);		 
		token = GetToken.getTestToken(tokenPath);  //读测试服务器token文件，获取token
		
		if((token != null) && (token.trim() != "" )){   //获取到token，如获取到token继续执行，判断是否成功，如果失败，直接返回错误信息
			OutInfo.msg("==获取测试服务器token:=" + token);				
			String Url = BaseLib.getConfigText(key + "UrlPartAgentRefund"); //向服务器正式发起请求
			OutInfo.msg("==第二次向服务器发起请求URL:=" + Url);		
			res = sq.doPostToOpenapi(Url,accessKey,json,token);  //把url，key，json，token一起做post请求，和工具postman效果一直
			OutInfo.msg("代理商部分退款返回结果=" + res);
			
		}else{  //token为空，没有获取到，提示openapi进程是否存在，并且日志级别是否为INFO。
			res = "Get TestServer Token failed Please confirm OpenapiService is exist and log is INFO!";
		}
		return res;
	}
	public static void main(String[] args) {
			}

}

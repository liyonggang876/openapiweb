package openapiautotest.api;


import openapiautotest.baselib.BaseLib;
import openapiautotest.baselib.OutInfo;
import openapiautotest.https.SendReuqest;

public class OpenapiDeclare {
	
	//基础信息查询
	public static String getDeclareBaseInfo(String key, String type, String parm){
		SendReuqest sq = new SendReuqest();
		String res = "error";//默认值，一旦结果显示error，表示该方法出错
		String token = "testtoken"; //token默认值
		
		String testUrl = BaseLib.getConfigText("testUrlAgentDeclare" + type);//获取测试服务器地址
		OutInfo.msg("==获取测试服务器URL:=" + testUrl);
		
		String accessKey = BaseLib.getConfigText(key + "AccessKey"); //获取测试服务器AccessKey
		OutInfo.msg("==获取" + key + "accessKey:=" + accessKey);		
		
		
		
		OutInfo.msg("==准备请求测试服务器获取token==");		
		
		String oneGet = "error";
		oneGet =sq.doGetToOpenapi(testUrl, parm, accessKey, token);
		
		String tokenPath = BaseLib.getConfigText("tokenPath"); //获取测试服务器token路径
		OutInfo.msg("==获取tokenPath:=" + tokenPath);		 
		token = GetToken.getTestToken(tokenPath);  //读测试服务器token文件，获取token
		
		//token= "9D33624244861C4D55E441CB7C1877459EF704EC";  //省份key
		//token= "CBC47B18F3ADE410488109C77898E52E4D823082";   // 城市key 北京
		//token= "3CC05E7C867C5C2906F5C75E8823AB3756D028A5";   //河北
		//token= "36C6A687D31C9ABFEB0BFAF46B8B7172F85A8AF9";  //区域查询 北京
		//token= "8E80D2F26BAEDEBAFE5BF2A31730A4620F067BD5";  //查询行业
		//token= "EAA41A0602CA354DCF0D4F89CFF2AB61C3E802F3";    //二级行业美食查询
		//token= "CE10EA589DAE7EBA1D53A1BB20ED2FC0A6B0D611";  //查询支付银行
		//token= "556AE0785BA49ECD1E5B7596689988389D417679";  //根据关键字查询银行
		//token= "ECA3FBA4C16E1967911C1A1F3207AB84349A8261";  //查询支行
		
		
		OutInfo.msg("==获取测试服务器token:=" + token);				
		String Url = BaseLib.getConfigText(key + "UrlAgentDeclare" + type); //向服务器正式发起请求
		OutInfo.msg("==第二次向服务器发起请求URL:=" + Url);		
		res = sq.doGetToOpenapi(Url, parm, accessKey, token);
		
		OutInfo.msg("基础信息查询第二次向服务器请求返回的结果=" + res);	
		return res;
	}
	
	
	//获取全名
	public static String getFullName(){
		String res = "error";
		String name = BaseLib.getConfigText("fullName");
		long random =  (int)(10000+Math.random()*(10000-1+1));
		name = name + String.valueOf(random) + "超市";
		res = name;
		return res;
	}

	//商户报单
	public static String declareCustomer(String key,String agentNum,String fullName,String shortName,
			String industry,String province,String city,String email,String linkMan,
			String linkPhone,String customerType,String certificateType,String certificateCode,
			String district,String certificateName){
		
		SendReuqest sq = new SendReuqest();
		String res = "error";//默认值，一旦结果显示error，表示该方法出错
		String token = "testtoken"; //token默认值
		

		String testUrl = BaseLib.getConfigText("testUrlAgentDeclareCoustomer");//获取测试服务器地址
		OutInfo.msg("==获取测试服务器URL:=" + testUrl);		
		
		String accessKey = BaseLib.getConfigText(key + "AccessKey"); //获取测试服务器AccessKey
		OutInfo.msg("==获取" + key + "accessKey:=" + accessKey);		
		
		String json = CreateJson.agentDeclareCustomer(agentNum, fullName, shortName, industry, province, city, email, linkMan, linkPhone, customerType, certificateType, certificateCode, district, certificateName);
		
		
		
		
		OutInfo.msg("==请求JSON串:" + json);
		
		
		
		String onePost ="error";
				
		onePost = sq.doPostToOpenapi(testUrl,accessKey,json,token);//向测试服务器发起请求，生成token		
		OutInfo.msg("==第一次请求返回结果==" + onePost);
		
		String tokenPath = BaseLib.getConfigText("tokenPath"); //获取测试服务器token路径
		OutInfo.msg("==获取tokenPath:=" + tokenPath);		 
		token = GetToken.getTestToken(tokenPath);  //读测试服务器token文件，获取token
		token = "C201D998763F323687F5658DDA12CB483F3D9BD2";
		
		if((token != null) && (token.trim() != "" )){   //获取到token，如获取到token继续执行，判断是否成功，如果失败，直接返回错误信息
			OutInfo.msg("==获取测试服务器token:=" + token);				
			String Url = BaseLib.getConfigText(key + "UrlAgentDeclareCoustomer"); //向服务器正式发起请求
			OutInfo.msg("==第二次向服务器发起请求URL:=" + Url);		
			res = sq.doPostToOpenapi(Url,accessKey,json,token);  //把url，key，json，token一起做post请求，和工具postman效果一直
			OutInfo.msg("==代理商报单-商户信息返回结果=" + res);
			
					
			
		}else{  //token为空，没有获取到，提示openapi进程是否存在，并且日志级别是否为INFO。
			res = "Get TestServer Token failed Please confirm OpenapiService is exist and log is INFO!";
		}
		
		return res;		
		
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

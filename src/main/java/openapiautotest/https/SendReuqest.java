package openapiautotest.https;


import openapiautotest.baselib.OutInfo;

public class SendReuqest {
	  
	  //String tempToken = BaseLib.getConfigText("TempToken");
	  String contentType = "application/json;charset=UTF-8";//BaseLib.getConfigText("ContentType");
	  String timestamp = "123123123";//BaseLib.getConfigText("Timestamp");
	  
	  String charset = "utf-8";
	 
	  HttpClientUtil httpU = new HttpClientUtil();	 
	public  String doPostToOpenapi(String testUrl,String accessKey,String json,String token){		  
		 
		  String res = "error";		  
		  //HttpClientUtil httpU = new HttpClientUtil();	    
		  res = httpU.doPost(testUrl, json, charset, accessKey, token, contentType, timestamp);		       
		
		return res;
	}
	
	public  String doGetToOpenapi(String testUrl,String request,String accessKey,String token){		  
		 
		  String res = "error";		  
		  //HttpClientUtil httpU = new HttpClientUtil();	    
		  res = httpU.doGet(testUrl, request, accessKey, token);    
		
		return res;
	}
	
	public String payCompleteMessagedoGet(String url , String resquestData,String accessKey,String token){
		String res = "error";
		OutInfo.msg("url=");
		res = httpU.doGet(url, resquestData,accessKey,token);
		return res;
		
	}

}

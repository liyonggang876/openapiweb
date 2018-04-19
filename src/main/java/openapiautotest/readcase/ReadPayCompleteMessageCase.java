package openapiautotest.readcase;

import openapiautotest.baselib.BaseLib;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;




public class ReadPayCompleteMessageCase {
	public static String getFileContentByJson(String file){
		String res = null;
		StringBuffer sb = new StringBuffer();
		BufferedReader reader = null;
	      try {	          
	          //reader = new BufferedReader(new FileReader(file));
	          reader=new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8")); 
	    	  //reader = new BufferedReader((new FileInputStream(testCasePath),"UTF-8"));
	          String tempString = null;
	          int line = 1;
		          // 一次读入一行，直到读入null为文件结束
	              tempString = reader.readLine();
		          while ((tempString = reader.readLine()) != null) {
		              // 显示行号
		        	  //if(line == 1) continue; 
		        	  //tempString =  (new String(tempString.getBytes("ISO-8859-1") ,"gbk") + "\t") ; 
		        	  //Out.message(tempString);
		        	  tempString = tempString.replace(" ", "%20");
		        	  String tmp [] = tempString.split(BaseLib.getConfigText("TestCaseSpilt"));
		        	  //Out.message("tmp[1]=======" + tmp[1]);
		        	  //String temp = "%20";
		        	  
		        	  sb.append("requestNum=");			sb.append(tmp[2]); 		sb.append("&");
		        	  sb.append("orderNum="); 			sb.append(tmp[3]);		sb.append("&");
		        	  sb.append("orderAmount="); 		sb.append(tmp[4]);		sb.append("&");		
		        	  sb.append("status=");				sb.append(tmp[5]);		sb.append("&");	
		        	  sb.append("completeTime=");	  	sb.append(tmp[6]);		sb.append("&");			
		        	  sb.append("extraInfo=");  		sb.append(tmp[7]);	
		        	  res =sb.toString();
		        	  
		        	  //Out.message(res);
		        	  /*
		        	  json = "{";
		        	  json = json + "\"customerNum\":" + "\"" +tmp[2] + "\",";
		        	  json = json + "\"shopNum\":" + "\"" + tmp[3] + "\",";
		        	  json = json + "\"machineNum\":" + "\"" + tmp[4] + "\",";
		        	  json = json + "\"requestNum\":" + "\"" + requestNum + "\",";
		        	  json = json + "\"amount\":" + "\"" + tmp[6] + "\",";		        	  
		        	  json = json + "\"source\":" + "\"" + tmp[7] + "\",";
		        	  json = json + "\"tableNum\":" + "\"" + tmp[8] + "\",";
		        	  json = json + "\"callbackUrl\":" + "\"" + tmp[9] + "\",";
		        	  json = json + "\"extraInfo\":" + "\"" + tmp[10] + "\",";
		        	  json = json + "\"completeUrl\":" + "\"" + tmp[11]+ "\"";;
		        	  json = json + "}";
		        	  //Out.message("json=" + json);
		        	  
		        	  //String json1 =\"callbackUrl\":\"openapi.duolabao.test\",\"extraInfo\":\"111111\",\"completeUrl\":\"https://openapi.duolabao.te\"}";
		        	  //json = "{}"
		        	  res = httpU.doPost(url, json, charset, accessKey, token, contentType, timestamp);
		        	  //res = "{\"data\":{\"url\":\"https://order.duolabao.cn/active/c?state=151488570550812831%7C10011015143462447380331%7C0.01%7C15%7CAPI\"},\"result\":\"success1\"}";
		        	  
		        	  //开始执行测试用例
		        	  if(key.equals("two")){
		        		  String restmp[] = res.split("\"result\":\"");
		        		  String restmp1[] = restmp[1].split("\"");
		        		  //Out.message("返回结果：" + restmp1[0]);		        	 		        			  
		        		  BaseLib.newAssertEquals( tmp[0], tmp[12], restmp1[0], BaseLib.getMethodName(), url);
		        		  if(res.indexOf("\"url\":\"https:") != -1){
		        			  String urlTemp[] = res.split("\"url\":\"");
			        		  String urlTemp1[] = urlTemp[1].split("\"},");
			        		  payUrl = urlTemp1[0];
			        		  //Out.message("获取支付链接" + urlTemp1[0]);
		        		  }else{
		        			  payUrl = res;
		        		  }		        		  
		        		  
		        	  }
		              //System.out.println("line " + line + ": " + tempString);
		        	  //Out.message("返回结果：=" + res);
		              line++;
		              */
		          }
	          reader.close();
	          } catch (IOException e) {
	            e.printStackTrace();
	          } finally {
	            if (reader != null) {
	                try {
	                    reader.close();
	                } catch (IOException e1) {
	                }
	            }
	        
	        
    	  }
		return res;
		
	}

}

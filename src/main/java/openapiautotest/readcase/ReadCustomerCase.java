package openapiautotest.readcase;

import openapiautotest.baselib.BaseLib;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;






public class ReadCustomerCase {
	//读取商户主扫测试用例
	public static String getFileContentByJson(String file,String requestNum, String amount){
		String res = "error";
		StringBuffer sb = new StringBuffer();
		BufferedReader reader = null;
	      try {	      
	          
	          reader=new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8")); 
	          String tempString = null;
	          
		          // 一次读入一行，直到读入null为文件结束
	              tempString = reader.readLine();   //先读一行，不做处理，因为第一个为头信息
		          while ((tempString = reader.readLine()) != null) {		            
		        	  String tmp [] = tempString.split(BaseLib.getConfigText("TestCaseSpilt"));  //用分隔符进行分割处理
		        	 
		        	  //拼接成指定格式的json
		        	  sb.append("{\"customerNum\":"); 	sb.append("\"");	sb.append(tmp[2]); 		sb.append("\"");	sb.append(",");
		        	  sb.append("\"shopNum\":"); 		sb.append("\"");	sb.append(tmp[3]);		sb.append("\"");	sb.append(",");
		        	  sb.append("\"machineNum\":"); 	sb.append("\"");	sb.append(tmp[4]);		sb.append("\"");	sb.append(",");
		        	  sb.append("\"requestNum\":");		sb.append("\"");	sb.append(requestNum);	sb.append("\"");	sb.append(",");
		        	  sb.append("\"amount\":");	  		sb.append("\"");	sb.append(amount);		sb.append("\"");	sb.append(",");
		        	  sb.append("\"tableNum\":");  		sb.append("\"");	sb.append(tmp[8]);		sb.append("\"");	sb.append(",");
		        	  sb.append("\"source\":");  		sb.append("\"");	sb.append(tmp[7]);		sb.append("\"");	sb.append(",");
		        	  sb.append("\"callbackUrl\":");	sb.append("\"");	sb.append(tmp[9]);		sb.append("\"");	sb.append(",");
		        	  sb.append("\"extraInfo\":");		sb.append("\"");	sb.append(tmp[10]);		sb.append("\"");	sb.append(",");
		        	  sb.append("\"completeUrl\":");	sb.append("\"");	sb.append(tmp[11]);		sb.append("\"}");
		        	  res =sb.toString();
		        	 
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
	
	public static String getCustomerNumAndShopNum(String file){
		String res = "error";
		StringBuffer sb = new StringBuffer();
		BufferedReader reader = null;
	      try {	      
	          
	          reader=new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8")); 
	          String tempString = null;
	          
		          // 一次读入一行，直到读入null为文件结束
	              tempString = reader.readLine();   //先读一行，不做处理，因为第一个为头信息
		          while ((tempString = reader.readLine()) != null) {		            
		        	  String tmp [] = tempString.split(BaseLib.getConfigText("TestCaseSpilt"));  //用分隔符进行分割处理
		        	 
		        	  //获取customernum和shopnum，通过读文件
		        	 sb.append("|");	sb.append(tmp[2]);
		        	 sb.append("|");	sb.append(tmp[3]);
		             res =sb.toString();		        	 
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
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		System.out.println(ReadCustomerCase.getCustomerNumAndShopNum("D:\\tools\\tomcat7\\webapps\\openapi_auto_test.web-1.0-SNAPSHOT\\WEB-INF\\classes\\TestCase\\testCaseCustomer.csv"));

	}

}

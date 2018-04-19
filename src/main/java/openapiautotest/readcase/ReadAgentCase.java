package openapiautotest.readcase;

import openapiautotest.baselib.BaseLib;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;




public class ReadAgentCase {
	public static String getFileContentByJson(String file,String requestNum, String amount){
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
		        	  String tmp [] = tempString.split(BaseLib.getConfigText("TestCaseSpilt"));
		        	  //Out.message("tmp[1]=======" + tmp[1]);
		        	  sb.append("{\"agentNum\":"); 		sb.append("\"");	sb.append(tmp[2]); 		sb.append("\"");	sb.append(",");
		        	  sb.append("\"customerNum\":"); 	sb.append("\"");	sb.append(tmp[3]); 		sb.append("\"");	sb.append(",");
		        	  sb.append("\"shopNum\":"); 		sb.append("\"");	sb.append(tmp[4]);		sb.append("\"");	sb.append(",");
		        	  sb.append("\"machineNum\":"); 	sb.append("\"");	sb.append(tmp[5]);		sb.append("\"");	sb.append(",");
		        	  sb.append("\"requestNum\":");		sb.append("\"");	sb.append(requestNum);	sb.append("\"");	sb.append(",");
		        	  sb.append("\"amount\":");	  		sb.append("\"");	sb.append(amount);		sb.append("\"");	sb.append(",");
		        	  sb.append("\"tableNum\":");  		sb.append("\"");	sb.append(tmp[9]);		sb.append("\"");	sb.append(",");
		        	  sb.append("\"source\":");  		sb.append("\"");	sb.append(tmp[8]);		sb.append("\"");	sb.append(",");
		        	  sb.append("\"callbackUrl\":");	sb.append("\"");	sb.append(tmp[10]);		sb.append("\"");	sb.append(",");
		        	  sb.append("\"extraInfo\":");		sb.append("\"");	sb.append(tmp[11]);		sb.append("\"");	sb.append(",");
		        	  sb.append("\"completeUrl\":");	sb.append("\"");	sb.append(tmp[12]);		sb.append("\"}");
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

	public static String getAgentNumCustomerNumAndShopNum(String file){
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
		        	 sb.append("|");	sb.append(tmp[4]);
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

	public static String getAgentNum(String file){
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
		        	sb.append(tmp[2]);
		        	
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
	
	
}

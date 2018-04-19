package openapiautotest.readcase;

import openapiautotest.baselib.BaseLib;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;




public class ReadCustomerPassiveCase {
	public static String getFileContentByJson(String file,String requestNum,String payCode){
		String res = null;
		StringBuffer sb = new StringBuffer();
		BufferedReader reader = null;
	      try {	          
	         
	          reader=new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8")); 	    	  
	          String tempString = null;
	          int line = 1;
		          // 一次读入一行，直到读入null为文件结束
	              tempString = reader.readLine();
		          while ((tempString = reader.readLine()) != null) {
		             
		        	  String tmp [] = tempString.split(BaseLib.getConfigText("TestCaseSpilt"));
		        	  //Out.message("tmp[1]=======" + tmp[1]);
		        	  
		        	  sb.append("{\"customerNum\":"); 	sb.append("\"");	sb.append(tmp[2]); 		sb.append("\"");	sb.append(",");
		        	  sb.append("\"authCode\":"); 		sb.append("\"");	sb.append(payCode);		sb.append("\"");	sb.append(",");
		        	  sb.append("\"machineNum\":"); 	sb.append("\"");	sb.append(tmp[4]);		sb.append("\"");	sb.append(",");
		        	  sb.append("\"shopNum\":"); 		sb.append("\"");	sb.append(tmp[5]);		sb.append("\"");	sb.append(",");		        	  
		        	  sb.append("\"requestNum\":");		sb.append("\"");	sb.append(requestNum);	sb.append("\"");	sb.append(",");
		        	  sb.append("\"amount\":");	  		sb.append("\"");	sb.append(tmp[7]);		sb.append("\"");	sb.append(",");
		        	  sb.append("\"source\":");  		sb.append("\"");	sb.append(tmp[8]);		sb.append("\"");	sb.append(",");
		        	  sb.append("\"tableNum\":");  		sb.append("\"");	sb.append(tmp[9]);		sb.append("\"");	sb.append("}");        	 
		        	 
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

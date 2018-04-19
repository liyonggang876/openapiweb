package openapiautotest.api;

import openapiautotest.baselib.BaseLib;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;




public class GetToken {
	public static String getTestToken(String tokenPath) { 		 
		 String filePath = tokenPath;//BaseLib.getConfigText("TokenPath");
		 String charset = "utf-8";
		 String tokenSpilt = BaseLib.getConfigText("TokenSpilt");
		 String res = null;
		 
		 RandomAccessFile rf = null;  
	        try {  
	            rf = new RandomAccessFile(filePath, "r");  
	            long len = rf.length();  
	            long start = rf.getFilePointer();  
	            long nextend = start + len - 1;  
	            String line;  
	            rf.seek(nextend);  
	            int c = -1;  
	            while (nextend > start) {  
	                c = rf.read();  
	                if (c == '\n' || c == '\r') {  
	                    line = rf.readLine();  
	                    if (line != null) {  
	                    	if(line.indexOf(tokenSpilt)!=-1){
	                    		
	                    		String tmp[] = line.split(tokenSpilt);	                    		
	                    		//Out.message("获取的token=" + tmp[1]);
	                    		res = tmp[1];
	                    		return res;
	                    		
	                    	}
	                        //System.out.println(new String(line.getBytes("ISO-8859-1"), charset));  
	                    } else {  
	                        //System.out.println(line);  
	                    }  
	                    nextend--;  
	                }  
	                nextend--;  
	                rf.seek(nextend);  
	                if (nextend == 0) { 
	                    System.out.println(new String(rf.readLine().getBytes(  
	                            "ISO-8859-1"), charset));  
	                }  
	            }  
	        } catch (FileNotFoundException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        } finally {  
	            try {  
	                if (rf != null)  
	                    rf.close();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	        return res;
	    }  

}

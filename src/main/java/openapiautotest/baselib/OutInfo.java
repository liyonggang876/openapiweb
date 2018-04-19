package openapiautotest.baselib;

import org.apache.log4j.Logger;

public class OutInfo {
	public static void msg(String msg){
		//String message = BaseLib.getConfigText("message");
		//if(message.indexOf("true") !=-1){
		boolean bl = true;
		if(bl){
			
			OutLog.getLog(msg);
		}			
		
	}
	public static void main(String args[]){
	
	}

}

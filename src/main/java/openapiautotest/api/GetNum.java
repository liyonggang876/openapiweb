package openapiautotest.api;

public class GetNum {
	public static String getCustomerNumAndShopNum(String string, String spitle, int key){
		 String res = "error";
		// try {
		  //  int a = Integer.parseInt(key);
		   
			//if(string.indexOf(key) != -1){
				String temp [] = string.split(spitle);
				res = temp[key];
			//}
		//} catch (NumberFormatException e) {
		   // e.printStackTrace();
		//}
		
		return res;
	}
	
	public static String getPayLinkByInfo(String string){
		String res = "error";
		String temp[] = string.split("=====");
		res = temp[0];
		return res;
	}
	
	public static String getNumsByInfo(String string){
		String res = "error";
		String temp[] = string.split("=====");
		res = temp[1];
		return res;
	}
}

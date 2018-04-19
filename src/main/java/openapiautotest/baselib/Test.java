package openapiautotest.baselib;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;



public class Test {
	public static void main(String args[]){
		//String aa = BaseLib.getConfigText("aaa");
		
		//System.out.println(aa);
		//String aaa = "https://order.duolabao.com/active/c?state=152108041867210989%7C10011015178258181970145%7C0.01%7C15%7CAPI===152109663606111334|1.00011E+22|1.00012E+22";
		//aaa = "152109725865118708|1.00011E+22|1.00012E+22";
		//String b  = GetNum.getPayLinkByInfo(aaa);
		//b = GetNum.getCustomerNumAndShopNum(aaa, "\\|", 0);
		//System.out.println("bbb=" + b);
		
		 String str = "测试字符转换 hello word"; //默认环境，已是UTF-8编码  
	        try {  
	            String strGBK = URLEncoder.encode(str, "GBK");  
	            System.out.println(strGBK);  
	            String strUTF8 = URLDecoder.decode(str, "UTF-8");  
	            System.out.println(strUTF8);  
	        } catch (UnsupportedEncodingException e) {  
	            e.printStackTrace();  
	        }  
  
        System.out.println(str);  
		
	}
}

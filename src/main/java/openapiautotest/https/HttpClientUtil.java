package openapiautotest.https;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;


public class HttpClientUtil {  
     
    	public String doPost(String url, String json, String charset, String accessKey, String token, String ContentType, String timestamp) {  
            HttpClient httpClient = null;  
            HttpPost httpPost = null;  
            String result = null;  
            String APPLICATION_JSON = "application/json";            
            String CONTENT_TYPE_TEXT_JSON = "text/json";
            
            try {  
                httpClient = new SSLClient();  
                httpPost = new HttpPost(url);  
                httpPost.addHeader("accessKey", accessKey);
                httpPost.addHeader("token", token);
                httpPost.addHeader("Content-Type", ContentType);
                httpPost.addHeader("timestamp", timestamp);
              
                
                
                httpPost.addHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON);
                //String encoderJson = URLEncoder.encode(json, HTTP.UTF_8);
                
                
                
                StringEntity se = new StringEntity(json);
                se.setContentType(CONTENT_TYPE_TEXT_JSON);
               // se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON));
                httpPost.setEntity(se);
                HttpResponse response = httpClient.execute(httpPost);  
                if (response != null) {  
                    HttpEntity resEntity = response.getEntity();  
                    if (resEntity != null) {  
                        result = EntityUtils.toString(resEntity, charset);  
                    }  
                }  
            } catch (Exception ex) {  
                ex.printStackTrace();  
            }  
            return result;  
            
      }
	
    
    
    //public String doGet(String url,String charset, String accessKey, String token, String ContentType, String timestamp){  
    	public String doGet(String url,String request,String accessKey,String token){ 
       
    		
        HttpClient httpClient = null;  
        HttpGet httpGet= null;  
        String result = null;  
        url = url + request;
          
        try {  
            httpClient = new SSLClient();  
            httpGet = new HttpGet(url);  
            httpGet.addHeader("accessKey", accessKey);
            httpGet.addHeader("token", token);
            //httpGet.addHeader("Content-Type", ContentType);
            httpGet.addHeader("timestamp", "121212");
            HttpResponse response = httpClient.execute(httpGet);  
            if(response != null){  
                HttpEntity resEntity = response.getEntity();  
                if(resEntity != null){  
                    result = EntityUtils.toString(resEntity,"utf-8");  
                }  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
          
        return result;  
    }  
    	public static void main(String args[]){
    		HttpClientUtil hu = new HttpClientUtil();
    		String url = "https://openapi.duolabao.test?requestNum=151738776302217086&orderNum=10021015173877668191008&orderAmount=0.01&status=SUCCESS&completeTime=2018-01-31 16:36:12&extraInfo=test";
    		       //url = "https://openapi.duolabao.test?requestNum=2014072300007148&orderNum=10001214641783052104486&status=SUCCESS&completeTime=2016-04-03 17:27:10&orderAmount=0.01&extraInfo=wwww";
    		       //url = "https://openapi.duolabao.test/?requestNum=151738776302217086&orderNum=10021015173877668191008&orderAmount=0.01&status=SUCCESS&completeTime=2018-01-31%2016:36:12&extraInfo=test";
    		     //  try {
					//url = new String(url.getBytes("iso-8859-1"),"utf-8");
				//} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
				//	e.printStackTrace();
				//}
    		    
    		      System.out.println(url);
    		       String request = "";
    		String accessKey = "39b594114c14443c9e200fa13520e1adf2d06eb2";
    		String token = "347AA8452139F077DD9FAF8EECA36F8D861D6229";
    		//String res = hu.doGet(url, request, accessKey, token);
    		//OutInfo.msg(res);
    		String s = "my.test.txt";
    		System.out.println(s.replace(".", "#"));
    		System.out.println(s.replaceAll(".", "#"));
    		System.out.println(s.replaceFirst(".", "#"));
    	}
    
}  
package openapiautotest.api;
import java.util.Map;




public class ParseJson {
	/*public static void normalParse(String jsonString){
        JSONObject jsonObject = new JSONObject(jsonString);
        //获取普通属性
        System.out.println("customerNum:");
        System.out.println("  " + jsonObject.getString("data"));
        //获取数组
        System.out.println("粉丝:");
        for (Object fan : jsonObject.getJSONArray("fans")) {
            JSONObject object = (JSONObject)fan;
            System.out.println("  姓名:" + object.get("name") + ",年龄:" + object.get("age"));
        }
	}*/
	public static void main(String[] args) {
      //  String jsonString = "{\"fans\":[{\"name\":\"小王\",\"age\":7},{\"name\":\"小尼玛\",\"age\":10}],\"name\":\"王尼玛\"}";
       // normalParse(jsonString);
      //  beanParse(jsonString);
        String res = "{\"data\": {\"customerNum\": \"10001114748070341320175\"},\"result\": \"success\"}";	
    	//ParseJson.normalParse(res);
		res = "{\"data\": {\"customerNum\": \"10001114748070341320175\"},\"result\": \"success\"}";	
        String urlTemp[] = res.split("\"");  //用'"url"'进行第一次分割
   		
   		res = urlTemp[3] + urlTemp[5];
   	 System.out.println(res);
    }
	
    
    //org.json并不支持这种复杂的bean转换,所以这边又导入了gson的包
  
   
}

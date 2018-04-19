package openapiautotest.json;
import java.util.Map;



public class DemoParseJson {
	/*public static void main(String[] args) {
        String jsonString = "{\"fans\":[{\"name\":\"小王\",\"age\":7},{\"name\":\"小尼玛\",\"age\":10}],\"name\":\"王尼玛\"}";
        normalParse(jsonString);
        beanParse(jsonString);
    }
    static void normalParse(String jsonString){
        JSONObject jsonObject = new JSONObject(jsonString);
        //获取普通属性
        System.out.println("姓名:");
        System.out.println("  " + jsonObject.getString("name"));
        //获取数组
        System.out.println("粉丝:");
        for (Object fan : jsonObject.getJSONArray("fans")) {
            JSONObject object = (JSONObject)fan;
            System.out.println("  姓名:" + object.get("name") + ",年龄:" + object.get("age"));
        }
    }
    //org.json并不支持这种复杂的bean转换,所以这边又导入了gson的包
    static void beanParse(String jsonString){
        System.out.println("=========Gson解析=========");
        JsonObject obj = new JsonParser().parse(jsonString).getAsJsonObject();
        Actor actor = new Gson().fromJson(obj,Actor.class);
        System.out.println("姓名:");
        System.out.println("  " + obj.get("name"));
        System.out.println("粉丝:");
        for (Map map : actor.getFans()) {
            System.out.println("  姓名:" + map.get("name") + "年龄:" + map.get("age"));
        }
    }*/
}

package openapiautotest.json;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

public class DemoCreateJson {

	 public static void main(String[] args) {
	        StringCreateJson();
	        mapCreateJson();
	        beanCreateJson();
	    }
	    //String创建json
	    /**
	     * {
	     　　　　　　"name":"王尼玛",
	     　　　　　　"fans":[{
	     　　　　　　　　　　　　"name":"小王",
	     　　　　　　　　　　　　"age":"7"
	     　　　　　　　　　　　},{
	     　　　　　　　　　　　　"name":"小尼玛",
	     　　　　　　　　　　　　"age":"10"
	     　　　　　　　　　　　}]
	     　　　　　　}
	     */
	    static void StringCreateJson(){
	        JSONObject jsonObject = new JSONObject();
	        jsonObject.put("name","王尼玛");

	        //粉丝是个数组,其实就是嵌套json
	        JSONObject jsonObject1 = new JSONObject();
	        jsonObject1.put("name","小王");
	        jsonObject1.put("age",7);

	        JSONObject jsonObject2 = new JSONObject();
	        jsonObject2.put("name","小尼玛");
	        jsonObject2.put("age",10);

	        //从此处可以看出其实list和json也是互相转换的
	        List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
	        jsonObjects.add(jsonObject1);
	        jsonObjects.add(jsonObject2);
	        jsonObject.put("fans",jsonObjects);

	        System.out.println("jsonObject直接创建json:" + jsonObject);
	    }
	    //第二种方法,用map方式
	    static void mapCreateJson(){
	        Map<String,Object> map = new HashMap<String,Object>();
	        map.put("name","王尼玛");
	        Map<String,Object> map1 = new HashMap<String,Object>();
	        map1.put("name","小王");
	        map1.put("age",7);
	        Map<String,Object> map2 = new HashMap<String,Object>();
	        map2.put("name","小尼玛");
	        map2.put("age",10);
	        List<Map> jsonObjects = new ArrayList<Map>();
	        jsonObjects.add(map1);
	        jsonObjects.add(map2);
	        map.put("fans",jsonObjects);
	        System.out.println("集合中Map创建json对象:" + new JSONObject(map));
	    }
	    //第三种,也是比较常用的,用bean转换,(这里用的是map作为子json,如果必须要创建复杂bean对象,建议用Gjson操作)
	    static void beanCreateJson(){
	        Actor actor = new Actor();
	        actor.setName("王尼玛");
	        Map<String,Object> map1 = new HashMap<String,Object>();
	        map1.put("name","小王");
	        map1.put("age",7);
	        Map<String,Object> map2 = new HashMap<String,Object>();
	        map2.put("name","小尼玛");
	        map2.put("age",10);
	        List<Map> maps = new ArrayList<Map>();
	        maps.add(map1);
	        maps.add(map2);
	        actor.setFans(maps);
	        System.out.println("java bean创建json对象:" + new JSONObject(actor));
	    }

}

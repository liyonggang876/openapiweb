package openapiautotest.baselib;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.*;






public class BaseLib {

	

	public static String SeleniumBaseLibLog;

	public static void newSleep(int p_time){
		
		try {
			Thread.sleep(p_time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static String getCurrentTime() throws Exception {

		Calendar ca = Calendar.getInstance();
		int year = ca.get(Calendar.YEAR);// 获取年份
		int month = ca.get(Calendar.MONTH);// 获取月份
		int day = ca.get(Calendar.DATE);// 获取日
		int minute = ca.get(Calendar.MINUTE);// 分
		int hour = ca.get(Calendar.HOUR);// 小时
		int second = ca.get(Calendar.SECOND);// 秒
		return (String.valueOf(year) + "-" + String.valueOf(month + 1) + "-"
				+ String.valueOf(day) + "-" + String.valueOf(hour) + "-"
				+ String.valueOf(minute) + "-" + String.valueOf(second));

	}
 
 
	public static String encodeISOtoutf(String key){
		String res = "error";
		try {
			res=new String(key.getBytes("ISO-8859-1"),"utf-8");
			//System.out.println(resultName);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	
	public static String getConfigText(String key) {		
		//读取配置文件的key，获取key的值
		//URL url = BaseLib.class.getClassLoader().getResource("/config.properties");
		String filepath = getCurrentDir() + "config.properties";
		File file= new File(filepath);		
		if (file.exists()) {		  
			  InputStream inputstream;
			try {
				inputstream = new FileInputStream(file);
				 Properties properties = new Properties();
				  try {
					properties.load(inputstream);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  
				 OutInfo.msg("获取配置文件properties下的:"+key+"="+encodeISOtoutf(properties.getProperty(key))+ "成功！");				  
				  
				  	if (key == null || key.equals("") || key.equals("null")) {
			            return "";
			        }
			        String result = "";
			        try {
			            result = properties.getProperty(key);        //取key值
			        } catch (MissingResourceException e) {
			            e.printStackTrace();
			        }
			        return result=encodeISOtoutf(result);
				  
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}		 
		  
		}else{
			
			OutInfo.msg("获取配置文件properties下的"+key+"失败！");
			return null;
		}
		
	}
		
	public static void theadTime(){
		String time = getConfigText("sleepime");
		long l = Long.parseLong(time);
		try {
			Thread.sleep(l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	public static String getMethodName() {  
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();  
        StackTraceElement e = stacktrace[2];  
        String methodName = e.getMethodName();  
        return methodName;  
    }


	/*public static String getCreatLastFileName(String path){
		String res = null;
		File file=new File(path);
		//列出该目录下所有文件和文件夹
		File[] files = file.listFiles();
		//按照文件最后修改日期倒序排序
		Arrays.sort(files, new Comparator<File>() {
		   @Override
		   public int compare(File file1, File file2) {
		      return (int)(file2.lastModified()-file1.lastModified());
		   }
		});
		//取出第一个(即最新修改的)文件，打印文件名
		res = files[0].getName();
		System.out.println(files[0].getName());
		return res;
		
	}*/
	
	public static String getCurrentDir(){
		String res = null;
		URL url = BaseLib.class.getClassLoader().getResource("");
		res = url.getFile();
		return res;
	}
	
	public static String getBaseUrl(){
		String res = null;
		String tem[] = getCurrentDir().split("WEB-INF");
		res = tem[0];		
		return res;
	}
	
	public static String getPorPaht() throws IOException{
		 File directory = new File("");// 参数为空
         String courseFile = directory.getCanonicalPath();
         System.out.println(courseFile);
         return courseFile;

	}
	
	public static String getIP(){
		String ip = "error";
		InetAddress address = null;
		try {
			address = InetAddress.getLocalHost();
			ip=address .getHostAddress().toString(); 
			String tmp [] = ip.split("\\.");
			ip = tmp[3];
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
	    
		return ip;
	}
	
	public static int getIntFromString(String str){
		int res = -1;
		res = Integer.parseInt(str);
		return res;
	} 
	


	public static void main(String[] args) throws Exception{		
  
	}
	
}




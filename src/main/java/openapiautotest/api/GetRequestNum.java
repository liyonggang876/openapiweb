package openapiautotest.api;

import java.sql.Date;
import java.text.SimpleDateFormat;






public class GetRequestNum {
	
		public static String getDate(){
			String res = null;
			long currentDate = System.currentTimeMillis();
			long random =  (int)(10000+Math.random()*(10000-1+1));
			res = String.valueOf(currentDate) + String.valueOf(random);
			
			return res;
		}
	
		// TODO Auto-generated method stub
		public static void main(String[] args) {
			//long date = new Date(date).getTime();
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			//String str = sdf.format(date);
			//Out.message(GetDate.getDate());
			//System.out.println(System.currentTimeMillis()); 
	}

}

package openapiautotest.baselib;

import org.apache.log4j.Logger;





public class OutLog {

	/**
	 * @param args
	 */
	public static void getLog(String msg){
		logger.info("openapi_autotest---" + msg );
	}
	public  static Logger logger = Logger.getLogger(OutLog.class.getName());
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OutLog.getLog("111");
	}

}

package openapiautotest.api;

import org.json.JSONObject;

public class CreateJson {
	
	//商户退款生成json
	public static String customerRefundJson(String customerNum, String shopNum, String requestNum){
		String res = "error";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("customerNum",customerNum);
		jsonObject.put("shopNum",shopNum);
		jsonObject.put("requestNum",requestNum);
		res = jsonObject.toString();
		
		return res;		
	}
	
	//商户部分退款生成json
	public static String customerPartRefundJson(String customerNum, String shopNum, String requestNum, String refundPartAmount){
		String res = "error";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("customerNum",customerNum);
		jsonObject.put("shopNum",shopNum);
		jsonObject.put("requestNum",requestNum);
		jsonObject.put("refundPartAmount",refundPartAmount);
		res = jsonObject.toString();
		return res;
	}
	
	public static String agentRefund(String customerNum, String shopNum, String requestNum,String agentNum){
		String res = "error";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("customerNum",customerNum);
		jsonObject.put("shopNum",shopNum);
		jsonObject.put("requestNum",requestNum);
		jsonObject.put("agentNum",agentNum);
		res = jsonObject.toString();
		
		return res;	
	}
	
	public static String agentPartRefund(String customerNum, String shopNum, String requestNum,String agentNum,String refundPartAmount){
		String res = "error";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("customerNum",customerNum);
		jsonObject.put("shopNum",shopNum);
		jsonObject.put("requestNum",requestNum);
		jsonObject.put("agentNum",agentNum);
		jsonObject.put("refundPartAmount",refundPartAmount);
		res = jsonObject.toString();
		
		return res;	
	}
	
	public static String agentDeclareCustomer(String agentNum,String fullName,String shortName,
			String industry,String province,String city,String email,String linkMan,
			String linkPhone,String customerType,String certificateType,String certificateCode,
			String district,String certificateName){
		String res = "error";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("agentNum",agentNum);
		jsonObject.put("fullName",fullName);
		jsonObject.put("shortName",shortName);
		jsonObject.put("industry",industry);
		jsonObject.put("province",province);
		jsonObject.put("city",city);
		jsonObject.put("email",email);
		jsonObject.put("linkMan",linkMan);
		jsonObject.put("linkPhone",linkPhone);
		jsonObject.put("customerType",customerType);
		jsonObject.put("certificateType",certificateType);
		jsonObject.put("certificateCode",certificateCode);
		jsonObject.put("district",district);
		jsonObject.put("certificateName",certificateName);
		res = jsonObject.toString();
		
		return res;	
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(CreateJson.customerRefundJson("aaa", "ssss", "bbbb"));
	}

}

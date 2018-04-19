package openapiautotest.servlet;

import openapiautotest.api.OpenapiDeclare;
import openapiautotest.baselib.BaseLib;
import openapiautotest.baselib.OutInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



public class DeclareCustomerServlet extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public DeclareCustomerServlet() {
        super();
    }

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    /**
     * The doGet method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to get.
     *
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("    This is ");
        out.print(this.getClass());
        out.println(", using the GET method");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }

    /**
     * The doPost method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to post.
     *
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        //
        //response.setCharacterEncoding("UTF-8");

        String res = "error";
        String key = request.getParameter("key");
        OutInfo.msg("商户报单-key:" + key);

        String agentNum = request.getParameter("agentNum");
        OutInfo.msg("商户报单-代理商编号:" + agentNum);

        String fullName = request.getParameter("fullName");
        //fullName = new String(fullName.getBytes("UTF-8"), "GBK");
        //fullName = new String(fullName.getBytes("GBK"), "UTF-8");
        fullName = BaseLib.encodeISOtoutf(fullName);
        //fullName=new String(fullName.getBytes("utf-8"));
        //try {
        //fullName = URLEncoder.encode(fullName, "UTF-8");
        // System.out.println(strGBK);
        // String strUTF8 = URLDecoder.decode(str, "UTF-8");
        // System.out.println(strUTF8);
        //  } catch (UnsupportedEncodingException e) {
        //     e.printStackTrace();
        // }
		/*
		try {
			fullName = URLEncoder.encode(fullName,"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        OutInfo.msg("商户报单-全称:" + fullName);

        String shortName = request.getParameter("shortName");
        shortName = BaseLib.encodeISOtoutf(shortName);
        OutInfo.msg("商户报单-简称:" + shortName);

        String industry = request.getParameter("industry");
        OutInfo.msg("商户报单-行业:" + industry);

        String province = request.getParameter("province");
        OutInfo.msg("商户报单-省份:" + province);

        String city = request.getParameter("city");
        OutInfo.msg("商户报单-城市:" + city);

        String email = request.getParameter("email");
        OutInfo.msg("商户报单-邮箱:" + email);

        String linkMan = request.getParameter("linkMan");
        //linkMan = BaseLib.encodeISOtoutf(linkMan);
        OutInfo.msg("商户报单-联系人:" + linkMan);

        String linkPhone = request.getParameter("linkPhone");
        OutInfo.msg("商户报单-联系电话:" + linkPhone);

        String customerType = request.getParameter("customerType");
        OutInfo.msg("商户报单-商户类型:" + customerType);

        String certificateType = request.getParameter("certificateType");
        OutInfo.msg("商户报单-证件类型:" + certificateType);

        String certificateCode = request.getParameter("certificateCode");
        OutInfo.msg("商户报单-证件编号:" + certificateCode);

        String district = request.getParameter("district");
        OutInfo.msg("商户报单-区域:" + district);

        String certificateName = request.getParameter("certificateName");
        certificateName = BaseLib.encodeISOtoutf(certificateName);
        OutInfo.msg("商户报单-证件姓名:" + certificateName);
        res = OpenapiDeclare.declareCustomer(key, agentNum, fullName, shortName, industry, province, city, email, linkMan, linkPhone, customerType, certificateType, certificateCode, district, certificateName);

        //调试信息
        res = "{\"data\": {\"customerNum\": \"10001114748070341320175\"},\"result\": \"success\"}";

        if(res.indexOf("customerNum") != -1){
            String temp[] = res.split("customerNum\"");
            String tem[] = temp[1].split("\"");
            String customerNum = tem[1];
            OutInfo.msg("个人报单customerNum=" + customerNum);
            String resulst = "agentNum=" + agentNum + "&customerNum=" + customerNum + "&key=" + key;

            getServletContext().getRequestDispatcher("/jsp/declare_settle_info.jsp?" +resulst ).forward(request, response);

        }else{
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
            out.println("<HTML>");
            out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
            out.println("  <BODY>");
            out.print(res);
            out.println("  </BODY>");
            out.println("</HTML>");
            out.flush();
            out.close();
        }
    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    public void init() throws ServletException {
        // Put your code here
    }

}
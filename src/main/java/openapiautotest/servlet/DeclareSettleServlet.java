package openapiautotest.servlet;

import openapiautotest.baselib.BaseLib;
import openapiautotest.baselib.OutInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



public class DeclareSettleServlet extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public DeclareSettleServlet() {
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
        response.setCharacterEncoding("UTF-8");

        String res = "error";
        String key = request.getParameter("key");
        OutInfo.msg("结算报单-key:" + key);

        String agentNum = request.getParameter("agentNum");
        OutInfo.msg("报单-结算-代理商编号:" + agentNum);

        String bankAccountName = request.getParameter("bankAccountName");
        bankAccountName = BaseLib.encodeISOtoutf(bankAccountName);
        OutInfo.msg("报单-银行账户名称-代理商编号:" + bankAccountName);

        String bankAccountNum = request.getParameter("bankAccountNum");
        //bankAccountNum = BaseLib.encodeISOtoutf(bankAccountNum);
        OutInfo.msg("报单-银行账户编号-代理商编号:" + bankAccountNum);

        String province = request.getParameter("province");
        province = BaseLib.encodeISOtoutf(province);
        OutInfo.msg("报单-省份-代理商编号:" + province);

        String city = request.getParameter("city");
        city = BaseLib.encodeISOtoutf(city);
        OutInfo.msg("报单-城市-代理商编号:" + city);




        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("    This is ");
        out.print(this.getClass());
        out.println(", using the POST method");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
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
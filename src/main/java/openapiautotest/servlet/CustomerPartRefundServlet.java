package openapiautotest.servlet;

import openapiautotest.api.DoWithOpenapi;
import openapiautotest.baselib.OutInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;



public class CustomerPartRefundServlet extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public CustomerPartRefundServlet() {
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

        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        String requestNum = "";
        String customerNum = "";
        String shopNum = "";
        String key = "";


        String type = request.getParameter("type");//负责判断是微信还是支付宝，微信type=WX，支付宝type=AIP
        OutInfo.msg("部分退款类型=" + type);
        if((type != null) && (type.trim() != "")){
            //通过session及type获取微信或者支付宝的退款的三个参数
            requestNum = session.getAttribute("requestNum" + type).toString();
            OutInfo.msg("商户部分退款流水号=" + requestNum);
            customerNum = session.getAttribute("customerNum" + type).toString();
            OutInfo.msg("商户部分退款商户编号=" + customerNum);
            shopNum = session.getAttribute("shopNum" + type).toString();
            OutInfo.msg("商户部分退款店铺编号=" + shopNum);
            key = session.getAttribute("key").toString();

            //session.invalidate(); //清楚所以的sesison
            //判断三个参数不能为空，进行请求
            if((requestNum.trim() != "") &&  (requestNum != null) && (customerNum.trim() != "") &&  (customerNum != null) && (shopNum.trim() != "")
                    &&  (shopNum != null) && (key.trim() != "") &&  (key != null)){
                DoWithOpenapi ti = new DoWithOpenapi();
                String res = "error";
                res = ti.customerPartRefund(key, customerNum, shopNum, requestNum);
                response.setContentType("text/html");
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

            }else{
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
                out.println("<HTML>");
                out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
                out.println("  <BODY>");
                out.print("请确认是否已点击退款按钮，或者是否进行了付款.");
                out.println("  </BODY>");
                out.println("</HTML>");
                out.flush();
                out.close();
            }


        }else{
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
            out.println("<HTML>");
            out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
            out.println("  <BODY>");
            out.print("请确认是否已点击退款按钮，或者是否进行了付款.");
            out.println("  </BODY>");
            out.println("</HTML>");
            out.flush();
            out.close();
        }

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


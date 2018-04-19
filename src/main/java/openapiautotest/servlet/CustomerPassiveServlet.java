package openapiautotest.servlet;

import openapiautotest.api.DoWithOpenapi;
import openapiautotest.baselib.OutInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



public class CustomerPassiveServlet extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public CustomerPassiveServlet() {
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
        String payCode = request.getParameter("payCode");
        String key = request.getParameter("key");
        OutInfo.msg("===================== " + key);
        String res = "error";
        if((payCode != null) && (payCode.trim() != "")){
            DoWithOpenapi ti = new DoWithOpenapi();
            res = ti.passvie(payCode, key);
            if(res.indexOf("result\":\"success\"") != -1){
                res = "请在手机端确认支付!";
            }

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
            out.println("<HTML>");
            out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
            out.println("  <BODY>");
            out.println("<br/>");
            out.println("<br/>");
            out.print(res);
            out.println("  </BODY>");
            out.println("</HTML>");
            out.flush();
            out.close();
        }else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
            out.println("<HTML>");
            out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
            out.println("  <BODY>");
            out.print("输入支付码错误！");
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


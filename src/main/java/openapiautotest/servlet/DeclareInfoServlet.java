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



public class DeclareInfoServlet extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public DeclareInfoServlet() {
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
        response.setCharacterEncoding("UTF-8");
        String res = "error";
        String parm = "";
        String key = request.getParameter("key");
        OutInfo.msg("查询报单基础信息当前使用的key=" + key);
        String tag = request.getParameter("tag");
        OutInfo.msg("查询报单基础信息当前使用的tag=" + tag);
        String type = request.getParameter("type");
        OutInfo.msg("查询报单基础信息当前使用的type=" + type);
        int searchId = BaseLib.getIntFromString(tag);
        switch(searchId)
        {
            case 1: //省份查询
                res = OpenapiDeclare.getDeclareBaseInfo(key, type, "");
                break;
            case 2:  //查询城市
                parm = BaseLib.getConfigText(type);
                res = OpenapiDeclare.getDeclareBaseInfo(key, type, parm);
                break;
            case 3:   //查询区域
                parm = BaseLib.getConfigText(type);
                res = OpenapiDeclare.getDeclareBaseInfo(key, type, parm);
                break;
            case 4:   //查询行业
                res = OpenapiDeclare.getDeclareBaseInfo(key, type, "");
                break;
            case 5:   //查询二级行业
                parm = BaseLib.getConfigText(type);
                res = OpenapiDeclare.getDeclareBaseInfo(key, type, parm);
                break;
            case 6:   //查询支付银行
                res = OpenapiDeclare.getDeclareBaseInfo(key, type, "");
                break;
            case 7:   //查询行业
                parm = BaseLib.getConfigText(type);
                res = OpenapiDeclare.getDeclareBaseInfo(key, type, parm);
                break;
            case 8:   //查询支行
                parm = BaseLib.getConfigText(type);
                res = OpenapiDeclare.getDeclareBaseInfo(key, type, parm);
                break;
            default:
                res = "输入参数错误，请检测参数!";
                break;
        }


        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.println(res);
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

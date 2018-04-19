package openapiautotest.servlet;

import openapiautotest.api.DoWithOpenapi;
import openapiautotest.api.GetNum;
import openapiautotest.baselib.OutInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class AgentServlet extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public AgentServlet() {
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


        //response.setContentType("text/html");
        //response.setHeader("Content-type", "text/html;charset=UTF-8");
        //这句话的意思，是告诉servlet用UTF-8转码，而不是用默认的ISO8859
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        String key = request.getParameter("key");
        String amount = request.getParameter("amount");
        String spitle = "\\|";           //获取商户编号分隔符

        OutInfo.msg("代理商主扫当前使用的key=" + key);
        session.setAttribute("key", key);  //用session获取key，方便在退款时查找url

        //判断是否是退款操作，如果是这再二维码页面显示退款按钮 refund表示退款，partRefund表示部分退款
        String agentRefund = request.getParameter("agentRefund");
        OutInfo.msg("退款状态=" + agentRefund);
        if((agentRefund != null) && (agentRefund.trim() != "") && (agentRefund != "null")){
            session.setAttribute("agentRefund", agentRefund);
            OutInfo.msg("退款状态=" + agentRefund + "成功");
        }


        //开始调用商户主扫操作
        DoWithOpenapi ti  = new DoWithOpenapi();

        //对微信结果进行处理
        String resWX = "error";//默认值，一旦结果出现error，就是自动接口出错

        //对结果进行分割，把url传到页面
        String returnResWX = ti.agent(key,amount);
        resWX= GetNum.getPayLinkByInfo(returnResWX);
        OutInfo.msg("获取微信支付链接=" + resWX);

        //获取流水号、商户号及店铺编号串
        //判断是返回正确的值，进行处理，不然直接返回错误信息
        if(returnResWX.indexOf("=====") != -1){
            String numsWX = GetNum.getNumsByInfo(returnResWX);
            String requestNumWX = GetNum.getCustomerNumAndShopNum(numsWX, spitle, 0);
            session.setAttribute("requestNumWX", requestNumWX);
            OutInfo.msg("设置代理商流水号=" + requestNumWX + "成功");

            String agentNumWX =GetNum.getCustomerNumAndShopNum(numsWX, spitle, 1);
            session.setAttribute("agentNumWX", agentNumWX);
            OutInfo.msg("设置代理商编号=" + agentNumWX + "成功");

            String customerNumWX =GetNum.getCustomerNumAndShopNum(numsWX, spitle, 2);
            session.setAttribute("customerNumWX", customerNumWX);
            OutInfo.msg("设置商户号=" + customerNumWX + "成功");

            String shopNumWX =GetNum.getCustomerNumAndShopNum(numsWX, spitle, 3);
            session.setAttribute("shopNumWX", shopNumWX);
            OutInfo.msg("设置店铺号=" + shopNumWX + "成功");
        }else{
            resWX = returnResWX;
        }

        //对支付宝结果进行处理
        String resAIP = "error";//默认值，一旦结果出现error，就是自动接口出错

        //对结果进行分割，把url传到页面
        String returnResAIP = ti.agent(key,amount);
        resAIP= GetNum.getPayLinkByInfo(returnResAIP);
        OutInfo.msg("获取支付宝链接=" + resAIP);

        //获取流水号、商户号及店铺编号串
        if(returnResAIP.indexOf("=====") != -1){
            String numsAIP = GetNum.getNumsByInfo(returnResAIP);
            String requestNumAIP = GetNum.getCustomerNumAndShopNum(numsAIP, spitle, 0);
            session.setAttribute("requestNumAIP", requestNumAIP);
            OutInfo.msg("设置代理商流水号=" + requestNumAIP + "成功");

            String agentNumAIP =GetNum.getCustomerNumAndShopNum(numsAIP, spitle, 1);
            session.setAttribute("agentNumAIP", agentNumAIP);
            OutInfo.msg("设置代理商编号=" + agentNumAIP + "成功");

            String customerNumAIP =GetNum.getCustomerNumAndShopNum(numsAIP, spitle, 2);
            session.setAttribute("customerNumAIP", customerNumAIP);
            OutInfo.msg("设置商户号=" + customerNumAIP + "成功");

            String shopNumAIP =GetNum.getCustomerNumAndShopNum(numsAIP, spitle, 3);
            session.setAttribute("shopNumAIP", shopNumAIP);
            OutInfo.msg("设置店铺号=" + shopNumAIP + "成功");
        }else{
            resAIP = returnResAIP;
        }
        String resulst = "resWX=" + resWX + "&resAIP=" + resAIP;
        getServletContext().getRequestDispatcher("/jsp/agent_create_qrcode.jsp?" +resulst ).forward(request, response);

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

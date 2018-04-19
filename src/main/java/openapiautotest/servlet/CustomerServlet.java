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





public class CustomerServlet extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public CustomerServlet() {
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

        //这句话的意思，是告诉servlet用UTF-8转码，而不是用默认的ISO8859
        //request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();


        //获取传过来的key值
        String key = request.getParameter("key");
        String amount = request.getParameter("amount");
        String spitle = "\\|";           //获取商户编号分隔符

        OutInfo.msg("商户主扫当前使用的key=" + key);
        session.setAttribute("key", key);  //用session获取key，方便在退款时查找url

        //判断是否是退款操作，如果是这再二维码页面显示退款按钮 refund表示退款，partRefund表示部分退款
        String refund = request.getParameter("refund");
        if((refund != null) && (refund.trim() != "") && (refund != "null")){
            session.setAttribute("refund", refund);
            OutInfo.msg("退款状态=" + refund + "成功");
        }

        //开始调用商户主扫操作
        DoWithOpenapi ti  = new DoWithOpenapi();

        //对微信结果进行处理
        String resWX = "error";//默认值，一旦结果出现error，就是自动接口出错

        //对结果进行分割，把url传到页面
        String returnResWX = ti.customer(key,amount);
        //判断是返回正确的值，进行处理，不然直接返回错误信息
        if(returnResWX.indexOf("=====") != -1){
            resWX= GetNum.getPayLinkByInfo(returnResWX);
            OutInfo.msg("商户获取微信支付链接=" + resWX);

            //获取流水号、商户号及店铺编号串
            String numsWX = GetNum.getNumsByInfo(returnResWX);
            String requestNumWX = GetNum.getCustomerNumAndShopNum(numsWX, spitle, 0);
            session.setAttribute("requestNumWX", requestNumWX);
            OutInfo.msg("设置流水号=" + requestNumWX + "成功");

            String customerNumWX =GetNum.getCustomerNumAndShopNum(numsWX, spitle, 1);
            session.setAttribute("customerNumWX", customerNumWX);
            OutInfo.msg("设置商户号=" + customerNumWX + "成功");

            String shopNumWX =GetNum.getCustomerNumAndShopNum(numsWX, spitle, 2);
            session.setAttribute("shopNumWX", shopNumWX);
            OutInfo.msg("设置店铺号=" + shopNumWX + "成功");
        }else{
            resWX = returnResWX;
        }



        String resAIP = "error";//默认值，一旦结果出现error，就是自动接口出错
        String returnResAIP = ti.customer(key,amount);
        if(returnResAIP.indexOf("=====") != -1){
            resAIP= GetNum.getPayLinkByInfo(returnResAIP);
            OutInfo.msg("商户获取支付宝链接=" + resAIP);
            //获取流水号、商户号及店铺编号串
            String numsAIP = GetNum.getNumsByInfo(returnResAIP);
            String requestNumAIP = GetNum.getCustomerNumAndShopNum(numsAIP, spitle, 0);
            session.setAttribute("requestNumAIP", requestNumAIP);
            OutInfo.msg("设置流水号=" + requestNumAIP + "成功");

            String customerNumAIP =GetNum.getCustomerNumAndShopNum(numsAIP, spitle, 1);
            session.setAttribute("customerNumAIP", customerNumAIP);
            OutInfo.msg("设置商户号=" + customerNumAIP + "成功");

            String shopNumAIP =GetNum.getCustomerNumAndShopNum(numsAIP, spitle, 2);
            session.setAttribute("shopNumAIP", shopNumAIP);
            OutInfo.msg("设置店铺号=" + shopNumAIP + "成功");
        }else{
            resAIP = returnResAIP;
        }



        //一共做了两次商户主扫操作，把结果放在一起，方便到二维码生成页使用
        //resWX = "https://order.duolabao.com/active/c?state=152265776046613912%7C10011015178258181970145%7C0.01%7C15%7CAPI";
        //resAIP = "https://order.duolabao.com/active/c?state=152265776046613912%7C10011015178258181970145%7C0.01%7C15%7CAPI";
        String resulst = "resWX=" + resWX + "&resAIP=" + resAIP;
        session.setAttribute("resWX", resWX);
        session.setAttribute("resAIP", resAIP);
        //获取结果后，在servlet里跳转到二维码生成页面，并传入结果
        getServletContext().getRequestDispatcher("/jsp/customer_create_qrcode.jsp?" +resulst ).forward(request, response);
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

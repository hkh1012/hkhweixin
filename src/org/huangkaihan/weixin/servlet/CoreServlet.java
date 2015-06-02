package org.huangkaihan.weixin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.huangkaihan.weixin.service.CoreService;
import org.huangkaihan.weixin.utils.SignUtil;
/**
 * 公众号核心请求处理类(Servlet)
 * @author huangkaihan
 */
public class CoreServlet extends HttpServlet {

	private static final long serialVersionUID = 4440739483644821986L;  
	/**
	 * 确认请求是来自微信服务器
	 */
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		//微信加密签名
		String signature = req.getParameter("signature");
		//时间戳
		String timestamp = req.getParameter("timestamp");
		//随机数
		String nonce = req.getParameter("nonce");
		//随机字符串
		String echostr = req.getParameter("echostr");
		
		PrintWriter out = resp.getWriter();
		//通过验证signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败 
		if(SignUtil.verifySignature(signature, timestamp, nonce)){
			out.append(echostr);
		}
		out.close();
		out = null;
	}
	
	/**
	 * 处理微信服务器发来的消息
	 * @throws IOException 
	 */
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）  
        req.setCharacterEncoding("UTF-8");  
        resp.setCharacterEncoding("UTF-8");  
  
        // 调用核心业务类接收消息、处理消息  
        String respMessage = CoreService.processRequest(req);  
        // 响应消息  
        PrintWriter out = resp.getWriter();  
        out.print(respMessage);  
        out.close();  
		out = null;
	}
}

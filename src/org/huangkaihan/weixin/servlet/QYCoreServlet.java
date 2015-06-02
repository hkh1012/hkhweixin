package org.huangkaihan.weixin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;

/**
 * ��ҵ�ź��Ĵ�����(servlet) �ƿ���
 */
public class QYCoreServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QYCoreServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���ñ���
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		// ��ҵ�ŵĻ�����Ϣ������ʱ��д
		String sToken = "huangkaihan";
		String sCorpID = "wx365a055a087f1a14";
		String sEncodingAESKey = "MAS6ucWwstBvODncZVz4EMgzquxEG3QzpFIyzZi7HM1";
		try {
			WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(sToken, sEncodingAESKey,
					sCorpID);
			String sVerifyMsgSig = URLDecoder.decode(
					request.getParameter("msg_signature"), "utf-8");
			String sVerifyTimeStamp = URLDecoder.decode(
					request.getParameter("timestamp"), "utf-8");
			String sVerifyNonce = URLDecoder.decode(
					request.getParameter("nonce"), "utf-8");
			String sVerifyEchoStr = URLDecoder.decode(
					request.getParameter("echostr"), "utf-8");
			PrintWriter out = response.getWriter();
			String sEchoStr; // ��Ҫ���ص�����
			try {
				sEchoStr = wxcpt.VerifyURL(sVerifyMsgSig, sVerifyTimeStamp,
						sVerifyNonce, sVerifyEchoStr);
				System.out.println("verifyurl echostr: " + sEchoStr);
				// ��֤URL�ɹ�����sEchoStr����
				out.print(sEchoStr);
				out.close();
				out = null;
			} catch (Exception e) {
				// ��֤URLʧ�ܣ�����ԭ����鿴�쳣
				e.printStackTrace();
			}
		} catch (AesException e1) {
			e1.printStackTrace();
		}
	}

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
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

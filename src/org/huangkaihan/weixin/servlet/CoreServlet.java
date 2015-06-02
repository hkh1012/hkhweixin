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
 * ���ںź�����������(Servlet)
 * @author huangkaihan
 */
public class CoreServlet extends HttpServlet {

	private static final long serialVersionUID = 4440739483644821986L;  
	/**
	 * ȷ������������΢�ŷ�����
	 */
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		//΢�ż���ǩ��
		String signature = req.getParameter("signature");
		//ʱ���
		String timestamp = req.getParameter("timestamp");
		//�����
		String nonce = req.getParameter("nonce");
		//����ַ���
		String echostr = req.getParameter("echostr");
		
		PrintWriter out = resp.getWriter();
		//ͨ����֤signature���������У�飬��У��ɹ���ԭ������echostr����ʾ����ɹ����������ʧ�� 
		if(SignUtil.verifySignature(signature, timestamp, nonce)){
			out.append(echostr);
		}
		out.close();
		out = null;
	}
	
	/**
	 * ����΢�ŷ�������������Ϣ
	 * @throws IOException 
	 */
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		// ��������Ӧ�ı��������ΪUTF-8����ֹ�������룩  
        req.setCharacterEncoding("UTF-8");  
        resp.setCharacterEncoding("UTF-8");  
  
        // ���ú���ҵ���������Ϣ��������Ϣ  
        String respMessage = CoreService.processRequest(req);  
        // ��Ӧ��Ϣ  
        PrintWriter out = resp.getWriter();  
        out.print(respMessage);  
        out.close();  
		out = null;
	}
}

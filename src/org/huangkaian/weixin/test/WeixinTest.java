package org.huangkaian.weixin.test;

import net.sf.json.JSONObject;

import org.huangkaihan.weixin.po.AccessToken;
import org.huangkaihan.weixin.utils.WeixinUtil;


public class WeixinTest {
	public static void main(String[] args) {
		try {
			AccessToken token = WeixinUtil.getAccessToken();
			System.out.println("Ʊ�ݣ�"+token.getToken());
			System.out.println("��Ч�ڣ�"+token.getExpiresIn());
			
			String menu = JSONObject.fromObject(WeixinUtil.initMenu()).toString();
			System.out.println(menu);
			int result = WeixinUtil.createMenu(token.getToken(), menu);
			if(result==0){
				System.out.println("�����˵��ɹ���");
			}else{
				System.out.println("�����˵�ʧ��");
			}
			//String path = "D:/imooc.jpg";
			//String mediaId = WeixinUtil.upload(path, token.getToken(), "thumb");
			//System.out.println(mediaId);
			
			//String result = WeixinUtil.translate("my name is laobi");
			//String result = WeixinUtil.translateFull("");
			//System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package org.huangkaian.weixin.test;

import net.sf.json.JSONObject;

import org.huangkaihan.weixin.po.AccessToken;
import org.huangkaihan.weixin.utils.WeixinUtil;


public class WeixinTest {
	public static void main(String[] args) {
		try {
			AccessToken token = WeixinUtil.getAccessToken();
			System.out.println("票据："+token.getToken());
			System.out.println("有效期："+token.getExpiresIn());
			
			String menu = JSONObject.fromObject(WeixinUtil.initMenu()).toString();
			System.out.println(menu);
			int result = WeixinUtil.createMenu(token.getToken(), menu);
			if(result==0){
				System.out.println("创建菜单成功。");
			}else{
				System.out.println("创建菜单失败");
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

package org.huangkaihan.weixin.constant;

/**
 * 微信开发中使用的常量
 *
 */
public interface WeixinConstant {
	/**
	 * 公众平台后台设置的token，用来验证消息是否来自微信服务器
	 */
	public static final String TOKEN = "huangkaihan";
	
	/**
	 * 公众号appid
	 */
	public static final String APPID = "wxf6d5f6a18270c230";
	
	/**
	 * 公众号appsecret
	 */
	public static final String APPSECRET = "f7eb4bcfbb7f94111218e75526ec957b";
	
	/**
	 * 获取access_token基础接口的url
	 */
	public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	
	/**
	 * 上传素材接口url
	 */
	public static final String UPLOAD_URL = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	
	/**
	 * 创建自定义菜单接口的url
	 */
	public static final String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	
	/**
	 * 查询自定义菜单接口的url
	 */
	public static final String QUERY_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	
	/**
	 * 删除自定义菜单接口的url
	 */
	public static final String DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	
}

package org.huangkaihan.weixin.constant;

/**
 * ΢�ſ�����ʹ�õĳ���
 *
 */
public interface WeixinConstant {
	/**
	 * ����ƽ̨��̨���õ�token��������֤��Ϣ�Ƿ�����΢�ŷ�����
	 */
	public static final String TOKEN = "huangkaihan";
	
	/**
	 * ���ں�appid
	 */
	public static final String APPID = "wxf6d5f6a18270c230";
	
	/**
	 * ���ں�appsecret
	 */
	public static final String APPSECRET = "f7eb4bcfbb7f94111218e75526ec957b";
	
	/**
	 * ��ȡaccess_token�����ӿڵ�url
	 */
	public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	
	/**
	 * �ϴ��زĽӿ�url
	 */
	public static final String UPLOAD_URL = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	
	/**
	 * �����Զ���˵��ӿڵ�url
	 */
	public static final String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	
	/**
	 * ��ѯ�Զ���˵��ӿڵ�url
	 */
	public static final String QUERY_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	
	/**
	 * ɾ���Զ���˵��ӿڵ�url
	 */
	public static final String DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	
}

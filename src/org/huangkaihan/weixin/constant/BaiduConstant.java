package org.huangkaihan.weixin.constant;

public interface BaiduConstant {
	/**
	 * �ٶȿ����û�id
	 */
	public static final String BAIDU_TRANS_CLIENT_ID = "jNg0LPSBe691Il0CG5MwDupw";
	
	/**
	 * �ٶȷ���ӿ�url
	 */
	public static final String BAIDU_TRANS_URL = "http://openapi.baidu.com/public/2.0/translate/dict/simple?client_id=" + BAIDU_TRANS_CLIENT_ID + "&q=KEYWORD&from=auto&to=auto";
	
	/**
	 * �ٶȴʵ�ӿ�url
	 */
	public static final String BAIDU_TRANS_FULL_URL = "http://openapi.baidu.com/public/2.0/bmt/translate?client_id="+ BAIDU_TRANS_CLIENT_ID +"&q=KEYWORD&from=auto&to=auto";
}

package org.huangkaihan.weixin.constant;

public interface BaiduConstant {
	/**
	 * 百度开发用户id
	 */
	public static final String BAIDU_TRANS_CLIENT_ID = "jNg0LPSBe691Il0CG5MwDupw";
	
	/**
	 * 百度翻译接口url
	 */
	public static final String BAIDU_TRANS_URL = "http://openapi.baidu.com/public/2.0/translate/dict/simple?client_id=" + BAIDU_TRANS_CLIENT_ID + "&q=KEYWORD&from=auto&to=auto";
	
	/**
	 * 百度词典接口url
	 */
	public static final String BAIDU_TRANS_FULL_URL = "http://openapi.baidu.com/public/2.0/bmt/translate?client_id="+ BAIDU_TRANS_CLIENT_ID +"&q=KEYWORD&from=auto&to=auto";
}

package org.huangkaihan.weixin.utils;

import java.util.Arrays;
/**
 * ǩ��������
 * huangkaihan
 */
public class SignUtil {

	public static final String TOKEN = "huangkaihan";
	
	/**
	 * ��֤��Ϣ�Ƿ���΢��ƽ̨
	 * @param signture
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public static boolean verifySignature(String signature,String timestamp,String nonce){
		String[] arr = new String[]{TOKEN,timestamp,nonce}; 
		Arrays.sort(arr);
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<arr.length;i++){
			sb.append(arr[i]);
		}
		String tempStr =  sb.toString();
		sb = null;
		return signature.toUpperCase().equals(EncryptUtil.encryptSHA1(tempStr));
	}
	
	
}

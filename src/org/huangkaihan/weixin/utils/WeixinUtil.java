package org.huangkaihan.weixin.utils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.huangkaihan.weixin.constant.BaiduConstant;
import org.huangkaihan.weixin.constant.WeixinConstant;
import org.huangkaihan.weixin.menu.Button;
import org.huangkaihan.weixin.menu.ClickButton;
import org.huangkaihan.weixin.menu.Menu;
import org.huangkaihan.weixin.menu.ViewButton;
import org.huangkaihan.weixin.po.AccessToken;
import org.huangkaihan.weixin.trans.Data;
import org.huangkaihan.weixin.trans.Parts;
import org.huangkaihan.weixin.trans.Symbols;
import org.huangkaihan.weixin.trans.TransResult;

import net.sf.json.JSONObject;
/**
 * ΢�Ź�����
 * ��ȡaccess_token,�ϴ��ز�,�˵�����,�ٶȷ����
 */
public class WeixinUtil {
	/**
	 * get����
	 * @param url
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static JSONObject doGetStr(String url) throws ClientProtocolException, IOException{
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		JSONObject jsonObject = null;
		HttpResponse response = httpClient.execute(httpGet);
		HttpEntity httpEntity = response.getEntity();
		if(!httpEntity.equals(null)){
			String result = EntityUtils.toString(httpEntity, "UTF-8");
			jsonObject = JSONObject.fromObject(result);
		}
		return jsonObject;
	}
	
	/**
	 * post����
	 * @param url
	 * @param outstr
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static JSONObject doPostStr(String url,String outstr) throws ClientProtocolException, IOException{
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		JSONObject jsonObject = null;
		httpPost.setEntity(new StringEntity(outstr,"UTF-8"));
		HttpResponse response = httpClient.execute(httpPost);
		HttpEntity httpEntity = response.getEntity();
		if(httpEntity.equals(null)){
			String result = EntityUtils.toString(httpEntity, "UTF-8");
			jsonObject = JSONObject.fromObject(result);
		}
		return jsonObject;
	}
	
	/**
	 * �ļ��ϴ�
	 * @param filePath
	 * @param accessToken
	 * @param type
	 * @return
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws KeyManagementException
	 */
	public static String upload(String filePath, String accessToken,String type) throws IOException, NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException {
		File file = new File(filePath);
		if (!file.exists() || !file.isFile()) {
			throw new IOException("�ļ�������");
		}

		String url = WeixinConstant.UPLOAD_URL.replace("ACCESS_TOKEN", accessToken).replace("TYPE",type);
		
		URL urlObj = new URL(url);
		//����
		HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();

		con.setRequestMethod("POST"); 
		con.setDoInput(true);
		con.setDoOutput(true);
		con.setUseCaches(false); 

		//��������ͷ��Ϣ
		con.setRequestProperty("Connection", "Keep-Alive");
		con.setRequestProperty("Charset", "UTF-8");

		//���ñ߽�
		String BOUNDARY = "----------" + System.currentTimeMillis();
		con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);

		StringBuilder sb = new StringBuilder();
		sb.append("--");
		sb.append(BOUNDARY);
		sb.append("\r\n");
		sb.append("Content-Disposition: form-data;name=\"file\";filename=\"" + file.getName() + "\"\r\n");
		sb.append("Content-Type:application/octet-stream\r\n\r\n");

		byte[] head = sb.toString().getBytes("utf-8");

		//��������
		OutputStream out = new DataOutputStream(con.getOutputStream());
		//�����ͷ
		out.write(head);

		//�ļ����Ĳ���
		//���ļ������ļ��ķ�ʽ ���뵽url��
		DataInputStream in = new DataInputStream(new FileInputStream(file));
		int bytes = 0;
		byte[] bufferOut = new byte[1024];
		while ((bytes = in.read(bufferOut)) != -1) {
			out.write(bufferOut, 0, bytes);
		}
		in.close();

		//��β����
		byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");//����������ݷָ���

		out.write(foot);

		out.flush();
		out.close();

		StringBuffer buffer = new StringBuffer();
		BufferedReader reader = null;
		String result = null;
		try {
			//����BufferedReader����������ȡURL����Ӧ
			reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			if (result == null) {
				result = buffer.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
		}

		JSONObject jsonObj = JSONObject.fromObject(result);
		System.out.println(jsonObj);
		String typeName = "media_id";
		if(!"image".equals(type)){
			typeName = type + "_media_id";
		}
		String mediaId = jsonObj.getString(typeName);
		return mediaId;
	}
	
	/**
	 * ��ȡaccessToken
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static AccessToken getAccessToken() throws ParseException, IOException{
		AccessToken token = new AccessToken();
		String url = WeixinConstant.ACCESS_TOKEN_URL.replace("APPID", WeixinConstant.APPID).replace("APPSECRET", WeixinConstant.APPSECRET);
		JSONObject jsonObject = doGetStr(url);
		if(jsonObject!=null){
			token.setToken(jsonObject.getString("access_token"));
			token.setExpiresIn(jsonObject.getInt("expires_in"));
		}
		return token;
	}
	
	/**
	 * ��װ�˵�
	 * @return
	 */
	public static Menu initMenu(){
		Menu menu = new Menu();
		ClickButton button11 = new ClickButton();
		button11.setName("click�˵�");
		button11.setType("click");
		button11.setKey("11");
		
		ViewButton button21 = new ViewButton();
		button21.setName("view�˵�");
		button21.setType("view");
		button21.setUrl("http://www.imooc.com");
		
		ClickButton button31 = new ClickButton();
		button31.setName("ɨ���¼�");
		button31.setType("scancode_push");
		button31.setKey("31");
		
		ClickButton button32 = new ClickButton();
		button32.setName("����λ��");
		button32.setType("location_select");
		button32.setKey("32");
		
		Button button = new Button();
		button.setName("�˵�");
		button.setSub_button(new Button[]{button31,button32});
		
		menu.setButton(new Button[]{button11,button21,button});
		return menu;
	}
	
	public static int createMenu(String access_token,String menu) throws ParseException, IOException{
		int result = 0;
		String url = WeixinConstant.CREATE_MENU_URL.replace("ACCESS_TOKEN", access_token);
		JSONObject jsonObject = doPostStr(url, menu);
		if(jsonObject != null){
			result = jsonObject.getInt("errcode");
		}
		return result;
	}
	
	public static JSONObject queryMenu(String access_token) throws ParseException, IOException{
		String url = WeixinConstant.QUERY_MENU_URL.replace("ACCESS_TOKEN", access_token);
		JSONObject jsonObject = doGetStr(url);
		return jsonObject;
	}
	
	public static int deleteMenu(String access_token) throws ParseException, IOException{
		String url = WeixinConstant.DELETE_MENU_URL.replace("ACCESS_TOKEN", access_token);
		JSONObject jsonObject = doGetStr(url);
		int result = 0;
		if(jsonObject != null){
			result = jsonObject.getInt("errcode");
		}
		return result;
	}
	
	public static String translate(String source) throws ParseException, IOException{
		String url = BaiduConstant.BAIDU_TRANS_URL;
		url = url.replace("KEYWORD", URLEncoder.encode(source, "UTF-8"));
		JSONObject jsonObject = doGetStr(url);
		String errno = jsonObject.getString("errno");
		Object obj = jsonObject.get("data");
		StringBuffer dst = new StringBuffer();
		if("0".equals(errno) && !"[]".equals(obj.toString())){
			TransResult transResult = (TransResult) JSONObject.toBean(jsonObject, TransResult.class);
			Data data = transResult.getData();
			Symbols symbols = data.getSymbols()[0];
			String phzh = symbols.getPh_zh()==null ? "" : "����ƴ����"+symbols.getPh_zh()+"\n";
			String phen = symbols.getPh_en()==null ? "" : "ӢʽӢ�꣺"+symbols.getPh_en()+"\n";
			String pham = symbols.getPh_am()==null ? "" : "��ʽӢ�꣺"+symbols.getPh_am()+"\n";
			dst.append(phzh+phen+pham);
			
			Parts[] parts = symbols.getParts();
			String pat = null;
			for(Parts part : parts){
				pat = (part.getPart()!=null && !"".equals(part.getPart())) ? "["+part.getPart()+"]" : "";
				String[] means = part.getMeans();
				dst.append(pat);
				for(String mean : means){
					dst.append(mean+";");
				}
			}
		}else{
			dst.append(translateFull(source));
		}
		return dst.toString();
	}
	
	public static String translateFull(String source) throws ParseException, IOException{
		String url = BaiduConstant.BAIDU_TRANS_FULL_URL;
		url = url.replace("KEYWORD", URLEncoder.encode(source, "UTF-8"));
		JSONObject jsonObject = doGetStr(url);
		StringBuffer dst = new StringBuffer();
		List<Map> list = (List<Map>) jsonObject.get("trans_result");
		for(Map map : list){
			dst.append(map.get("dst"));
		}
		return dst.toString();
	}
}

package org.huangkaihan.weixin.message.req;

/**
 * ������Ϣ֮ͼƬ��Ϣ
 * @author huangkaihan
 */
public class ImageMessage extends BaseMessage {
	//ͼƬ����
	private String PicUrl;
	//ͼƬ��Ϣý��id�����Ե��ö�ý���ļ����ؽӿ���ȡ���ݡ�
	private long MediaId;
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		this.PicUrl = picUrl;
	}
	public long getMediaId() {
		return MediaId;
	}
	public void setMediaId(long mediaId) {
		this.MediaId = mediaId;
	}
	
}

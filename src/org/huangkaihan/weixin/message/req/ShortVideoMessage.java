package org.huangkaihan.weixin.message.req;

/**
 * ������Ϣ֮С��Ƶ��Ϣ
 * @author huangkaihan
 */
public class ShortVideoMessage extends BaseMessage {
	//��Ƶ��Ϣý��id�����Ե��ö�ý���ļ����ؽӿ���ȡ���ݡ�
	private long MediaId;	
	//��Ƶ��Ϣ����ͼ��ý��id�����Ե��ö�ý���ļ����ؽӿ���ȡ���ݡ�
	private long ThumbMediaId;
	public long getMediaId() {
		return MediaId;
	}
	public void setMediaId(long mediaId) {
		this.MediaId = mediaId;
	}
	public long getThumbMediaId() {
		return ThumbMediaId;
	}
	public void setThumbMediaId(long thumbMediaId) {
		this.ThumbMediaId = thumbMediaId;
	}
	
}

package org.huangkaihan.weixin.message.req;
/**
 * ������Ϣ֮������Ϣ
 * @author huangkaihan
 */
public class VoiceMessage extends BaseMessage {
	//������Ϣý��id�����Ե��ö�ý���ļ����ؽӿ���ȡ���ݡ�
	private long MediaId;
	//������ʽ����amr��speex��
	private String Format;
	public long getMediaId() {
		return MediaId;
	}
	public void setMediaId(long mediaId) {
		this.MediaId = mediaId;
	}
	public String getFormat() {
		return Format;
	}
	public void setFormat(String format) {
		this.Format = format;
	}
}

package org.huangkaihan.weixin.message.req;
/**
 * 请求消息之语音消息
 * @author huangkaihan
 */
public class VoiceMessage extends BaseMessage {
	//语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
	private long MediaId;
	//语音格式，如amr，speex等
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

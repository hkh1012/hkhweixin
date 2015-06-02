package org.huangkaihan.weixin.message.req;

/**
 * 请求消息之视频消息
 * @author huangkaihan
 */
public class VideoMessage extends BaseMessage {
	//视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
	private long MediaId;	
	//视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
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

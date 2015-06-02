package org.huangkaihan.weixin.message.req;

/**
 * 请求消息之图片消息
 * @author huangkaihan
 */
public class ImageMessage extends BaseMessage {
	//图片链接
	private String PicUrl;
	//图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
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

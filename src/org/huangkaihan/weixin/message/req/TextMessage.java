package org.huangkaihan.weixin.message.req;

/**
 * q请求消息之文本消息
 * @author huangkaihan
 */
public class TextMessage extends BaseMessage {
	//文本消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		this.Content = content;
	}
	
}

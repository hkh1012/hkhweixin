package org.huangkaihan.weixin.message.req;

/**
 * q������Ϣ֮�ı���Ϣ
 * @author huangkaihan
 */
public class TextMessage extends BaseMessage {
	//�ı���Ϣ����
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		this.Content = content;
	}
	
}
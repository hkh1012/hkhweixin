package org.huangkaihan.weixin.message.resp;

/**
 * ��Ӧ��Ϣ֮�ı���Ϣ
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

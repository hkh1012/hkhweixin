package org.huangkaihan.weixin.message.req;

/**
 * ������Ϣ֮����λ����Ϣ
 * @author huangkaihan
 */
public class LocationMessage extends BaseMessage {
	//����λ��γ��
	private String Location_X;	
	//����λ�þ���
	private String Location_Y;	
	//��ͼ���Ŵ�С
	private String Scale;	
	//����λ����Ϣ
	private String Label;
	public String getLocation_X() {
		return Location_X;
	}
	public void setLocation_X(String location_X) {
		this.Location_X = location_X;
	}
	public String getLocation_Y() {
		return Location_Y;
	}
	public void setLocation_Y(String location_Y) {
		this.Location_Y = location_Y;
	}
	public String getScale() {
		return Scale;
	}
	public void setScale(String scale) {
		this.Scale = scale;
	}
	public String getLabel() {
		return Label;
	}
	public void setLabel(String label) {
		this.Label = label;
	}	
	
}

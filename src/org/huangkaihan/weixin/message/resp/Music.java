package org.huangkaihan.weixin.message.resp;

/** 
 * ����model 
 * @author huangkaihan 
 */  
public class Music {  
    // ��������  
    private String Title;  
    // ��������  
    private String Description;  
    // ��������  
    private String MusicUrl;  
    // �������������ӣ�WIFI��������ʹ�ø����Ӳ�������  
    private String HqMusicUrl;
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		this.Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		this.Description = description;
	}
	public String getMusicUrl() {
		return MusicUrl;
	}
	public void setMusicUrl(String musicUrl) {
		this.MusicUrl = musicUrl;
	}
	public String getHqMusicUrl() {
		return HqMusicUrl;
	}
	public void setHqMusicUrl(String hqMusicUrl) {
		this.HqMusicUrl = hqMusicUrl;
	}  
  
}
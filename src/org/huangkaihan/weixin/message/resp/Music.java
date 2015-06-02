package org.huangkaihan.weixin.message.resp;

/** 
 * 音乐model 
 * @author huangkaihan 
 */  
public class Music {  
    // 音乐名称  
    private String Title;  
    // 音乐描述  
    private String Description;  
    // 音乐链接  
    private String MusicUrl;  
    // 高质量音乐链接，WIFI环境优先使用该链接播放音乐  
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
package org.huangkaihan.weixin.message.resp;
/** 
 * 响应消息之音乐消息 
 * @author huangkaihan 
 */  
public class MusicMessage extends BaseMessage {  
    // 音乐  
    private Music music;  
  
    public Music getMusic() {  
        return music;  
    }  
  
    public void setMusic(Music mmusic) {  
        music = mmusic;  
    }  
}  

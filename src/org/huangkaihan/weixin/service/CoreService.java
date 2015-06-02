package org.huangkaihan.weixin.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.huangkaihan.weixin.message.resp.Article;
import org.huangkaihan.weixin.message.resp.NewsMessage;
import org.huangkaihan.weixin.message.resp.TextMessage;
import org.huangkaihan.weixin.utils.MessageUtil;

/** 
 * ���ķ����� 
 * @author huangkaihan 
 */  
public class CoreService {  
    /** 
     * ����΢�ŷ��������� 
     * @param request 
     * @return 
     */  
    public static String processRequest(HttpServletRequest request) {  
        String respMessage = null;  
        try {  
            // Ĭ�Ϸ��ص��ı���Ϣ����  
            String respContent = "�������쳣�����Ժ��ԣ�";  
            // xml�������  
            Map<String, String> requestMap = MessageUtil.parseXml(request);  
            // ���ͷ��ʺţ�open_id��  
            String fromUserName = requestMap.get("FromUserName");  
            // �����ʺ�  
            String toUserName = requestMap.get("ToUserName");  
            // ��Ϣ����  
            String msgType = requestMap.get("MsgType");  
            // Ĭ�ϻظ��ı���Ϣ  
            String reqContent = requestMap.get("Content");
            TextMessage textMessage = new TextMessage();  
            textMessage.setToUserName(fromUserName);  
            textMessage.setFromUserName(toUserName);  
            textMessage.setCreateTime(new Date().getTime()/1000);  
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);  
            textMessage.setFuncFlag(0);  
            // ����href����ֵ������˫�������������ַ��������˫���ų�ͻ������Ҫת��  
            textMessage.setContent("��ӭ����<a href=\"http://blog.csdn.net/hkh_1012\">�ƿ����Ĳ���</a>!");  
            // ���ı���Ϣ����ת����xml�ַ���  
            respMessage = MessageUtil.textMessageToXml(textMessage);  
            
            // �ı���Ϣ  
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {  
            	// ����ͼ����Ϣ  
                NewsMessage newsMessage = new NewsMessage();  
                newsMessage.setToUserName(fromUserName);  
                newsMessage.setFromUserName(toUserName);  
                newsMessage.setCreateTime(new Date().getTime());  
                newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);  
                newsMessage.setFuncFlag(0); 
                
                List<Article> articleList = new ArrayList<Article>(); 
                // ��ͼ����Ϣ  
                if ("1".equals(reqContent)) {  
                    Article article = new Article();  
                    article.setTitle("΢�Ź����ʺſ����̳�Java��");  
                    article.setDescription("���壬80��΢�Ź����ʺſ�������4���¡�Ϊ������ѧ�����ţ����Ƴ���ϵ�н̳̣�Ҳϣ����˻�����ʶ����ͬ�У�");  
                    article.setPicUrl("http://www.sinaimg.cn/qc/photo_auto/photo/79/07/40067907/40067907_950.jpg");  
                    article.setUrl("http://blog.csdn.net/hkh_1012");  
                    articleList.add(article);  
                    // ����ͼ����Ϣ����  
                    newsMessage.setArticleCount(articleList.size());  
                    // ����ͼ����Ϣ������ͼ�ļ���  
                    newsMessage.setArticles(articleList);  
                    // ��ͼ����Ϣ����ת����xml�ַ���  
                    respMessage = MessageUtil.newsMessageToXml(newsMessage);  
                }
                // ��ͼ����Ϣ---����ͼƬ  
                else if ("2".equals(reqContent)) {  
                    Article article = new Article();  
                    article.setTitle("΢�Ź����ʺſ����̳�Java��");  
                    // ͼ����Ϣ�п���ʹ��QQ���顢���ű���  
                    article.setDescription("���壬80��" +  emoji(0x1F6B9)   
                            + "��΢�Ź����ʺſ�������4���¡�Ϊ������ѧ�����ţ����Ƴ���ϵ�����ؽ̳̣�Ҳϣ����˻�����ʶ����ͬ�У�\n\nĿǰ���Ƴ��̳̹�12ƪ�������ӿ����á���Ϣ��װ����ܴ��QQ���鷢�͡����ű��鷢�͵ȡ�\n\n���ڻ��ƻ��Ƴ�һЩʵ�ù��ܵĿ������⣬���磺����Ԥ�����ܱ����������칦�ܵȡ�");  
                    // ��ͼƬ��Ϊ��  
                    article.setPicUrl("");  
                    article.setUrl("http://blog.csdn.net/lyq8479");  
                    articleList.add(article);  
                    newsMessage.setArticleCount(articleList.size());  
                    newsMessage.setArticles(articleList);  
                    respMessage = MessageUtil.newsMessageToXml(newsMessage);  
                }  
             // ��ͼ����Ϣ  
                else if ("3".equals(reqContent)) {  
                    Article article1 = new Article();  
                    article1.setTitle("΢�Ź����ʺſ����̳�\n����");  
                    article1.setDescription("");  
                    article1.setPicUrl("http://0.xiaoqrobot.duapp.com/images/avatar_liufeng.jpg");  
                    article1.setUrl("http://blog.csdn.net/lyq8479/article/details/8937622");  
  
                    Article article2 = new Article();  
                    article2.setTitle("��2ƪ\n΢�Ź����ʺŵ�����");  
                    article2.setDescription("");  
                    article2.setPicUrl("http://avatar.csdn.net/1/4/A/1_lyq8479.jpg");  
                    article2.setUrl("http://blog.csdn.net/lyq8479/article/details/8941577");  
  
                    Article article3 = new Article();  
                    article3.setTitle("��3ƪ\n����ģʽ���ü��ӿ�����");  
                    article3.setDescription("");  
                    article3.setPicUrl("http://avatar.csdn.net/1/4/A/1_lyq8479.jpg");  
                    article3.setUrl("http://blog.csdn.net/lyq8479/article/details/8944988");  
  
                    articleList.add(article1);  
                    articleList.add(article2);  
                    articleList.add(article3);  
                    newsMessage.setArticleCount(articleList.size());  
                    newsMessage.setArticles(articleList);  
                    respMessage = MessageUtil.newsMessageToXml(newsMessage);  
                }  
                // ��ͼ����Ϣ---������Ϣ����ͼƬ  
                else if ("4".equals(reqContent)) {  
                    Article article1 = new Article();  
                    article1.setTitle("΢�Ź����ʺſ����̳�Java��");  
                    article1.setDescription("");  
                    // ��ͼƬ��Ϊ��  
                    article1.setPicUrl("");  
                    article1.setUrl("http://blog.csdn.net/lyq8479");  
  
                    Article article2 = new Article();  
                    article2.setTitle("��4ƪ\n��Ϣ����Ϣ�����ߵķ�װ");  
                    article2.setDescription("");  
                    article2.setPicUrl("http://avatar.csdn.net/1/4/A/1_lyq8479.jpg");  
                    article2.setUrl("http://blog.csdn.net/lyq8479/article/details/8949088");  
  
                    Article article3 = new Article();  
                    article3.setTitle("��5ƪ\n������Ϣ�Ľ�������Ӧ");  
                    article3.setDescription("");  
                    article3.setPicUrl("http://avatar.csdn.net/1/4/A/1_lyq8479.jpg");  
                    article3.setUrl("http://blog.csdn.net/lyq8479/article/details/8952173");  
  
                    Article article4 = new Article();  
                    article4.setTitle("��6ƪ\n�ı���Ϣ�����ݳ������ƽ���");  
                    article4.setDescription("");  
                    article4.setPicUrl("http://avatar.csdn.net/1/4/A/1_lyq8479.jpg");  
                    article4.setUrl("http://blog.csdn.net/lyq8479/article/details/8967824");  
  
                    articleList.add(article1);  
                    articleList.add(article2);  
                    articleList.add(article3);  
                    articleList.add(article4);  
                    newsMessage.setArticleCount(articleList.size());  
                    newsMessage.setArticles(articleList);  
                    respMessage = MessageUtil.newsMessageToXml(newsMessage);  
                }  
                // ��ͼ����Ϣ---���һ����Ϣ����ͼƬ  
                else if ("5".equals(reqContent)) {  
                    Article article1 = new Article();  
                    article1.setTitle("��7ƪ\n�ı���Ϣ�л��з���ʹ��");  
                    article1.setDescription("");  
                    article1.setPicUrl("http://0.xiaoqrobot.duapp.com/images/avatar_liufeng.jpg");  
                    article1.setUrl("http://blog.csdn.net/lyq8479/article/details/9141467");  
  
                    Article article2 = new Article();  
                    article2.setTitle("��8ƪ\n�ı���Ϣ��ʹ����ҳ������");  
                    article2.setDescription("");  
                    article2.setPicUrl("http://avatar.csdn.net/1/4/A/1_lyq8479.jpg");  
                    article2.setUrl("http://blog.csdn.net/lyq8479/article/details/9157455");  
  
                    Article article3 = new Article();  
                    article3.setTitle("����������¶���������������ͨ���������Ի��ע΢�Ź����ʺ�xiaoqrobot��֧�����壡");  
                    article3.setDescription("");  
                    // ��ͼƬ��Ϊ��  
                    article3.setPicUrl("");  
                    article3.setUrl("http://blog.csdn.net/lyq8479");  
  
                    articleList.add(article1);  
                    articleList.add(article2);  
                    articleList.add(article3);  
                    newsMessage.setArticleCount(articleList.size());  
                    newsMessage.setArticles(articleList);  
                    respMessage = MessageUtil.newsMessageToXml(newsMessage);  
                }  
                
            }  
            // ͼƬ��Ϣ  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {  
                respContent = "�����͵���ͼƬ��Ϣ��";  
            }  
            // ����λ����Ϣ  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {  
                respContent = "�����͵��ǵ���λ����Ϣ��";  
            }  
            // ������Ϣ  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {  
                respContent = "�����͵���������Ϣ��";  
            }  
            // ��Ƶ��Ϣ  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {  
                respContent = "�����͵�����Ƶ��Ϣ��";  
            }  
            // ��Ƶ��Ϣ  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) {  
                respContent = "�����͵�����Ƶ��Ϣ��";  
            } 
            // С��Ƶ��Ϣ  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_SHORTVIDEO)) {  
                respContent = "�����͵���С��Ƶ��Ϣ��";  
            } 
            
            // �¼�����  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {  
                // �¼�����  
                String eventType = requestMap.get("Event");  
                // ����  
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {  
                    respContent = "лл���Ĺ�ע��";  
                }  
                // ȡ������  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {  
                    // TODO ȡ�����ĺ��û����ղ������ںŷ��͵���Ϣ����˲���Ҫ�ظ���Ϣ  
                }  
                // �Զ���˵�����¼�  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {  
                    // TODO �Զ���˵�Ȩû�п��ţ��ݲ����������Ϣ  
                }  
                // �Զ���˵�����¼�  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_VIEW)) {  
                    // TODO �Զ���˵�Ȩû�п��ţ��ݲ����������Ϣ  
                }  
            }  
//            textMessage.setContent(respContent);  
//            respMessage = MessageUtil.textMessageToXml(textMessage); 
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        return respMessage;  
    }  
    
    /** 
     * emoji����ת��(hex -> utf-16) 
     *  
     * @param hexEmoji 
     * @return 
     */  
    public static String emoji(int hexEmoji) {  
        return String.valueOf(Character.toChars(hexEmoji));  
    }  
} 

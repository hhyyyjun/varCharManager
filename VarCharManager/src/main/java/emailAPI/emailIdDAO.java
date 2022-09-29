package emailAPI;

import java.util.Date;
import java.util.Properties;


import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import member.MemberDAO;
import member.MemberVO;


 
public class emailIdDAO {
	MemberDAO mDAO = new MemberDAO();
	//  public static void main(String args[]) { sendMail(); }
	 
	
	public String sendIdMail(MemberVO mvo) {
	// 아이디 찾아서 set
	mvo.setMid(mDAO.findId(mvo));
    // 메일 인코딩
    final String bodyEncoding = "UTF-8"; //콘텐츠 인코딩
    
    String subject = "<VARCHAR> 비밀번호 찾기 안내"; //메일 제목
    String fromEmail = "yimhw77@naver.com"; //발신자 이메일
    String fromUsername = "<VARCHAR>";  //발신자 정보
    String toEmail = mvo.getMemail(); // 콤마(,)로 여러개 나열
    
    final String username = "yimhw7@gmail.com";//구글 계정    
    final String password = "uwuyeyklrilaazqz";//발급받은 앱 비밀번호
    
    // 메일에 출력할 텍스트
    StringBuffer sb = new StringBuffer();
    sb.append("안녕하세요 [VARCHAR] 입니다.\n");
    if(mvo.getMid() != null) { 
    	sb.append(mvo.getMname()+"님의 아이디는" + mvo.getMid() + "입니다.");      
    } 
    else {
    	sb.append("죄송합니다. 입력하신 하신 정보에 해당되는 아이디를 찾을 수 없습니다.");
    }
    String html = sb.toString();
  
 
    // 메일 옵션 설정
    Properties props = new Properties();    
    props.put("mail.transport.protocol", "smtp");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "465");
    props.put("mail.smtp.auth", "true");
 
    props.put("mail.smtp.quitwait", "false");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.socketFactory.fallback", "false");
    
    String mid = mvo.getMid();
    
    try {
      // 메일 서버  인증 계정 설정
      Authenticator auth = new Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(username, password);
        }
      };
      
      // 메일 세션 생성
      Session session = Session.getInstance(props, auth);
      
      // 메일 송/수신 옵션 설정
      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress(fromEmail, fromUsername));
      message.setRecipients(RecipientType.TO, InternetAddress.parse(toEmail, false));
      message.setSubject(subject);
      message.setSentDate(new Date());
      
      // 메일 콘텐츠 설정
      Multipart mParts = new MimeMultipart();
      MimeBodyPart mTextPart = new MimeBodyPart();
      MimeBodyPart mFilePart = null;
 
      // 메일 콘텐츠 - 내용
      mTextPart.setText(html, bodyEncoding, "html");
      mParts.addBodyPart(mTextPart);
            
      // 메일 콘텐츠 설정
      message.setContent(mParts);
      
      // MIME 타입 설정
      MailcapCommandMap MailcapCmdMap = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
      MailcapCmdMap.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
      MailcapCmdMap.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
      MailcapCmdMap.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
      MailcapCmdMap.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
      MailcapCmdMap.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
      CommandMap.setDefaultCommandMap(MailcapCmdMap);
 
      // 메일 발송
      Transport.send( message );
      
    } catch ( Exception e ) {
      e.printStackTrace();
    }
    return mid; //사용자 아이디
  }
  

 
}
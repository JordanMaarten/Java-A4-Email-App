package app.models;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Date;
import java.util.Properties;

public class EmailModel extends Model {

  private String email_sender;
  private char[] email_password;
  private String email_recipient;
  private String email_subject;
  private String email_body;

  public void setEmailSender(String EMAIL_SENDER) {
    this.email_sender = EMAIL_SENDER;
  }
  
  public void setEmailPassword(char[] EMAIL_PASSWORD) {
    this.email_password = EMAIL_PASSWORD;
  }

  public void setEmailRecipient(String EMAIL_RECIPIENT) {
    this.email_recipient = EMAIL_RECIPIENT;
  }

  public void setEmailSubject(String EMAIL_SUBJECT) {
    this.email_subject = EMAIL_SUBJECT;
  }

  public void setEmailBody(String EMAIL_BODY) {
    this.email_body = EMAIL_BODY;
  }


  public Boolean sendEmail() {
    
    StringBuilder password_string = new StringBuilder();
    
    for (char c : email_password) {
      password_string.append(c);
    }
    
    final String final_username = this.email_sender;
    final String final_password = password_string.toString();
    
    Properties properties = System.getProperties();
    properties.put("mail.smtp.starttls.enable", "true");
    properties.put("mail.smtp.port", "25");
    properties.put("mail.smtp.host", "127.0.0.1");
    properties.put("mail.smtp.auth", "true");

    boolean success_status;

    try {

      Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(final_username, final_password);
                    }
                }
      );

      MimeMessage msg = new MimeMessage(session);

      msg.setFrom(new InternetAddress(this.email_sender));

      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(this.email_recipient));

      msg.setSubject(this.email_subject);

      msg.setText(this.email_body);

      msg.setSentDate(new Date());

      Transport.send(msg);

      success_status = true;

    } catch (Exception e) {
      e.printStackTrace();

      success_status = false;
    }

    return success_status;
  }
}

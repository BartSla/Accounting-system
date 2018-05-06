package pl.coderstrust.processing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderImpl{

  @Value("${sentFrom}")
  String sentFrom;

  @Value("${replyTo}")
  String replyTo;

  private static final Logger logger = LoggerFactory.getLogger(EmailSenderImpl.class);

  @Autowired
  public JavaMailSender javaMailSender;

  public void sendEmail(String emailTo, String emailTitle, String emailContent) {
    SimpleMailMessage mail = new SimpleMailMessage();
    mail.setFrom(sentFrom);
    mail.setReplyTo(replyTo);
    mail.setTo(emailTo);
    mail.setSubject(emailTitle);
    mail.setText(emailContent);

    javaMailSender.send(mail);
    logger.info(mail.toString());
  }
}
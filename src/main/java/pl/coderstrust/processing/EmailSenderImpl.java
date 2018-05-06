package pl.coderstrust.processing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderImpl{

  private static final Logger logger = LoggerFactory.getLogger(EmailSenderImpl.class);

  @Autowired
  public JavaMailSender javaMailSender;

  public void sendEmail(String emailTo, String emailTitle, String emailContent) {
    SimpleMailMessage mail = new SimpleMailMessage();

    mail.setFrom("Bartek");
    mail.setTo(emailTo);
    mail.setSubject(emailTitle);
    mail.setText(emailContent);

    logger.info("Sending...");

    javaMailSender.send(mail);
    logger.info("Send");

  }
}
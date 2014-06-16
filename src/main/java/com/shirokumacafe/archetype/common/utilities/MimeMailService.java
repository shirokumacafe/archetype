package com.shirokumacafe.archetype.common.utilities;

import com.shirokumacafe.archetype.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * MIME邮件服务类.
 * 
 * @author calvin
 */
public class MimeMailService {
	private static Logger logger = LoggerFactory.getLogger(MimeMailService.class);
    private static final String DEFAULT_ENCODING = "utf-8";
	private JavaMailSender mailSender;
	private String registerTemplate;


	public void sendRegisterMail(User user) {
        try {
            MimeMessage msg = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(msg, true, DEFAULT_ENCODING);
            helper.setFrom("from");
            helper.setTo(user.getEmail());
            helper.setSubject("新帐号注册通知");

            String content = registerTemplate.replace("{loginName}",user.getLoginName());
            helper.setText(content,true);
            mailSender.send(msg);

            logger.info("HTML版邮件已发送至:{}",user.getEmail());
        } catch (MessagingException e) {
            logger.info("HTML版邮件发送失败", e);
        }
    }


	/**
	 * Spring的MailSender.
	 */
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

    public void setRegisterTemplate(String registerTemplate) {
        this.registerTemplate = registerTemplate;
    }
}

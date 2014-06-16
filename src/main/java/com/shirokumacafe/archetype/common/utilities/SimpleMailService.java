/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.shirokumacafe.archetype.common.utilities;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * 纯文本邮件服务类.
 * 
 * @author calvin
 */
public class SimpleMailService {
	private static Logger logger = LoggerFactory.getLogger(SimpleMailService.class);

	private JavaMailSender mailSender;

    /**
     * 发送纯文本的通知邮件.
     */
    public void sendMail(SimpleMailMessage msg){
        try {
            mailSender.send(msg);
            if (logger.isInfoEnabled()) {
                logger.info("纯文本邮件已发送至{}", StringUtils.join(msg.getTo(), ","));
            }
        } catch (Exception e) {
            logger.error("发送邮件失败", e);
        }
    }

	/**
	 * Spring的MailSender.
	 */
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

}

package com.twentyat.mail;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 * Class for sending e-mail messages based on Velocity templates or with
 * attachments.
 * 
 * @author Bipin Sutariya
 * 
 */ 
public class MailEngine {
    private final Log log = LogFactory.getLog(MailEngine.class);
    private JavaMailSender mailSender;
    private VelocityEngine velocityEngine;
    private String defaultFrom;
    private String defaultTo;

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }

    public void setFrom(String from) {
        this.defaultFrom = from;
    }

    public void setTo(String to) {
        this.defaultTo = to;
    }
    
    public String createEmailBody(String templateName, Map model){
        String result = null;
        
        try {
            result = VelocityEngineUtils.mergeTemplateIntoString(
                    velocityEngine, templateName, model);
        } catch (VelocityException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        
        return result;
    }

    /**
     * Send a simple message based on a Velocity template.
     * 
     * @param msg
     *            the message to populate
     * @param templateName
     *            the Velocity template to use (relative to classpath)
     * @param model
     *            a map containing key/value pairs
     */
    public void sendMessage(SimpleMailMessage msg, String templateName,
            Map model) {
        String result = createEmailBody(templateName, model);

        msg.setText(result);
        send(msg);
    }

    /**
     * Send a simple message with pre-populated values.
     *
     * @param msg
     *            the message to send
     * @throws org.springframework.mail.MailException
     *             when SMTP server is down
     */
    public void send(SimpleMailMessage msg) throws MailException {
        try {
            mailSender.send(msg);
        } catch (MailException ex) {
            // log it and go on
            log.error(ex.getCause().getMessage());
            throw ex;
        }
    }

    /**
     * Convenience method for sending messages with attachments.
     * 
     * @param recipients
     *            array of e-mail addresses
     * @param sender
     *            e-mail address of sender
     * @param attachmentResource
     *            attachment from classpath
     * @param bodyText
     *            text in e-mail
     * @param subject
     *            subject of e-mail
     * @param attachmentName
     *            name for attachment
     * @throws MessagingException
     *             thrown when can't communicate with SMTP server
     */
    public void sendMessage(String[] recipients, String sender,
            String bodyText, String subject,
            ClassPathResource attachmentResource, String attachmentName)
            throws MessagingException {
        MimeMessage message = ((JavaMailSenderImpl) mailSender)
                .createMimeMessage();

        // use the true flag to indicate you need a multi-part message
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        
        // use the default recipient if no recipients specified
        if (recipients != null && recipients.length > 0) {
            helper.setTo(recipients);
        } else {
            helper.setTo(defaultTo);
        }

        // use the default sender if no sender specified
        if (sender == null) {
            helper.setFrom(defaultFrom);
        } else {
            helper.setFrom(sender);
        }

        helper.setText(bodyText);
        helper.setSubject(subject);

                                if (attachmentName != null && attachmentResource != null){
                helper.addAttachment(attachmentName, attachmentResource);
        }
        
        mailSender.send(message);
    }

        /**
        * Convenience method for sending messages with attachments.
        * 
        * @param recipients
        *            array of e-mail addresses
        * @param sender
        *            e-mail address of sender
        * @param templateName
        *            the Velocity template to use (relative to classpath)
        * @param model
        *            a map containing key/value pairs
        * @param subject
        *            subject of e-mail
        * @param attachmentFiles
        *            attachments from Files (base names used as attachment names)
        * @throws MessagingException
        *             thrown when can't communicate with SMTP server
        */
        public void sendMessage(String[] recipients, String sender,
                String templateName, Map model, String subject,
                File[] attachmentFiles) throws MessagingException {
                MimeMessage message = ((JavaMailSenderImpl) mailSender)
                        .createMimeMessage();

                // use the true flag to indicate you need a multi-part message
                MimeMessageHelper helper = new MimeMessageHelper(message, true);

                // use the default recipient if no recipients specified
                if (recipients != null && recipients.length > 0) {
                        helper.setTo(recipients);
                } else {
                        helper.setTo(defaultTo);
                }

                // use the default sender if no sender specified
                if (sender == null) {
                        helper.setFrom(defaultFrom);
                } else {
                        helper.setFrom(sender);
                }
                String bodyText = createEmailBody(templateName, model);

                helper.setText(bodyText);
                helper.setSubject(subject);

                if (attachmentFiles != null) {
                        for (int i = 0; i < attachmentFiles.length; i++) {
                                if (attachmentFiles[i].exists()) {
                                        helper.addAttachment(attachmentFiles[i].getName(),
                                                attachmentFiles[i]);
                                }
                        }
                }

        mailSender.send(message);
        }

    public String[] getRecipients(String to, String cc){
        
        if (log.isDebugEnabled()){
                log.debug("//=======================================================================//");
                log.debug("//===== Get Recipients ==================================================//");
                log.debug("//===== TO: " + to);
                log.debug("//===== CC: " + cc);
                log.debug("//=======================================================================//");
        }
        
        ArrayList<String> recipients = null;
        
        if (to != null && to.trim().length() != 0){
                        if (recipients == null) {
                                recipients = new ArrayList<String>();
                        }
                recipients.add(to);
        }
                
                if (cc != null && cc.trim().length() != 0){
                        if (recipients == null) {
                                recipients = new ArrayList<String>();
                        }
                        String[] ccArray = cc.split(";");
                        for(String email : ccArray) {
                                if (email != null && email.trim().length() != 0){
                                        recipients.add(email);
                                }
                        }
                }
                
        if (log.isDebugEnabled()){
                log.debug("//===== Recipients[] ====================================================//");
                if (recipients != null) {
                        for (String recipient : recipients){
                                log.debug("//===== " + recipient);
                        }
                } else {
                        log.debug("//===== null");
                }
                log.debug("//=======================================================================//");
        }

        if (recipients == null){
                return null;
        } else {
                return (String[]) recipients.toArray(new String[0]);
        }
    }
    
}

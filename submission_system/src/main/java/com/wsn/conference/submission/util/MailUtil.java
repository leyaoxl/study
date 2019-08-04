package com.wsn.conference.submission.util;

import com.wsn.conference.submission.entity.Email;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.Future;
import java.util.logging.Logger;

/**
 * @author leyao
 * @version 2018-7-17
 */
@Component
public class MailUtil {
    private Logger logger = Logger.getLogger(MailUtil.class.getName());

    /*
    自动注入JavaMailSender
     */
    @Autowired
    private JavaMailSender javaMailSender;

    /*
    自动注入freemarker配置
     */
    @Autowired
    public Configuration configuration;

    @Value("${spring.mail.username}")
    private String SENDER;

    /*
    将系统对过长字符串截取的属性修改为false
    避免附件文件名乱码
     */
    static {
        System.setProperty("mail.mime.splitlongparameters", "false");
    }

    /**
     * 发送简单邮件
     *
     * @param email
     */
    @Async("emailTaskExecutor")
    public Future<String> sendSimpleMail(Email email) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(SENDER);
        simpleMailMessage.setTo(email.getReciever());
        simpleMailMessage.setSubject(email.getSubject());
        simpleMailMessage.setText(email.getContent());
        try {
            javaMailSender.send(simpleMailMessage);
            logger.info("===== 邮件发送成功 ===== leyao =====");
            return new AsyncResult<>("该邮件发送成功： " + email.getReciever());
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.info("===== 邮件发送失败 ===== leyao =====");
            return new AsyncResult<>("该邮件发送失败： " + email.getReciever());
        }
    }

    /*
    发送freemarker模板邮件
     */
    @Async("emailTaskExecutor")
    public Future<String> sendTemplateMail(Email email) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(SENDER);
            helper.setTo(email.getReciever());
            helper.setSubject(email.getSubject());
            HashMap<String, HashMap<String, String>> model = new HashMap<>();
            model.put("mailMap", email.getMailMap());
            Template template = configuration.getTemplate(email.getTemplate() + ".ftl");
            String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            helper.setText(text, true);
            javaMailSender.send(message);
            logger.info("===== 邮件发送成功 ===== leyao =====");
            return new AsyncResult<>("该邮件发送成功： " + email.getReciever());
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.info("===== 邮件发送失败 ===== leyao =====");
            return new AsyncResult<>("该邮件发送失败： " + email.getReciever());
        }
    }

    /*
    发送freemarker模板邮件
     */
    @Async("emailTaskExecutor")
    public Future<String> sendTemplateMailWithAttachment(Email email, FileSystemResource fileSystemResource) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(SENDER);
            helper.setTo(email.getReciever());
            helper.setSubject(email.getSubject());
            HashMap<String, HashMap<String, String>> model = new HashMap<>();
            model.put("mailMap", email.getMailMap());
            Template template = configuration.getTemplate(email.getTemplate() + ".ftl");
            String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            helper.setText(text, true);
            helper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
            javaMailSender.send(message);
            logger.info("===== 邮件发送成功 ===== leyao =====");
            return new AsyncResult<>("该邮件发送成功： " + email.getReciever());
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.info("===== 邮件发送失败 ===== leyao =====");
            return new AsyncResult<>("该邮件发送失败： " + email.getReciever());
        }
    }
}

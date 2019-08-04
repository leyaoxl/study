package com.wsn.conference.submission.entity;

import java.util.HashMap;

/**
 * @author leyao
 * @version 2018-7-18
 */
public class Email {
    private String reciever;
    private String subject;
    private String content;

    private String template;
    private HashMap<String, String> mailMap;

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public String getReciever() {
        return reciever;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getTemplate() {
        return template;
    }

    public void setMailMap(HashMap<String, String> mailMap) {
        this.mailMap = mailMap;
    }

    public HashMap<String, String> getMailMap() {
        return mailMap;
    }

    @Override
    public String toString() {
        return "reciever: " + reciever + ", " +
                "subject: " + subject + ", " +
                "content: " + content + ", " +
                "template: " + template + ", " +
                "mailMap: " + mailMap;
    }
}

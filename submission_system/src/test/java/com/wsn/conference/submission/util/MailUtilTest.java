package com.wsn.conference.submission.util;

import com.wsn.conference.submission.entity.Email;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//该注解表明在测试环境
@RunWith(SpringRunner.class)
//该注解启动整个spring-boot程序
@SpringBootTest
public class MailUtilTest {
    @Autowired
    private MailUtil mailUtil;

    // @Test
    // public void sendSimpleMailTest() {
    //     Email email = new Email();
    //     email.setReciever("leyaoxl@gmail.com");
    //     email.setSubject("测试");
    //     email.setContent("我是中国人");
    //     mailUtil.sendSimpleMail(email);
    // }

    @Test
    public void sendTemplateMailTest() {
        Email email = new Email();
    }
}

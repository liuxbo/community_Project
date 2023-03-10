package com.nowcoder.community;

import com.nowcoder.community.util.MailClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTests {

    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testTextMail(){
        mailClient.sendMail("24520211154656@stu.xmu.edu.cn","test1","11");
    }

    @Test
    public void testHtmlMail(){
        Context context = new Context();
        context.setVariable("username","lxb1");
        String content = templateEngine.process("/mail/demo", context);
        System.out.println(content);
        mailClient.sendMail("24520211154656@stu.xmu.edu.cn","HtmlTest",content);
    }
}

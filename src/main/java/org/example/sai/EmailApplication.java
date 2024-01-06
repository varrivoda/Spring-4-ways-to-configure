package org.example.sai;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmailApplication {


    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        EmailClient emailClient = context.getBean("emailClient", EmailClient.class);// = new EmailClient(new BasicSpellChecker());

        emailClient.sendEmail("my first Email");
        emailClient.sendEmail("my second Email");


    }
}
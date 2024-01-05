package org.example.sai;

public class EmailApplication {


    public static void main(String[] args) {

        EmailClient emailClient = new EmailClient(new BasicSpellChecker());

        emailClient.sendEmail("my first Email");
        emailClient.sendEmail("my second Email");


    }
}
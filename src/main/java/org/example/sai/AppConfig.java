package org.example.sai;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    SpellChecker spellChecker(){
        return new BasicSpellChecker();
    }

    @Bean
    EmailClient emailClient(){
        return new EmailClient(spellChecker());
    }
}

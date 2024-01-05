package org.example.sai;

public class EmailClient {
    SpellChecker spellChecker;

    public EmailClient(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }

    void sendEmail(String message){
        spellChecker.checkSpelling(message);
    }

}

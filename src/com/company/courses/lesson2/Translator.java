package com.company.courses.lesson2;

import java.util.Locale;
import java.util.ResourceBundle;

public class Translator {
    private final ResourceBundle bundle;
    public Translator(String language) {
        bundle = ResourceBundle.getBundle("messages", new Locale(language), new UTF8Control());
    }
    public Translator() {
        bundle = ResourceBundle.getBundle("messages");
    }
    public String getHeader() {
        return bundle.getString("header");
    }
}

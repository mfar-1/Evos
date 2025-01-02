package org.example;

import java.util.Locale;
import java.util.ResourceBundle;

public class Language {
    ResourceBundle lan=ResourceBundle.getBundle("messages", Locale.forLanguageTag("eng"));

    public void change() {
        while (true){
            System.out.println("""
                    1.Changing language/Tilni ozgartirish
                    2.back
                    """);
            switch (Input.num(lan.getString("CHOOSING"))) {
                case 1->{
                    engUz();
                    return;
                }
                case 2->{
                    return;
                }
                default -> System.out.println(";(");
            }
        }
    }

    private void engUz() {
        while (true){
            System.out.println("""
                    1.Uz
                    2.Eng
                    """);
            switch (Input.num(lan.getString("CHOOSING"))) {
                case 1->{
                    lan=ResourceBundle.getBundle("messages", Locale.forLanguageTag("uz"));
                    return;
                }
                case 2->{
                    lan=ResourceBundle.getBundle("messages", Locale.forLanguageTag("eng"));
                    return;
                }
                default -> System.out.println(";(");
            }
        }
    }
}

package org.example;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Language language=new Language();
        WorkingPlace workingPlace=new WorkingPlace(language);

        while (true){
            System.out.println(language.lan.getString("ENTERING"));
            switch (Input.num(language.lan.getString("CHOOSING"))) {
                case 1->workingPlace.menu();
                case 2->workingPlace.orders();
                case 3->workingPlace.changingLanguage();
                default -> System.out.println("Kechirasiz ammmo siz xato son kiritdingiz");
            }
        }
    }
}

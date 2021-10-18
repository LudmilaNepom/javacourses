package com.company.courses.lesson2;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static String[] languages  = new String[]{"en", "uk", "ru"};
    public static void main(String[] args) {
        printHeader(args);
        new ConsoleManager(new Scanner(System.in)).read(new FileManager(Paths.get("").toAbsolutePath()));
    }

    private static void printHeader(String[] args) {
        if (args.length < 1) {
            System.out.println(new Translator().getHeader());
        } else {
            if (notValid(args[0])) {
                System.out.println("Warning: language " + args[0] + "not supported, applied default - en");
                System.out.println(new Translator().getHeader());
            } else {
                System.out.println(new Translator(args[0]).getHeader());
            }
        }
    }

    private static boolean notValid(String language) {
        return Arrays.stream(languages).noneMatch(validLanguage -> Objects.equals(validLanguage, language));
    }
}

package com.company.courses.lesson2;

import java.util.Scanner;

public class ConsoleManager {
    private final Scanner console;

    public ConsoleManager(Scanner console) {
        console.useDelimiter(";|\r?\n|\r");
        this.console = console;
    }

    public void read(FileManager fileManager) {
        boolean exit = false;
        while (!exit) {
           String input = console.nextLine();
           String command;
           String target;
           if (input.startsWith("cd")) {
               command = "cd";
               target = input.substring(2).trim();
           } else {
               command = input;
               target = input;
           }
           switch (command) {
               case "cd":
                   fileManager.changeDirectory(target);
                   break;
               case "..":
                   fileManager.changeDirectoryLevelUp();
                   break;
               default:
                   fileManager.printTextFileFromCurrentDirectory(target);
           }
        }
    }
}

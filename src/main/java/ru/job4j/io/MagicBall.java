package ru.job4j.io;
import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static String magicAnswer() {
        int answer = new Random().nextInt(3);
        switch (answer) {
            case 0 -> {
                return "да";
            }
            case 1 -> {
                return "нет";
            }
            default -> {
                return "Может быть";
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        String name = input.nextLine();
        if (!name.isEmpty() && name.indexOf("?") == name.length() - 1) {
           System.out.println(magicAnswer());
        }
    }
}

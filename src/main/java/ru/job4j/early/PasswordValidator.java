package ru.job4j.early;

import static java.lang.Character.*;

public class PasswordValidator {
    private static boolean containOneFigure(char[] passwdArray) {
        for (char passwdchar : passwdArray) {
            if (isDigit(passwdchar)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containUpperCase(char[] passwdArray) {
        for (char passwdchar : passwdArray) {
            if (isUpperCase(passwdchar)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containLowCase(char[] passwdArray) {
        for (char passwdchar : passwdArray) {
            if (isLowerCase(passwdchar)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containSpecialSymbol(char[] passwdArray) {
        for (char passwdchar : passwdArray) {
            if (!isLowerCase(passwdchar) && !isUpperCase(passwdchar) && !isDigit(passwdchar)) {
                return true;
            }
        }
        return false;
    }

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        String[] paterns = new String[]{"qwerty", "12345", "password", "admin", "user"};
        for (String patern : paterns) {
            if (password.toLowerCase().indexOf(patern) >= 0) {
                throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
            }
        }
        char[] passwdArray = password.toCharArray();
        if (!containOneFigure(passwdArray)) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!containUpperCase(passwdArray)) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!containLowCase(passwdArray)) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!containSpecialSymbol(passwdArray)) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        return password;
    }
}

package ru.job4j.early;

import static java.lang.Character.*;

public class PasswordValidator {

    private static void contain(char[] passwdArray) {
        int rslDig = 0;
        int rslUp = 0;
        int rslLo = 0;
        int rslSim = 0;
        for (char passwdchar : passwdArray) {
            if (isDigit(passwdchar)) {
                rslDig++;
            }
            if (isUpperCase(passwdchar)) {
                rslUp++;
            }
            if (isLowerCase(passwdchar)) {
                rslLo++;
            }
            if (!isLowerCase(passwdchar) && !isUpperCase(passwdchar) && !isDigit(passwdchar)) {
                rslSim++;
            }
            if (rslDig > 0 && rslUp > 0 && rslLo > 0 && rslSim > 0) {
                break;
            }
        }
        if (rslDig == 0) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (rslUp == 0) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (rslLo == 0) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (rslSim == 0) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
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
        contain(password.toCharArray());
        return password;
    }
}

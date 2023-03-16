package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void getCondition() {
        System.out.println("active: " + this.active);
        System.out.println("status: " + this.status);
        System.out.println("message: " + this.message);
    }

    public static void main(String[] args) {
        Error first = new Error();
        Error second = new Error(true, 2, "Permission denied");
        first.getCondition();
        second.getCondition();
    }
}

package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Иванов Иван Иванович");
        student.setGroup("IIT-01");
        student.setDateOfApply(new Date());
        System.out.println("Full Name: " + student.getFullName()
                + "\nGroup: " + student.getGroup()
                + "\nDate of Applying: " + student.getDateOfApply());
    }
}

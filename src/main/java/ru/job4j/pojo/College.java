package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Иванов Иван Иванович");
        student.setGroup("IIT-01");
        student.setDateOfApply(new Date());
        String ln = System.lineSeparator();
        System.out.println("Full Name: " + student.getFullName()
                + ln + "Group: " + student.getGroup()
                + ln + "Date of Applying: " + student.getDateOfApply());
    }
}

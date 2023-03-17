package ru.job4j.pojo;

import java.util.Date;

public class Student {
    private String fullName;
    private String group;
    private Date dateOfApply;

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setDateOfApply(Date dateOfApply) {
        this.dateOfApply = dateOfApply;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGroup() {
        return group;
    }

    public Date getDateOfApply() {
        return dateOfApply;
    }
}

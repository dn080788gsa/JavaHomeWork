package com.pb.gorban.hw11;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Contact {
    private String name;
    private String birthDate;
    private ArrayList<String> phones = new ArrayList<String>();
    private String path;
    private long changeTime;

    public Contact(String name, String birthDate, ArrayList<String> phones, String path) {
        this.name = name;
        this.birthDate = birthDate;
        this.phones = phones;
        this.path = path;
        setChangeTime();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public ArrayList<String> getPhones() {
        return phones;
    }

    public void setPhones(String phone) {
        this.phones.add(phone);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getChangeTime() {
        return changeTime;
    }

    public void setChangeTime() {
        Date date = new Date();
        this.changeTime = date.getTime();
    }

    @Override
    public String toString() {
        Date date = new Date(getChangeTime());
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("E yyyy.MM.dd hh:mm:ss a zzz");
        String dateStr = formatForDateNow.format(date);
        return "{phones: " + getPhones().toString() + ", address: " + getPath() + ", birth date: " + getBirthDate() + ", change time: " + dateStr + "}";
    }

}

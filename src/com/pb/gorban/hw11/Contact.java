package com.pb.gorban.hw11;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
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

    public static class ContactNameComparator implements Comparator<Contact> {

        @Override
        public int compare(Contact contact1, Contact contact2) {
            return contact1.getName().compareTo(contact2.getName());
        }
    }

    public static class ContactChangeTimeComparator implements Comparator<Contact> {

        @Override
        public int compare(Contact contact1, Contact contact2) {
            Date date1 = new Date(contact1.getChangeTime());
            Date date2 = new Date(contact2.getChangeTime());
            if (date1.getTime() > date2.getTime()) {
                return 1;
            } else if (date1.getTime() < date2.getTime()) {
                return -1;
            } else{
                return 0;
            }
        }
    }
}

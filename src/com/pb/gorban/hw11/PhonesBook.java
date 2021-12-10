package com.pb.gorban.hw11;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.*;


public class PhonesBook {
    static TreeMap<String, Contact> phonesBook = new TreeMap<>();

    //добавление элемента
    public void addContact(Contact contact) {
        phonesBook.put(contact.getName(), contact);
    }

    //удаление элемента
    public void deleteContact(String key) {
        phonesBook.remove(key);
    }

    //поиск элементов
    public Contact findContact (String key) {
        return  phonesBook.get(key);
    }

    //вывод всех записей с сортировкой по указанному полю (можно ограничиться двумя на выбор)
    public TreeMap<String, Contact> getAllBookSort() {
        TreeMap<String, Contact> sorted = new TreeMap<String, Contact>(new Comparator<String>() {
            @Override
            public int compare(String key1, String key2) {
                return key1.compareToIgnoreCase(key2);
            }
        });
        sorted.putAll(phonesBook);
        return sorted;
    }

    public TreeMap<String, Contact> getAllBook() {
        TreeMap<String, Contact> map = new TreeMap<String, Contact>();
        map.putAll(phonesBook);
        return map;
    }

    //редактирование элемента
    public void newEditContact(String name, String key, String val) {
        Contact contact = phonesBook.get(name);
        switch (key) {
            case "phone":
                contact.setPhones(val);
                break;
            case "birth_date":
                contact.setBirthDate(val);
                break;
            case "address":
                contact.setPath(val);
        }
    }

    public void edit(String key, Contact contact) {
        if (key.equals(contact.getName())) {
            phonesBook.put(key, contact);
        } else {
            phonesBook.put(contact.getName(), contact);
            phonesBook.remove(key);
        }
    }

    //запись в файл всех данных
    public void bookToFile(String fileName) throws IOException {
        File f1 = new File("files/" + fileName + ".txt");
        System.out.println("\nLoading contacts into phoneBook.txt ...");
        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter(f1));
        ObjectMapper objectMapper = new ObjectMapper();
        outputWriter.write(objectMapper.writeValueAsString(phonesBook));
        System.out.println("File location: " + f1.getAbsolutePath());
        outputWriter.flush();
        outputWriter.close();
    }

    public static TreeMap<String, Contact> bookFromJSON(String fileName) throws IOException {
        FileReader fr = new FileReader("files/" + fileName + ".txt");
        BufferedReader  br = new BufferedReader(fr);
        String json = "";

        while (br.ready())
        {
            json += br.readLine();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TreeMap<String, Contact> treeMap = objectMapper.readValue(json, TreeMap.class);

        br.close();
        fr.close();
        phonesBook = treeMap;
        return treeMap;
    }
}

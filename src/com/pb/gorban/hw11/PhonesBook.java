package com.pb.gorban.hw11;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class PhonesBook {
    private static TreeMap<String, Contact> phonesBook;

    public PhonesBook() {
        phonesBook = new TreeMap<>();
    }

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
        Contact contact = phonesBook.get(key);
        if (contact == null) {
            //производим поиск по phone во всех контактах
            for (Map.Entry<String, Contact> m: phonesBook.entrySet()) {
                Contact c = m.getValue();
                if (c.getPhones().contains(key)) {
                    contact = c;
                }
            }
        }
        return  contact;
    }

    //вывод всех записей с сортировкой по указанному полю (можно ограничиться двумя на выбор)
    public TreeMap<String, Contact> getAllBookSort() {
        Comparator<Contact> multiComp = new ContactNameComparator()
                .thenComparing(new ContactTimeComparator());

        TreeMap<String, Contact> unsorted = new TreeMap<>();
        TreeMap<String, Contact> sorted = new TreeMap<>();
        TreeSet<Contact> persons = new TreeSet<>(multiComp);
        unsorted.putAll(phonesBook);

        for (Map.Entry<String, Contact> c: unsorted.entrySet()) {
            persons.add(new Contact(c.getValue().getName(), c.getValue().getBirthDate(), c.getValue().getPhones(), c.getValue().getPath()));
        }

        persons.forEach(p -> sorted.put(p.getName(), unsorted.get(p.getName())));

        return sorted;
    }

    public TreeMap<String, Contact> getAllBook() {
        TreeMap<String, Contact> map = new TreeMap<>();
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
        TreeMap treeMap = objectMapper.readValue(json, TreeMap.class);

        br.close();
        fr.close();

        phonesBook.putAll(treeMap);
        return treeMap;
    }

    public static class ContactNameComparator implements Comparator<Contact> {
        @Override
        public int compare(Contact contact1, Contact contact2) {
            return contact1.getName().compareTo(contact2.getName());
        }
    }


    static class ContactTimeComparator implements Comparator<Contact> {

        @Override
        public int compare(Contact contact, Contact t1) {
            Date date1 = new Date(contact.getChangeTime());
            Date date2 = new Date(t1.getChangeTime());
            return Long.compare(date1.getTime(), date2.getTime());
        }
    }

}

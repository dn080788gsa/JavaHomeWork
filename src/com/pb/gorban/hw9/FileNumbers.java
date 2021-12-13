package com.pb.gorban.hw9;

import java.io.*;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileNumbers {

    public static void main(String[] args) {
       Logger LOGGER = Logger.getLogger(FileNumbers.class.getName());
//        LOGGER.setLevel(Level.ALL);
//        LOGGER.setUseParentHandlers(false);
//        ConsoleHandler consoleHandler = new ConsoleHandler();
//        consoleHandler.setLevel(Level.ALL);
//        LOGGER.addHandler(consoleHandler);

        LOGGER.entering("Start", "---->");
        LOGGER.log(Level.SEVERE, "LOGGING ------->>>");

        createNumbersFile();
        createOddNumbersFile();

        LOGGER.exiting(FileNumbers.class.getName(), "END---<<<");

    }

    public static void createNumbersFile() {
        OutputStream os = null;
        Logger LOGGER = Logger.getLogger(FileNumbers.class.getName());
        String[] strArr = getStringsArray();

        try {
            os = new FileOutputStream("files/numbers.txt", false);
            for (int i=0; i<strArr.length; i++) {
                byte[] dataBytes = strArr[i].getBytes();
                os.write(dataBytes, 0, dataBytes.length);
                if (i<(strArr.length-1)) {
                    os.write("\r\n".getBytes());
                }
            }
            os.close();
            System.out.println("FILE CREATED");
        } catch(Exception e) {
            LOGGER.log(Level.SEVERE, "ERROR", e);
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void createOddNumbersFile() {
        try (InputStream is = new FileInputStream("files/numbers.txt")) {
            int available = is.available();
            byte[] buffer = new byte[available];
            int i=0;
            int data = is.read();

            while (data != -1) {
                buffer[i] = (byte) data;
                data = is.read();
                i++;
            }

            String[] strArr = (new String(buffer)).split("\\n");
            String[] newStrArr = new String[strArr.length];

            for (int j=0; j<strArr.length; j++) {
                String[] rowNumbers = strArr[j].split(" ");
                String str = "";

                for (int k=0; k<rowNumbers.length; k++) {
                    int x;
                    try {
                        x = Integer.parseInt(rowNumbers[k]);
                        if (x%2 == 0) {
                            rowNumbers[k] = "0";
                        }
                        str += rowNumbers[k] + " ";

                    } catch (Exception e) {}

                }

                newStrArr[j] = str;
            }

            try (OutputStream os = new FileOutputStream("files/odd-numbers.txt")) {
                for (int z=0; z<newStrArr.length; z++) {
                    byte[] dataBytes = newStrArr[z].getBytes();
                    os.write(dataBytes, 0, dataBytes.length);
                    if (z<(newStrArr.length-1)) {
                        os.write("\r\n".getBytes());
                    }

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            System.out.println("NEW ODD FILE CREATED");

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    private static String createString() {
        String str = "";
        for (int i=0; i<10; i++) {
            str += (int) (Math.random() * 101);
            if (i<9) {
                str += " ";
            }
        }
        return str;
    }

    private static String[] getStringsArray() {
        String[] stringArray = new String[10];
        for (int i=0; i<10; i++) {
            stringArray[i] = createString();
        }
        return stringArray;
    }
}

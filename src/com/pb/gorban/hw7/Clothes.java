package com.pb.gorban.hw7;

abstract class Clothes {
    private Size size;
    private int prise;
    private String color;
    private String type;

    Clothes(String type, Size size, int prise, String color) {
        this.size = size;
        this.color = color;
        this.prise = prise;
        this.type = type;
    }

    public Size getSize() {
        return size;
    }

    public int getPrise() {
        return prise;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }
}

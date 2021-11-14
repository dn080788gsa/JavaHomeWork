package com.pb.gorban.hw7;

public class Pants extends Clothes implements ManClothes, WomenClothes{


    Pants(String type, Size size, int prise, String color) {
        super(type, size, prise, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Мужчина надел штаны");
    }

    @Override
    public void dressWomen() {
        System.out.println("Женщина надела штаны");
    }
}

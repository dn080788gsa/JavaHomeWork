package com.pb.gorban.hw7;

public class Tshirt extends Clothes implements ManClothes, WomenClothes{

    Tshirt(String type, Size size, int prise, String color) {
        super(type, size, prise, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Мужчина надел футболку");
    }

    @Override
    public void dressWomen() {
        System.out.println("Женщина надела футболку");
    }
}

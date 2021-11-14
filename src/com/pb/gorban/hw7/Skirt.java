package com.pb.gorban.hw7;

public class Skirt extends Clothes implements WomenClothes{

    Skirt(String type, Size size, int prise, String color) {
        super(type, size, prise, color);
    }

    @Override
    public void dressWomen() {
        System.out.println("Женщина надела юбку");
    }
}

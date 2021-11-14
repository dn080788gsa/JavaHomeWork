package com.pb.gorban.hw7;

public class Tie extends Clothes implements ManClothes{

    Tie(String type, Size size, int prise, String color) {
        super(type, size, prise, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Мужчина надел галстук");
    }
}

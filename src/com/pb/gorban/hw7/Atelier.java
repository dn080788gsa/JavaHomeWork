package com.pb.gorban.hw7;

public class Atelier {
    public static void main(String[] args) {
        Clothes[] clothes = new Clothes[4];
        clothes[0] = new Pants("Штаны", Size.XXS, 100, "RED");
        clothes[1] = new Skirt("Юбка", Size.S, 50, "GREEN");
        clothes[2] = new Tie("Галстук", Size.M, 80, "BLACK");
        clothes[3] = new Tshirt("Футболка", Size.L, 150, "WHITE");

        dressMan(clothes);
        System.out.println("----------------");
        dressWomen(clothes);
    }

    public static void dressMan(Clothes[] clothes) {
        for (Clothes clothe : clothes) {
            if (clothe instanceof ManClothes) {
                System.out.println(clothe.getType() + ": Размер-" + clothe.getSize() + " (" + clothe.getSize().getDescription() + ", EUR:" + clothe.getSize().getEuroSize() + "), Цвет-" + clothe.getColor() + ", Цена-" + clothe.getPrise() + "$");
            }
        }
    }

    public static void dressWomen(Clothes[] clothes) {
        for (Clothes clothe : clothes) {
            if (clothe instanceof WomenClothes) {
                System.out.println(clothe.getType() + ": Размер-" + clothe.getSize() + " (" + clothe.getSize().getDescription() + ", EUR:" + clothe.getSize().getEuroSize() + "), Цвет-" + clothe.getColor() + ", Цена-" + clothe.getPrise() + "$");
            }
        }
    }
}

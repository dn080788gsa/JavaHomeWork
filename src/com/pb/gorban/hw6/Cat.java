package com.pb.gorban.hw6;

public class Cat extends Animal{
    private String name;

    public Cat(String name, String food, String location) {
        super("Кот", food, location);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void makeNoise() {
        System.out.println(getType() + " " + name + " мяукает");
    }

    @Override
    public void eat() {
        System.out.println(getType() + " " + name + " пьет молоко");
    }

    @Override
    public String toString() {
        return "type=" + getType() + ", name=" + name +  ", location=" + getLocation() + ", food=" + getFood() ;
    }

    @Override
    public boolean equals(Object obj) {
        /*1. Проверьте*/
        if (obj == this) {
            /*и верните */ return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Cat cat = (Cat) obj;
        return getType() == cat.getType()
                && name == cat.name
                && getFood() == cat.getFood()
                && getLocation() == cat.getLocation();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getType().hashCode();
        result = prime * result + name.hashCode();
        result = prime * result + getFood().hashCode();
        result = prime * result + getLocation().hashCode();
        return result;
    }


}

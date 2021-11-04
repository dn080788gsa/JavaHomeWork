package com.pb.gorban.hw6;

public class Horse extends Animal{
    private String name;

    public Horse(String name, String food, String location) {
        super("Лошадь", food, location);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void makeNoise() {
        System.out.println(getType() + " " + name + " ржет");
    }

    @Override
    public void eat() {
        System.out.println(getType() + " " + name + " ест " + getFood());
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

        Horse horse = (Horse) obj;
        return getType() == horse.getType()
                && name == horse.name
                && getFood() == horse.getFood()
                && getLocation() == horse.getLocation();
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

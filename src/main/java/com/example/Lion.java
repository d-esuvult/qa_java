package com.example;

import java.util.List;

public class Lion {

    String sex;
    boolean hasMane;
    private final Feline feline;

    public Lion(String sex, Feline feline) throws Exception {
        this.feline = feline;
        this.sex = sex;
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самей или самка");
        }
    }

    public String getSex(){
        return sex;
    }

    // Feline feline = new Feline(); - было в оригинале

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}

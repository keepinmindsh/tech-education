package com.lines.sample;

public class Inheritance {
    public static void main(String[] args) {
        Howard howard = new Howard();

        howard.DrinkDouble();

        howard.Drink();

        System.out.printf("Drunk Status: %s",howard.DrunkStatus());
    }
}


class DrinkingSkill {

    public int soju = 0;

    public void DrinkDouble(){
        soju += 2;
    }

    public int DrunkStatus(){
        return soju;
    }
}


class Howard extends DrinkingSkill {

    public void Drink(){
        super.soju += 1;
    }
}

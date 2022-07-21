package com.lines.edu.sample;

public class OOPCode {
    public static void main(String[] args) {
        Pizza pizza = PizzaFactory.getPizza(PizzType.APPLE);

        pizza.taste();
    }
}

class PizzaFactory {

    // OCP - Open Closed Principle
    // SRP - Single Responsibility Principle
    public static Pizza getPizza(PizzType pizzType){
        switch (pizzType) {
            case APPLE:
                return new Apple();
            case POTATO:
                return new Potato();
            case PINE_APPLE:
                return new PineApple();
            case CHICKEN:
                return new Chicken();
            default:
                throw new RuntimeException("Not Found");
        }
    }


}

enum PizzType {
    APPLE,
    POTATO,
    PINE_APPLE,
    CHICKEN
}

interface Pizza {

    void taste();
}

class Potato implements Pizza{

    @Override
    public void taste() {
        System.out.println("달다!");
    }
}

class Apple implements Pizza{

    @Override
    public void taste() {
        System.out.println("시다");
    }
}


class PineApple implements Pizza {
    @Override
    public void taste() {

    }
}

class Chicken implements Pizza {
    @Override
    public void taste() {
        System.out.println("맛있다");
    }
}

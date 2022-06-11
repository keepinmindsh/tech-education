package com.sanha.edu.sample;

public class ProcedureCode {

    public static void main(String[] args) {
        ProcedurePizza procedureCode = new ProcedurePizza();

        procedureCode.taste(PizzType.APPLE);

    }
}

class TasteVisitor {

    public void taste(Apple apple){

    }

    public void taste(Potato potato){

    }

    public void taste(PineApple pineApple){

    }

    public void taste(Chicken chicken){

    }
}

class ProcedurePizza {
    public void taste(PizzType pizzType){

        /*
        * 절차지향
        *   - 하나의 로직을 서술적으로 작성하는 방식 
        * */

        switch (pizzType){
            case POTATO:
                System.out.println("달다!");
                break;
            case APPLE:
                System.out.println("시다");
                break;
            case PINE_APPLE:
                System.out.println("달고 시다.");
                break;
            case CHICKEN:
                System.out.println("맛있다.");
                break;
        }
        
        soSomething();
    }

    private void soSomething() {
    }
}

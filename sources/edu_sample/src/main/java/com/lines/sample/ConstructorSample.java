package com.lines.sample;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConstructorSample {

    private static ExecutorService executorService = Executors.newFixedThreadPool(100);

    public static void main(String[] args) {
        //Constructor1 constructorSample = new Constructor1();

        ConstructorStatic constructorStatic = new ConstructorStatic();
//
//        for (int i = 0; i <= 100 ; i++ ){
//            // Multi Thread - Servlet
//            executorService.submit(() -> {
//                ThreadSafeConstructor threadSafeConstructor = new ThreadSafeConstructor("String", 50 );
//
//                threadSafeConstructor.value();
//
//                threadSafeConstructor.setValue((int) Math.random());
//            });
//        }

    }
}

// 자바의 생성자에 대하여
class Constructor1Sample {

    private Constructor1Sample(){

    }
}


// REM
// - 해당 클래스가 내가 원하지 않는 위치에서 호출되지 않게 하고 싶을 때
class Constructor1 {
    private Constructor1(){

    }
}

// REM
// - Thread Safe 한 Class 만들어야 하는 경우
// - Immutable Object 를 정의해서 사용하라!
class ThreadSafeConstructor {
    private final String value;

    private final int count;

    private int notFinalValue;

    ThreadSafeConstructor(String value, int integer) {
        this.value = value;
        this.count = integer;
    }

    public String value(){
        return value + count;
    }

    public void setValue(int value){
        this.notFinalValue = value;
    }

    public int getValue(){
        return this.notFinalValue;
    }
}

class ConstructorStatic {

    private static final Map map;

    static {
        map = new HashMap();

        System.out.println("Static!");
    }

    public ConstructorStatic() {
        System.out.println("Construct");
    }

    public Map getMap(){
        return map;
    }
}
package com.lines.edu.sample.capsule;

public class CapsuleLogic implements Capsule {
    /**
     * 캡슐화
     *  속성 ( 멤버변수 ), 행위 ( 메소드 ) 이루어진 객체를 외부에서 볼수 없도록
     *  감추어 은닉한다.
     */

    private final int number;  // 변경 불가능 변수

    public CapsuleLogic(int number) {
        this.number = number;
    }

    public int getDoubleValue(){
        return (number * 2) + 10;
    }

    public int getValue(){
        return number;
    }
}

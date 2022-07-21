package com.lines.edu.sample.capsule;

public class Client {
    public static void main(String[] args) {
        CapsuleLogic capsuleLogic = new CapsuleLogic(100);

        // 데이터를 처리하는 행위를 외부에 보여주지 않는 것!
        System.out.println("capsuleLogic.getDoubleValue() = " + capsuleLogic.getDoubleValue());

        // 값을 요청하는게 아니라. 그 행위를 요청한다.

        // 캡슐화가 깨진 코드를 작성하는 경우
        System.out.println((capsuleLogic.getValue() * 2) + 10);

        System.out.println((capsuleLogic.getValue() * 2) + 10);

        System.out.println((capsuleLogic.getValue() * 2) + 10);

        System.out.println((capsuleLogic.getValue() * 2) + 10);

        System.out.println(capsuleLogic.getValue() * 2);

        System.out.println((capsuleLogic.getValue() * 2) + 10);

        System.out.println(capsuleLogic.getValue() * 2 + 10);

        // Tell, Don't ask ( Detail Value ).
    }
}

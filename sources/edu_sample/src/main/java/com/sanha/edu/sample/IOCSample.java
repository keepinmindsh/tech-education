package com.sanha.edu.sample;

public class IOCSample {
    public static void main(String[] args) {
        A a = new A();

        a.call();
    }
}


class A{
    public void call(){
        B b = new B();

        b.call();
    }
}

class B {
    public void call(){

    }
}
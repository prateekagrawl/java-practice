package org.example;

class Parent {
    Parent() {
        this("Constructor");
        System.out.println("Parent default constructor");
    }

    Parent(String s) {
        System.out.println("Parent class param " + s);
    }
}

public class Main extends Parent {

    Main() {
        this("Constructor");
        System.out.println("Main class default constructor");
    }

    Main(String s) {
        System.out.println("Chilld class param " + s);
    }

    public static void main(String[] args) {
//        System.out.println("Hello world!");

        Main obj = new Main();
    }
}
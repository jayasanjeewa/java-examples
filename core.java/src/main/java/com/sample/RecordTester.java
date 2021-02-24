package com.sample;

public class RecordTester {
    static Person p2;
    public static void main(String[] args) {
        var p = new Person(12, "John");

        System.out.println(p.name());

        System.out.println("""
                <html>
                <header>
                """);

        if (p instanceof Person pr) {

            System.out.println("age on name: " + ageOnName(pr.name()));
            oldSwitch(pr.name());
        }


    }

    private static void oldSwitch(String name) {
        switch(name) {
            case "John":
                System.out.println("Old default case");
                break;
            case "Smith":
                System.out.println("Old default case");
                break;
            default:
                System.out.println("Old default case");
        }
    }

    private static int ageOnName(String name) {
        int result = switch (name) {
            case "John" -> 1;
            case "Smith" -> { yield 2;}
            default -> {
                System.out.println("Its neither names");
                yield -1;
            }
        };

        return result;

    }
}

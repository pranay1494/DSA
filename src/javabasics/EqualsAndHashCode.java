package javabasics;

public class EqualsAndHashCode {
    int age;

    EqualsAndHashCode(int age) {
        this.age = age;
    }

    int hashcode() {
        return 5;
    }

    public boolean equals(EqualsAndHashCode o) {
        if (this == o) return true;
        return age == o.age;
    }


    public static void main(String[] args) {
        EqualsAndHashCode a = new EqualsAndHashCode(25);
        EqualsAndHashCode b = new EqualsAndHashCode(25);
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }
}


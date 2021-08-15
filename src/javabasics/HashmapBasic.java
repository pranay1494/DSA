package javabasics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashmapBasic {
    public static void main(String[] args) {
        Integer a = 10;
        Integer b = 10;

        Map<Integer, String> map = new HashMap<>();
        map.put(a, "a");
        map.put(b, "b");

        System.out.println("args = " + map.size());

        Dummy c = new Dummy(10);
        Dummy d = new Dummy(10);

        Map<Dummy, String> dummyMap = new HashMap<>();
        dummyMap.put(c, "a");
        dummyMap.put(d, "b");

        System.out.println("args = " + dummyMap.size());

    }

    static class Dummy {
        int age;

        public Dummy(int age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Dummy dummy = (Dummy) o;
            return age == dummy.age;
        }

        @Override
        public int hashCode() {
            return Objects.hash(age);
        }
    }
}

package javabasics;
class C{
    void m(){
        System.out.println("parent");
    }

    static void fun(){
        System.out.println("parent fun");
    }
}
class D extends C{
    void m(){
        System.out.println("child");
    }

    static void fun(){
        System.out.println("child fun");
    }

    public static void main(String[] args) {
        C a = new C();
        a.m();
        a.fun();
        D b = new D();
        b.m();
        b.fun();
        C c = new D();
        c.m();
        c.fun();
    }
}


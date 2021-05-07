package com.wangzhu.other;

/**
 * Created by wang.zhu on 2021-03-09 17:27.
 **/
public class OuterClassBean {

    private int a = 1;
    private static int b = 20;
    private static final int c = 30;

    static void outerStaticMethod() {

    }

    void outerMethod() {

    }

    /**
     * 静态内部类
     * 可以有自己的成员变量、静态变量
     * 可以有静态方法、成员方法
     * 静态方法：自己的静态变量、外部类的静态变量
     * 成员方法：自己的静态变量、外部类的静态变量、自己的成员变量
     */
    public static class A {

        private int aA = 2;
        private static int bA = 21;
        private static final int cA = 31;

        public void innerMethod() {
            System.out.println(aA);
            System.out.println(A.bA);
            System.out.println(A.cA);

//            System.out.println(OuterClassBean.this.a);
            System.out.println(OuterClassBean.b);
            System.out.println(OuterClassBean.c);

//            OuterClassBean.this.outerMethod();
            OuterClassBean.outerStaticMethod();
        }

        public static void innerStaticMethod() {
            System.out.println(A.bA);
            System.out.println(A.cA);

            System.out.println(OuterClassBean.b);
            System.out.println(OuterClassBean.c);

            OuterClassBean.outerStaticMethod();
        }
    }

    /**
     * 成员内部类
     * 可以有自己的成员变量
     * 可以有成员方法
     * 成员方法：外部类的静态变量、自己的成员变量、外部类的成员变量
     */
    public class B {

        private int aB = 3;
        //        private static int bB = 22;
        private static final int cB = 32;

        public void innerMethod() {
            System.out.println(aB);
            System.out.println(cB);

            System.out.println(OuterClassBean.this.a);
            System.out.println(OuterClassBean.b);
            System.out.println(OuterClassBean.c);

            OuterClassBean.outerStaticMethod();
            OuterClassBean.this.outerMethod();
        }

//        private static void innerStaticMethod() {
//
//        }
    }

    public class C extends B {


    }

    public class D extends A {
        private void cal() {
            System.out.println(OuterClassBean.b);
            System.out.println(OuterClassBean.this.a);
        }
    }

    public static class E extends A {
        private void cal() {
            System.out.println(OuterClassBean.b);
//            System.out.println(InnerClassBean.this.a);
        }
    }


    //创建静态内部类对象的一般形式为：  外部类类名.内部类类名 xxx = new 外部类类名.内部类类名()
    //创建成员内部类对象的一般形式为：  外部类类名.内部类类名 xxx = 外部类对象名.new 内部类类名()
    private void builderV1() {
        OuterClassBean.A aa = new OuterClassBean.A();
        aa.innerMethod();
        OuterClassBean.A.innerStaticMethod();

        OuterClassBean outerClassBean = new OuterClassBean();
        OuterClassBean.B b = outerClassBean.new B();
        b.innerMethod();

        new B();
    }

    private static void builderV2() {
        OuterClassBean.A aa = new OuterClassBean.A();
        aa.innerMethod();
        OuterClassBean.A.innerStaticMethod();

        OuterClassBean outerClassBean = new OuterClassBean();
        OuterClassBean.B b = outerClassBean.new B();
        b.innerMethod();

//        new B();
    }

}
package editor.cn;

public class Test {
    static class A {
        static String name="name1_A";
        static {
            System.out.println("name2_A");
        }
        String name1="name3_A";
        {
            System.out.println("name4_A");
        }
        A(){
            System.out.println("name5_A");
        }
    }

    static class B extends A{
        static String name="name1_B";
        static {
            System.out.println("name2_B");
        }
        String name1="name3_B";
        {
            System.out.println("name4_B");
        }
        B(){
            System.out.println("name5_B");
        }
    }

    public static void main(String[] args) {
        new B();
    }
}

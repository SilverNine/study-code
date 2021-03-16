package basic;

/**
 * Created by eg on 2016-11-23.
 */
public class CallByValue {
    public static class Foo {
        private String attribute;

        public String getAttribute() {
            return attribute;
        }

        public void setAttribute(String attribute) {
            this.attribute = attribute;
        }

        public Foo(String value) {
            setAttribute(value);
        }
    }

    public static void main(String[] args) {
        Foo foo = new Foo("f");
        int primitive = 0;

        /**
         * 자바에서 객체는 참조(Reference)값의 복사본을 Pass by Value로 넘김
         */

        // It won't change the reference!
        // Java always passes arguments by value NOT by reference.
        changeReference(foo, primitive);

        // It will modify the object that the reference variable "f" refers to!
        modifyReference(foo);

        System.out.println(foo.getAttribute());
        System.out.println(primitive);
    }

    public static void changeReference(Foo foo, int primitive){
        Foo b = new Foo("b");
        foo = b;
        primitive = 3;
    }

    public static void modifyReference(Foo foo){
        foo.setAttribute("c");
    }
}

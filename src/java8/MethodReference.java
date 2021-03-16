package java8;

import java.util.ArrayList;
import java.util.List;

public class MethodReference {
    public static void main(String args[]) {
        List names = new ArrayList();

        names.add("SpiderMan");
        names.add("BatMan");
        names.add("SuperMan");
        names.add("AntMan");
        names.forEach(System.out::println);

    }
}

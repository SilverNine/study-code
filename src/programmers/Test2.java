package programmers;

import java.util.*;

public class Test2 {
    public static void main(String args[]) {
        String s = "baabaa";

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
                continue;
            }

            stack.push(c);
        }

        int returnNumber = 0;

        if (stack.isEmpty()) {
            returnNumber = 1;
        }

        System.out.println(returnNumber);
    }
}

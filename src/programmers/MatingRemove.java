package programmers;

import java.util.Stack;

public class MatingRemove {
    public static void main(String args[]) {
        MatingRemove matingRemove = new MatingRemove();
        System.out.println(matingRemove.solution("baabaa"));
        System.out.println(matingRemove.solution("cdcd"));
    }

    public int solution(String s)
    {
        Stack<Character> stack = new Stack();

        for(Character c : s.toCharArray()) {

            if(stack.size() > 0) {
                if(stack.peek() == c) {
                    stack.pop();
                    continue;
                }
            }

            stack.push(c);
        }

        if ( stack.size() == 0 ) {
            return 1;
        }

        return 0;
    }
}

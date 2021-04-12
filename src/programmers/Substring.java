package programmers;

import java.util.HashSet;

public class Substring {

    public static void main(String args[]) {
        Substring substring = new Substring();
        System.out.println(substring.solution("abac"));
        System.out.println(substring.solution("abcd"));
        System.out.println(substring.solution("zxzxz"));
        System.out.println("zxzxz".substring(0, 5));
        System.out.println("zxzxz".substring(1, 5));
    }

    public int solution(String s) {
        HashSet<String> Strings = new HashSet<>();

        for (int i = 0; i <= s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String str = s.substring(i, j);
                if (duplicateChecker(str)) {
                    continue;
                }
                Strings.add(str);
            }
        }

        return Strings.size();
    }

    private boolean duplicateChecker(String s) {
        Boolean checkResult = false;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    checkResult = true;
                    break;
                }
            }
        }

        return checkResult;
    }
}

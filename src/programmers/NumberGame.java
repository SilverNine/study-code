package programmers;

import java.util.Arrays;

public class NumberGame {
    public static void main(String args[]) {
        NumberGame numberGame = new NumberGame();
        System.out.println(numberGame.solution(new int[]{5,1,3,7}, new int[]{2,2,6,8}));
        System.out.println(numberGame.solution(new int[]{2,2,2,2}, new int[]{1,1,1,1}));

        System.out.println(numberGame.solution(new int[]{1,2,5,6}, new int[]{2,3,7,6}));
    }

    public int solution(int[] A, int[] B) {
        int answer = 0;
        int aIndex = 0;
        int bIndex = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0; i<B.length; i++) {
            if(B[bIndex] > A[aIndex]) {
                answer++;
                aIndex++;
            }

            bIndex++;
        }

        return answer;
    }
}
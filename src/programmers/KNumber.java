package programmers;

import java.util.Arrays;

/**
 * Created by SilverNine on 27/11/2018.
 */
public class KNumber {
    public static void main(String args[]) {
        int[] array = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        solution(array, commands);
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int i = 0;

        for (int[] command : commands) {
            int[] subArray = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(subArray);
            answer[i] = subArray[command[2] - 1];
            i++;
        }

        return answer;
    }
}




package programmers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by SilverNine on 27/11/2018.
 */
public class ArrayDividingNumbers {
    /*
    [5, 9, 7, 10]	5	[5, 10]
    [2, 36, 1, 3]	1	[1, 2, 3, 36]
    [3,2,6]	        10	[-1]
     */
    public static void main(String[] args) {
        int[] arr = {5, 9, 7, 10};
        int divisor = 5;
        solution(arr, divisor);
    }

    public static int[] solution2(int[] arr, int divisor) {
        int[] results = Arrays.stream(arr).filter(factor -> factor % divisor == 0).toArray();
        Arrays.sort(results);

        if(results.length == 0) {
            results = new int[1];
            results[0] = -1;
            return results;
        }
        return results;
    }

    public static int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> arrList = new ArrayList<>();
        int i = 0;

        for (int number : arr) {
            if (number % divisor == 0) {
                arrList.add(number);
            }

            i++;
        }

        i = 0;

        int size = (arrList.size() > 0) ? arrList.size() : 1;

        int[] answer = new int[size];

        for (int number : arrList) {
            answer[i] = number;
            i++;
        }

        if(arrList.size() == 0) {
            answer[0] = -1;
        }

        Arrays.sort(answer);

        return answer;
    }
}

package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Greedy3_1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int[] minArray = new int[n];
        for(int i=0; i<arr.length; i++) {
            Arrays.sort(arr[i]);
            minArray[i] = arr[i][0];
        }

        Arrays.sort(minArray);

        System.out.println(minArray[minArray.length-1]);
    }
}

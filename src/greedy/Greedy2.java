package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Greedy2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int first = arr[n-1];
        int second = arr[n-2];

        //cnt는 가장 큰 수가 등장하는 횟수 ex) 6665 6665
        int cnt = (m / (k + 1)) * k;
        //나머지가 0이 아닌경우 나머지만큼 가장 큰 수가 등장
        cnt += m % (k + 1);

        int result = 0;
        //가장큰수 * 등장횟수
        result += cnt * first;
        //나머지 * 두번째수
        result += (m - cnt) * second;

        System.out.println(result);
    }
}

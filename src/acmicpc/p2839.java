package acmicpc;

import java.util.Scanner;

public class p2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solution(sc.nextInt()));
        sc.close();
    }

    private static int solution(int n) {
        int min = 5000;
        if (n % 5 == 0) {
            return n / 5;
        } else {
            for (int i = 0; i <= n / 5; i++) {
                int temp = n - 5 * i;
                if (temp % 3 == 0) {
                    min = Math.min(min, i + temp / 3);
                }
            }
        }
        return min != 5000 ? min : -1;
    }
}

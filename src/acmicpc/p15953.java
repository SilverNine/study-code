package acmicpc;


import java.util.Scanner;


public class p15953 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        int inputLength = scan.nextInt();
        scan.nextLine();

        int[] results = new int[inputLength];

        for(int i=0 ; i<inputLength ; i++) {
            String input = scan.nextLine();
            String inputA = input.substring(0, input.indexOf(" "));
            String inputB = input.substring(input.indexOf(" ") + 1);

            results[i] = cal2017(Integer.parseInt(inputA)) + cal2018(Integer.parseInt(inputB));
        }

        for(int result : results) {
            System.out.println(result);
        }
    }

    public static int cal2017(int rank){
        if(rank == 0) {
            return 0;
        }
        else if(rank <= 1) {
            return 5000000;
        }
        else if(rank <= 3) {
            return 3000000;
        }
        else if(rank <= 6) {
            return 2000000;
        }
        else if(rank <= 10) {
            return 500000;
        }
        else if(rank <= 15) {
            return 300000;
        }
        else if(rank <= 21) {
            return 100000;
        }
        else {
            return 0;
        }
    }

    public static int cal2018(int rank){
        if(rank == 0) {
            return 0;
        }
        else if(rank <= 1) {
            return 5120000;
        }
        else if(rank <= 3) {
            return 2560000;
        }
        else if(rank <= 7) {
            return 1280000;
        }
        else if(rank <= 15) {
            return 640000;
        }
        else if(rank <= 31) {
            return 320000;
        }
        else {
            return 0;
        }
    }
}

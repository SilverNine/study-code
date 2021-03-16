package test;


public class RecursiveMaze2 {
    public static void main(String[] args) {
        int[][] table = {{50, 45, 37, 32, 30}, {35, 50, 40, 20, 25}, {30, 30, 25, 17, 28}, {27, 24, 22, 15, 10}};
        System.out.println(String.format("count: %d", count(table, 0, 0)));
    }

    private static int count(int[][] table, int i, int j) {
        int number = table[i][j];
        System.out.println(String.format("(%d, %d) -> %d", i, j, number));
        if(i >= table.length - 1 && j >= table[i - 1].length - 1) {
            return 1;
        }
        int sum = 0;
        if(number > (i - 1 < 0 ? number : table[i - 1][j])) {
            sum += count(table, i - 1, j);
        }
        if(number > (i + 1 >= table.length ? number : table[i + 1][j])) {
            sum += count(table, i + 1, j);
        }
        if(number > (j - 1 < 0 ? number : table[i][j - 1])) {
            sum += count(table, i, j - 1);
        }
        if(number > (j + 1 >= table[i].length ? number : table[i][j + 1])) {
            sum += count(table, i, j + 1);
        }
        return sum;
    }
}

package test;

import java.util.ArrayList;
import java.util.HashMap;

public class RecursiveMaze {
    public static final int MAX_X = 3;
    public static final int MAX_Y = 4;
    public static final int MIN_X = 0;
    public static final int MIN_Y = 0;

    public static int[][] matrixPaths = new int[][]{
            {50, 45, 37, 32, 30},
            {35, 50, 40, 20, 25},
            {30, 30, 25, 17, 28},
            {27, 24, 22, 15, 10},
    };

    public static void findPath(int x, int y) {
        System.out.println(matrixPaths[x][y]);
        ArrayList<HashMap> trueMaps = new ArrayList<>();
        HashMap<String, Integer> trueMap;

        if (x < MAX_X && matrixPaths[x][y] > matrixPaths[x + 1][y]) {
            trueMap = new HashMap();
            trueMap.put("x" , x + 1);
            trueMap.put("y" , y);
            trueMaps.add(trueMap);
        }
        if (y < MAX_Y && matrixPaths[x][y] > matrixPaths[x][y + 1]) {
            trueMap = new HashMap();
            trueMap.put("x" , x);
            trueMap.put("y" , y + 1);
            trueMaps.add(trueMap);
        }
        if (x > MIN_X && matrixPaths[x][y] > matrixPaths[x - 1][y]) {
            trueMap = new HashMap();
            trueMap.put("x" , x - 1);
            trueMap.put("y" , y);
            trueMaps.add(trueMap);
        }
        if (y > MIN_Y && matrixPaths[x][y] > matrixPaths[x][y - 1]) {
            trueMap = new HashMap();
            trueMap.put("x" , x);
            trueMap.put("y" , y - 1);
            trueMaps.add(trueMap);
        }

        if(trueMaps.size() > 0) {
            trueMap = trueMaps.get((int) (Math.random() * trueMaps.size()));
            findPath(trueMap.get("x"), trueMap.get("y"));
        }
    }

    public static void main(String args[]) {
        findPath(0, 0);
    }
}
package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Frog2 {

    public static void main(String args[]) {
        Frog2 frog = new Frog2();
        System.out.println(frog.solution(new int[]{4, 1, 2, 3, 1, 0, 5}));

        // System.out.println(frog.solution(new int[]{2, 2, 2, 1, 2, 0}));

        // System.out.println(frog.solution(new int[]{1, 2, 3, 1, 0, 0}));

        // System.out.println(frog.solution(new int[]{0, 2, 3, 1, 0, 0}));

        // System.out.println(frog.solution(new int[]{1, 1, 1, 1, 1, 1}));

        // System.out.println(frog.solution(new int[]{1, 2, 1, 1, 1, 1}));

        // System.out.println(frog.solution(new int[]{1, 2, 0}));

        System.out.println(frog.solution(new int[]{4, 0, 1, 1, 1, 1, 5}));
    }

    public int solution(int[] nums) {
        int answer = -1;
        int count = 0;

        Queue<int[]> queue = new LinkedList<>();
        Boolean[] isVisited = new Boolean[nums.length];

        for (int i = 0; i < isVisited.length; i++) {
            isVisited[i] = false;
        }

        queue.add(new int[]{nums[0], 0});

        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();

                int rightTarget = now[1] + now[0];
                int leftTarget = now[1] - now[0];

                if (rightTarget == nums.length - 1) {
                    answer = count;
                    break;
                }

                if (leftTarget == rightTarget) {
                    continue;
                }

                if (leftTarget > 0 && !isVisited[leftTarget]) {
                    isVisited[leftTarget] = true;
                    queue.add(new int[]{nums[leftTarget], leftTarget});
                }

                if (rightTarget < nums.length - 1 && !isVisited[rightTarget]) {
                    isVisited[rightTarget] = true;
                    queue.add(new int[]{nums[rightTarget], rightTarget});
                }
            }
        }

        return answer;
    }
}





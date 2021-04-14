package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Frog {

    public static void main(String args[]) {
        Frog frog = new Frog();
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

        Queue<Status> queue = new LinkedList<>();
        Boolean[] isVisited = new Boolean[nums.length];

        for (int i = 0; i < isVisited.length; i++) {
            isVisited[i] = false;
        }

        Status status = new Status(nums[0], 0);
        queue.add(status);

        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Status now = queue.poll();

                int rightTarget = now.index + now.num;
                int leftTarget = now.index - now.num;

                if (rightTarget == nums.length - 1) {
                    answer = count;
                    break;
                }

                if (leftTarget > 0 // 왼쪽 타겟이 0보다 커야 한다.
                    && !isVisited[leftTarget] // 이동할 지점이 방문하지 않았어야 한다.
                    && nums[leftTarget] > 0 // 이동할 지점이 0보다 커야 의미가 있다.
                ) {
                    isVisited[leftTarget] = true;
                    queue.add(new Status(nums[leftTarget], leftTarget));
                }

                if (rightTarget < nums.length // 오른쪽 타겟이 전체 길이보다 작아야 한다.
                    && !isVisited[rightTarget] // 이동할 지점이 방문하지 않았어야 한다.
                    && nums[rightTarget] > 0 // 이동할 지점이 0보다 커야 의미가 있다.
                ) {
                    isVisited[rightTarget] = true;
                    queue.add(new Status(nums[rightTarget], rightTarget));
                }
            }
        }

        return answer;
    }

    class Status {

        int num;
        int index;

        Status(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }
}





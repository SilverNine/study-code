package basic;

/* 큐를 이용한 BFS 트리 전체 탐색을 방문 순서대로 출력 (노드 번호, 깊이)

                    1
           2        3       4
        5    6   7    8     9
            10  11   12
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class StudyBFS {

    public static void main(String[] args) {
        ArrayList<Integer>[] graph = new ArrayList[13];
        boolean[] isVisited = new boolean[13];

        for (int i = 1; i <= 12; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[1].add(2);
        graph[1].add(3);
        graph[1].add(4);

        graph[2].add(5);
        graph[2].add(6);

        graph[3].add(7);
        graph[3].add(8);

        graph[4].add(9);

        graph[6].add(10);

        graph[7].add(11);

        graph[8].add(12);

        Queue<int[]> queue = new LinkedList<>();
        int now[] = new int[2]; // 0 Node, 1 Depth

        now[0] = 1;
        now[1] = 1;

        queue.add(now);

        while (!queue.isEmpty()) {
            now = queue.poll();

            System.out.println(Arrays.toString(now));

            for (int i = 0; i < graph[now[0]].size(); i++) {
                int next[] = new int[2];
                next[0] = graph[now[0]].get(i);
                next[1] = now[1] + 1;

                if (isVisited[next[0]] == false) {
                    isVisited[next[0]] = true;
                    queue.add(next);
                }

            }
        }
    }
}

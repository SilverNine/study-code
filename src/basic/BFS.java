package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/* 큐를 이용한 BFS 트리 전체 탐색을 방문 순서대로 출력 (노드 번호, 깊이)

                1
           2        3
         4   5    6   7
             8    9
*/

public class BFS {

    public static void main(String[] args) {
        //그래프 생성
        ArrayList<Integer>[] graph = new ArrayList[10];
        //방문여부 저장
        boolean[] isVisited = new boolean[10];

        for (int i = 1; i <= 9; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[1].add(2);
        graph[1].add(3);

        graph[2].add(4);
        graph[2].add(5);

        graph[3].add(6);
        graph[3].add(7);

        graph[5].add(8);
        graph[6].add(9);

        //탐색 준비
        Queue<int[]> queue = new LinkedList<>(); //방문한 Depth 까지 출력

        int now[] = new int[2]; //0 : 노드 번호, 1 : 깊이

        now[0] = 1; //1에서 시작
        now[1] = 1; //깊이 1 ( 처음이니까 )

        isVisited[now[0]] = true;

        queue.add(now);

        while (!queue.isEmpty()) {
            now = queue.poll();

            System.out.println(Arrays.toString(now));

            for (int i = 0; i < graph[now[0]].size(); i++) {
                int next[] = new int[2]; // 0 : 노드 번호, 1: 깊이

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

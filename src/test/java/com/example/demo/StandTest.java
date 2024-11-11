package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

@SpringBootTest
class StandTest {

    @Test
    void test() {

        int N = 4;
        int M = 2;
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            A.add(new ArrayList<>());
        }


        int[][] edges = {
            {4, 2},
            {3, 1}
        };

        int[] indegree = new int[N + 1];  // 진입 차수 배열
        for (int i = 0; i < M; i++) {
            int S = edges[i][0];
            int E = edges[i][1];

            A.get(S).add(E);
            indegree[E]++; // 진입차수 배열 데이터 저장하기
        }
        Queue<Integer> queue = new LinkedList<>();  // 위상 정렬 수행
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            for (int next : A.get(now)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        Assertions.assertTrue(true);
    }

}



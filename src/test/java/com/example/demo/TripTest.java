package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;

@SpringBootTest
class TripTest {
 public static int[] parent;

    @Test
    public void test() {

        int N = 3;
        int M = 3;
        int[][] dosi = new int[N + 1][N + 1];
        int[][] connections = {
                {0, 1, 0},
                {1, 0, 1},
                {0, 1, 0}
        };

        try {


            for (int i = 1; i <= N; i++) { //도시 연결 데이터 저장
                for (int j = 1; j <= N; j++) {
                    dosi[i][j] = connections[i-1][j-1];
                }
            }
            int[] route = new int[M + 1];

            int[] rr = {1,2,3};

            for (int i = 1; i <= M; i++) { //여행 도시 정보 저장
                route[i] = rr[i-1];
            }
            parent = new int[N + 1];
            for (int i = 1; i <= N; i++) { //대표 노드를 자기 자신으로 초기화
                parent[i] = i;
            }
            for (int i = 1; i <= N; i++) { //인접행렬 탐색에서 도시가 연결되어있으면 유니온 실행
                for (int j = 1; j <= N; j++) {
                    if (dosi[i][j] == 1) union(i, j);
                }
            }
            // 여행 계획 도시들이 하나의 대표 도시로 연결되어있는지 확인
            int index = find(route[1]);
            for (int i = 2; i < route.length; i++) {
                if (index != find(route[i])) {
                    System.out.println("NO");
                    return;
                }
            }
            System.out.println("YES");


        }catch (NoSuchElementException e) {
              System.out.println("ERR");
        }




    }



    public static void union(int a, int b) { // union 연산 : 대표 노드끼리 연결하여 줌
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }
    public static int find(int a) { // find 연산
        if (a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]); // 재귀함수의 형태로 구현 -> 경로 압축 부분
    }


}

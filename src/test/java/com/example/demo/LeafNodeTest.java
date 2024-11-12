package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class LeafNodeTest {

    static ArrayList<Integer>[] tree;
    static boolean[] visit;
    static int answer = 0; // 리프 노드 개수 저장 변수
    static int deleteNode=0; // 삭제 노드

    @Test
    void test() {

            int N = 9;  // 노드 개수
            tree = new ArrayList[N]; // 트리 데이터의 저장 인접 리스트
            visit = new boolean[N]; // 방문 기록 저장 배열 
            int root = 0;
            for (int i = 0; i < N; i++) {
                tree[i] = new ArrayList<Integer>();
            }

            // 0 - 8번까지 노드의 부모 노드 -1인 경우 부모는 없는 걸로 판단
            int[] nodeList = {-1, 0, 0, 2, 2, 4, 4, 6, 6};

            for (int i = 0; i < N; i++) {
                int p = nodeList[i];
                if (p != -1) {
                    tree[i].add(p);
                    tree[p].add(i);
                } else
                    root = i;
            }
            deleteNode = 4;

            System.out.println("tree");

            for (int i = 0; i < N; i++) {
                System.out.println("tree[" + i + "]: " + tree[i]);
            }

            if (deleteNode == root)
                System.out.println(0);
            else {
                DFS(root);
                System.out.println(answer);
            }

        Assertions.assertTrue(true);

    }

    static void DFS(int number) {
        visit[number] = true;
        int cNode = 0;
        for (int i : tree[number]) {
            if (visit[i] == false && i != deleteNode) {
                cNode++;
                DFS(i);
            }
        }
        if (cNode == 0) {
            answer++;
        }
    }




}

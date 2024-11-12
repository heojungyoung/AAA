package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class TreeTest {

    @Test
    void test() {

        int N = 5; // 예제 크기
        ArrayList<Integer>[] tree = new ArrayList[N]; // ArrayList 배열 생성

        // 각 인덱스에 ArrayList 초기화
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        // ArrayList에 예제 데이터 추가 (선택 사항)
        tree[0].add(1);
        tree[1].add(2);
        tree[2].add(3);

        tree[3].add(2);
        tree[3].add(4);
        tree[3].add(7);
        tree[3].add(8);

        tree[4].add(5);

        // ArrayList 배열 출력
        for (int i = 0; i < N; i++) {
            System.out.println("tree[" + i + "]: " + tree[i]);
        }

        Assertions.assertTrue(true);

    }

}

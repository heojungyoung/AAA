package com.example.demo;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

@SpringBootTest
    class Minfind {

    @DisplayName("슬라이딩 윈도우 알고리즘")
    @Test
    void test() throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = 12;
        int l = 3;

        int[] numbers = {1, 5, 2, 3, 6 ,2, 3, 7, 3, 5, 2, 6};

        Deque<Node> mydeque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int now = numbers[i];
            // 새로운 값이 들어 올 때마다 정렬하지 않고 현재 수보다 큰 값을 덱에서 제거함으로써 시간복잡도를 줄일 수 있음
            while (!mydeque.isEmpty() && mydeque.getLast().value > now) {
                mydeque.removeLast();
            }
            mydeque.addLast(new Node(now, i));
            // 범위에서 벗어난 값은 덱에서 제거
            if (mydeque.getFirst().index <= i - l) {
                mydeque.removeFirst();
            }
            bw.write(mydeque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();

    }


    static class Node {
        public int value;
        public int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }


}

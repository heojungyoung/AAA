package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class ZumongTest {

    @Test
    void test() {

        int N = 6; // 재료의 개수
        int M = 9;  // 갑옷이 되는 번호
        int[] A = new int[N];

        // 재료 배열
        int metrial[] = { 2, 7, 4, 1, 5, 3};

        for (int i = 0; i < N; i++) {
            A[i] = metrial[i];
        }
        Arrays.sort(A);
        int count = 0;
        int i = 0;
        int j = N - 1;

        while (i < j) {

            if (A[i] + A[j] < M) {
                i++; // 작은 번호 재료를 한칸 위로 변경
            } else if (A[i] + A[j] > M) {
                j--;  // 큰 번호 재료를 한칸 아래로 변경
            } else {
                count++;
                i++;
                j--;
                // 수 증가, 양쪽 index 각각 변경하기
            }
        }

        System.out.println(count);
        Assertions.assertTrue(true);
    }

}





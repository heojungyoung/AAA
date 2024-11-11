package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

@SpringBootTest
class SortTest {

    // A(정렬할 배열 선언하기)
    // tmp (정렬할 때 잠시 사용할 임시배열 선언하기)
    public static int[] A, tmp;
    public static long result;

    @Test
    void test() throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = 9;
        int[] numbers = {1, 5, 2, 3, 6 ,10, 9, 7, 4, 8};

        A = new int[N + 1];
        tmp = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            A[i] = numbers[i];
        }
        merge_sort(1, N); // 병합정렬 수행하기
        
        
        // 결과 출력
        for (int i = 0; i <= N; i++) {
            bw.write(A[i] + "\n");
        }
        bw.flush();
        bw.close();

        Assertions.assertTrue(true);

    }

    // s (시작점)
    // e (종료점)
    // m (중간점)

    private static void merge_sort(int s, int e) {
        if (e - s < 1)
            return;
        int m = s + (e - s) / 2;
        // 재귀함수 형태로 구현
        merge_sort(s, m);
        merge_sort(m + 1, e);
        // tmp 배열 저장하기
        for (int i = s; i <= e; i++) {
            tmp[i] = A[i];
        }
        int k = s;
        // index1 -> 앞쪽 그룹 시작점
        int index1 = s;
        // index2 -> 뒤쪽 그룹 시작점
        int index2 = m + 1;

        // 양쪽 그룹 index가 가라키는 값을 비교한 후 더 작은 수를 선택해 배열에 저장하고,
        // 선택된 데이터의 index값을 오른쪽으로 한칸 이동하기
        // 반복문의 끝난 후 남아 있는 데이터 정리하기

        while (index1 <= m && index2 <= e) { // 두 그룹을 Merge 해주는 로직
            if (tmp[index1] > tmp[index2]) {
                A[k] = tmp[index2];
                k++;
                index2++;
            } else {
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }
        // 한쪽 그룹이 모두 선택된 후 남아있는 값 정리하기
        while (index1 <= m) {
            A[k] = tmp[index1];
            k++;
            index1++;
        }

        while (index2 <= e) {
            A[k] = tmp[index2];
            k++;
            index2++;
        }

    }


}

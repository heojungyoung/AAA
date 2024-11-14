package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Stack;

@SpringBootTest
class SueTest {

    @Test
    void test() {

        int N = 8;
        int[]A = new int[N];

        int[] numbers = {4,3,6,8,7,5,2,1};

        for (int i = 0; i < N; i++) {
            A[i] = numbers[i];
        }
        Stack<Integer> stack = new Stack<>();
        StringBuffer bf = new StringBuffer();
        int num = 1; // 오름차순 수
        boolean result = true;
        for (int i = 0; i < A.length; i++) {
            int su = A[i]; // 현재 수열의 수
            if (su >= num) { //현재 수열 값 >= 오름차순 자연수 : 값이 같아 질 때까지 push()수행
                while (su >= num) { // push()
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            }
            else {  //현재 수열 값 < 오름차순 자연수: pop()을 수행하여 수열 원소를 꺼냅니다
                int n = stack.pop();
                // 스택의 가장 위의 수가 만들어야 하는 수열의 수 보다 크다면 수열 출력 불가능
                if (n > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                } //
                else {
                    bf.append("-\n");
                }
            }
        }
        if (result) System.out.println(bf);

        Assertions.assertTrue(true);

    }

}



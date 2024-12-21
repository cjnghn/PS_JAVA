package org.example.boj;

// 2075. N번째 큰 수 성공
// https://www.acmicpc.net/problem/2075

// 간단하게 생각하면
// 정렬을 생각해서 O(N^2 logN^2) = O(2N^2 logN) log1500 = 3.x (너무 널널)

// 근데 메모리 문제를 생각해보면 재밌게 접근이 가능함.
// 실제로 메모리 제한을 살펴보면 12MB라서 Integer를 가정해서 배열 생성시 널널하게 쳐준걸 확인 가능..

// 근데 훨씬 적은 메모리 제한이 들어온다면?
// 실제로도 큰 파일에서 이런 비슷한 문제를 풀어야 할 때가 있다. 그렇다면 어떻게 처리할 것인가?
// 우선순위 큐로 청크 단위로 N 개씩 처리하도록 반복하면?

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P2075 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                pq.add(Integer.parseInt(st.nextToken()));

                // N개 유지
                if (pq.size() > N) {
                    pq.poll();
                }
            }
        }

        // The top of the heap is the Nth largest element
        System.out.println(pq.peek());
    }

//    public static void main(String[] args) throws IOException {
//        var br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//
//        // 리스트에 모든 숫자를 저장
//        ArrayList<Integer> numbers = new ArrayList<>();
//
//        for (int i = 0; i < N; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < N; j++) {
//                numbers.add(Integer.parseInt(st.nextToken()));
//            }
//        }
//
//        // 숫자 리스트를 내림차순으로 정렬
//        numbers.sort(Collections.reverseOrder());
//
//        // N 번째 큰 숫자를 출력
//        System.out.println(numbers.get(N - 1));
//    }
}

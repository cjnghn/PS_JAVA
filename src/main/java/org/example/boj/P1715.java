package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 1715. 카드 정렬하기
// https://www.acmicpc.net/problem/1715

public class P1715 {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 카드 묶음을 관리하는 우선순위 큐 (오름차순 정렬)
        PriorityQueue<Integer> cardPacks = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            cardPacks.add(Integer.parseInt(br.readLine()));
        }

        int totalComparisonCost = 0;

        // 두 개씩 합쳐나가며 최소 비교 횟수를 계산
        while (cardPacks.size() > 1) {
            int currentMergeCost = cardPacks.poll() + cardPacks.poll();
            totalComparisonCost += currentMergeCost;
            cardPacks.add(currentMergeCost);
        }

        System.out.println(totalComparisonCost);
    }
}

package _42587;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 
 * @author cw https://programmers.co.kr/learn/courses/30/lessons/42587
 *
 */
public class solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] priorities = { 2, 1, 3, 2 };
		// int location = 2;
		int[] priorities = { 1, 1, 9, 1, 1, 1 };
		int location = 0;

		System.out.println(solve(priorities, location));
	}

	private static int solve(int[] priorities, int location) {
		int answer = 0;

		answer = 1;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int e : priorities) {
			pq.add(e); // PriorityQueue를 내림차순으로 정렬
		}
		while (!pq.isEmpty()) {
			for (int i = 0; i < priorities.length; i++) {
				if (priorities[i] == (int) pq.peek()) { // priorities와 pq의 첫 값이 같을 때
					if (i == location) { // 찾는 위치
						return answer;
					}
					pq.poll(); // pq에서 아이템 제거
					answer++; // 위치 1 증가
				}
			}
		}
		return answer;
	}

}

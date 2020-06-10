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
			pq.add(e); // PriorityQueue�� ������������ ����
		}
		while (!pq.isEmpty()) {
			for (int i = 0; i < priorities.length; i++) {
				if (priorities[i] == (int) pq.peek()) { // priorities�� pq�� ù ���� ���� ��
					if (i == location) { // ã�� ��ġ
						return answer;
					}
					pq.poll(); // pq���� ������ ����
					answer++; // ��ġ 1 ����
				}
			}
		}
		return answer;
	}

}

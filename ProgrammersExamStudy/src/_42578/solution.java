package _42578;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author cw https://programmers.co.kr/learn/courses/30/lessons/42578
 *
 */
public class solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] clothes = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
				{ "green_turban", "headgear" } };
		// String[][] clothes = { { "crow_mask", "face" }, { "blue_sunglasses", "face"
		// }, { "smoky_makeup", "face" } };

		int answer = 0;
		answer = 1;

		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < clothes.length; i++) {
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1); // �ǻ��� ������ ���� �� ����
		}

		for (int val : map.values()) {
			answer *= (val + 1); // �����ϴ� ��� / �������� �ʴ� ����� �� ����
		}
		answer = answer - 1; // �ƹ��͵� ���� ���� ��츦 ����

		System.out.println(answer);
	}
}
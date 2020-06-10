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
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1); // 의상의 종류에 따라 값 저장
		}

		for (int val : map.values()) {
			answer *= (val + 1); // 선택하는 경우 / 선택하지 않는 경우의 합 누적
		}
		answer = answer - 1; // 아무것도 입지 않은 경우를 제외

		System.out.println(answer);
	}
}
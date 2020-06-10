package _42576;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author cw https://programmers.co.kr/learn/courses/30/lessons/42576
 */
public class solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// String[] participant = {"leo", "kiki", "eden"};
		// String[] completion = {"eden", "kiki"};
		// String[] participant = { "marina", "josipa", "nikola", "vinko", "filipa" };
		// String[] completion = { "josipa", "filipa", "marina", "nikola" };
		String[] participant = { "mislav", "stanko", "mislav", "ana" };
		String[] completion = { "stanko", "ana", "mislav" };

		String answer = "";

		Map<String, Integer> map = new HashMap<>();
		for (String part : participant) {
			if (map.get(part) == null) {
				map.put(part, 1); // 1명씩 추가
			} else {
				map.put(part, map.get(part) + 1); // 동명이인일 경우 원래 값에 1 추가, 핵심 부분
			}
		}

		for (String comp : completion) {
			map.put(comp, map.get(comp) - 1); // 1명씩 완주 처리
		}

		for (String k : map.keySet()) {
			if (map.get(k) == 1) // 남은 사람이 완주하지 못한 선수
				answer = k;
		}

		System.out.println(answer);
	}

}

package _42579;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 
 * @author cw https://programmers.co.kr/learn/courses/30/lessons/42579
 *
 */
public class solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };

		int[] answer = {};

		List<Integer> list = new LinkedList<>();
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {
			map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]); // �帣�� �帣�� ���Ƚ�� �߰�
		}

		Set<String> set = map.keySet();
		Map<Integer, String> revMap = new HashMap<>();

		for (String e : set) {
			revMap.put(map.get(e), e); // �帣�� ���Ƚ���� �帣 �߰�
		}

		TreeMap<Integer, String> tMap = new TreeMap<>(revMap);
		int tMapSize = tMap.size();

		for (int i = 0; i < tMapSize; i++) {
			String genre = tMap.lastEntry().getValue();
			int deleteKey = tMap.lastEntry().getKey();

			int max = -1, nextmax = -1;
			int maxIndex = -1, nextmaxIndex = -1;

			for (int g = 0; g < genres.length; g++) {
				if (genres[g].equals(genre)) {
					boolean check = max != plays[g];
					max = Math.max(max, plays[g]); // ���� �帣�� �ִ� ���Ƚ�� �� ����
					if (plays[g] == max && check) {
						maxIndex = g;
					}
				}
			}
			plays[maxIndex] = -1;
			genres[maxIndex] = "-1";
			list.add(maxIndex); // �� �߰�

			for (int g = 0; g < genres.length; g++) {
				if (genres[g].equals(genre)) {
					nextmax = Math.max(nextmax, plays[g]);
					if (plays[g] == nextmax) {
						nextmaxIndex = g;
					}
				}
			}
			if (nextmaxIndex != -1) {
				plays[nextmaxIndex] = -1;
				genres[nextmaxIndex] = "-1";
				list.add(nextmaxIndex); // ���� �帣�� ���Ƚ�������� �� �߰�
			}
			tMap.remove(deleteKey); // �帣 ����
		}
		answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		// System.out.println(answer);
		for (int e : answer) {
			System.out.print(e + " ");
		}
	}

}

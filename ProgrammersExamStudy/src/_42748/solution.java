package _42748;

import java.util.ArrayList;
import java.util.Collections;

public class solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

		int[] answer = new int[commands.length];
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < commands.length; i++) {
			for (int j = commands[i][0] - 1; j < commands[i][1]; j++) { // commands의 첫값과 두번째값 사이 반복
				list.add(array[j]); // 첫값, 두번째값 사이의 원소를 추가
			}
			Collections.sort(list);
			answer[i] = list.get(commands[i][2] - 1);
			list.clear();
		}

		// return answer;
		for (int e : answer) {
			System.out.print(e + " ");
		}
	}

}

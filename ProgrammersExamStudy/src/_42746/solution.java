package _42746;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author cw https://programmers.co.kr/learn/courses/30/lessons/42746
 *
 */
public class solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = { 6, 10, 2 };
		// int[] numbers = { 3, 30, 34, 5, 9 };

		String answer = "";

		int[][] copies = new int[numbers.length][2];
		int index = 0;
		StringBuilder sb = new StringBuilder();
		String temp;
		for (int e : numbers) {
			sb.setLength(0);
			sb.append(String.valueOf(e));
			while (sb.length() <= 4) { // numbers�� ���ڸ� 5-6 �ڸ��� ����. 66666/10101/22222, 33333/30303/34343/55555/99999
				sb.append(e);
			}
			temp = sb.toString();
			if (temp.length() > 5) { //
				temp = temp.substring(0, 5); // �ݺ��Ǿ� ������ ���ڸ� 5�ڸ��� �ڸ�
			}
			copies[index][0] = Integer.valueOf(temp);
			copies[index][1] = e;
			index++;
		}

		Arrays.sort(copies, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] > o2[0] ? -1 : o1[0] < o2[0] ? 1 : 0;
			}
		}); // 5�ڸ� ������ ũ��� ����
		sb.setLength(0);
		for (int[] e : copies) { // ���ĵ� ������� ���� numbers�� �� �̾����
			sb.append(e[1]);
		}

		answer = sb.toString();
		if (answer.charAt(0) == '0') { // 0 �ϰ�� String 0 ���� ��ȯ
			answer = "0";
		}

		// return answer;
		System.out.println(answer);
	}

}

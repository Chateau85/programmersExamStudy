package _42588;

/**
 * 
 * @author cw https://programmers.co.kr/learn/courses/30/lessons/42588
 *
 */
public class solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] heights = { 6, 9, 5, 7, 4 };
		// int[] heights = {3,9,9,3,5,7,2};
		// int[] heights = {1,5,3,6,7,6,5};

		int[] answer = {};

		answer = new int[heights.length];
		for (int i = heights.length - 1; i >= 0; i--) { // �ڿ������� �˻�
			for (int j = i - 1; j >= 0; j--) { // ���õ� ž�� �ٷ� �պ��� �˻�
				if (heights[i] < heights[j]) { // ������ �� ���� ž�� ���� Ŭ ���
					answer[i] = j + 1; // ���� ������ ��ȣ�� �� ���� ž�� ������
					break;
				}
			}
		}

		// System.out.println(answer);
		for (int e : answer) {
			System.out.print(e + " ");
		}
	}

}

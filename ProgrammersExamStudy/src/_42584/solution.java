package _42584;

/**
 * 
 * @author cw https://programmers.co.kr/learn/courses/30/lessons/42584
 *
 */
public class solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = { 1, 2, 3, 2, 3 };

		int[] answer = {};
		answer = new int[prices.length];
		for (int i = 0; i < answer.length; i++) {
			for (int j = i + 1; j < answer.length; j++) {
				if (prices[i] > prices[j]) { // ���� ���� �ڽź��� ������ ������ ������ ������ ����(1) �Է�
					answer[i] = j - i;
					break; // �� �ݺ����� ������ �ʿ� ����
				}
				if (j == answer.length - 1) { // ������ �������� �ʰ� ������ ���� ��� �ڽ��� ��ġ�� ���� ��ġ ���� �Է�
					answer[i] = j - i;
				}
			}
		}

		for (int e : answer) {
			System.out.print(e + " ");
		}
	}

}

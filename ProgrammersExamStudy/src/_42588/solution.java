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
		for (int i = heights.length - 1; i >= 0; i--) { // 뒤에서부터 검사
			for (int j = i - 1; j >= 0; j--) { // 선택된 탑의 바로 앞부터 검사
				if (heights[i] < heights[j]) { // 나보다 내 앞쪽 탑의 값이 클 경우
					answer[i] = j + 1; // 나의 레이저 신호는 내 앞쪽 탑이 수신함
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

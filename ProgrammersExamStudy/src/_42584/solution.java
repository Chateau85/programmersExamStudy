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
				if (prices[i] > prices[j]) { // 다음 값이 자신보다 작으면 가격이 떨어진 것으로 차이(1) 입력
					answer[i] = j - i;
					break; // 더 반복문을 수행할 필요 없음
				}
				if (j == answer.length - 1) { // 가격이 떨어지지 않고 끝까지 갔을 경우 자신의 위치와 끝의 위치 차이 입력
					answer[i] = j - i;
				}
			}
		}

		for (int e : answer) {
			System.out.print(e + " ");
		}
	}

}

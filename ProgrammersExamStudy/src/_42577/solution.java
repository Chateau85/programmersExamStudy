package _42577;

/**
 * 
 * @author cw https://programmers.co.kr/learn/courses/30/lessons/42577
 *
 */
public class solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] phone_book = { "119", "97674223", "1195524421" };
		// String[] phone_book = { "123", "456", "789" };
		// String[] phone_book = {"12","123","1235","567","88"};

		boolean answer = true;

		for (int i = 0; i < phone_book.length - 1; i++) {
			for (int j = i + 1; j < phone_book.length; j++) { // ���õ� �׸��� ���� �׸���� �˻�
				if (!phone_book[i].equals(phone_book[j])) {
					if (phone_book[i].startsWith(phone_book[j])) { // �� ��ȣ�� �� ��ȣ�� �����ϴ���
						answer = false;
						break; // �ٷ� �ݺ��� ����
					} else if (phone_book[j].startsWith(phone_book[i])) { // �� ��ȣ�� �� ��ȣ�� �����ϴ���
						answer = false;
						break;
					}
				}
			}
		}

		System.out.println(answer);
	}

}

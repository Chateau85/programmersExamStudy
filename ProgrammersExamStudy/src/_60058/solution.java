package _60058;

import java.util.Stack;

public class solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String p = "()))((()";
		String answer = "";

		answer = convertBracket(p);

		System.out.println(answer);
	}

	private static String convertBracket(String p) {
		// TODO Auto-generated method stub
		String result = "";
		if (checkBracket(p)) {
			result = p;
		} else {
			result = recursive(p);
		}
		return result;
	}

	private static String recursive(String p) {
		// TODO Auto-generated method stub
		if (p.length() == 0) {
			return "";
		}

		String u = "";
		String v = "";
		int[] check = new int[2];
		int i = 0;
		while (i < p.length()) {
			if (p.charAt(i) == '(') {
				u += "(";
				check[0]++;
			} else {
				u += ")";
				check[1]++;
			}
			if (check[0] == check[1]) {
				break;
			}
			i++;
		}

		v = p.substring(i + 1);
		if (checkBracket(u)) {
			return u + recursive(v);
		} else {
			String subStr = "";
			for (int j = 1; j < u.length() - 1; j++) {
				if (u.charAt(j) == '(') {
					subStr += ")";
				} else {
					subStr += "(";
				}
			}
			return "(" + recursive(v) + ")" + subStr;
		}
	}

	private static boolean checkBracket(String result) {
		// TODO Auto-generated method stub
		boolean check = true;
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < result.length(); i++) {
			if (result.charAt(i) == ')') {
				if (st.isEmpty()) {
					check = false;
					break;
				} else {
					st.pop();
				}
			} else {
				st.push(result.charAt(i));
			}
		}
		return check;
	}

}

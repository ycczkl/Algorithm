import java.util.Arrays;
import java.util.Stack;

public class BasicCarculater {
	public int calculate(String s) {
		char[] str = s.toCharArray();
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < str.length; i++) {
//			System.out.println(Arrays.deepToString(stack.toArray()));
			if (str[i] == '(') {
				stack.push("(");
			} else if (str[i] == ' ') {
				continue;
			} else if (str[i] == ')') {
				int res = 0;
				while (!stack.peek().equals("(")) {
					StringBuilder sb = new StringBuilder();
					while (!stack.isEmpty() && stack.peek().charAt(0) >= '0'
							&& stack.peek().charAt(0) <= '9') {
						sb.append(stack.pop());
						// System.out.println(sb.toString());
					}
					int v = Integer.parseInt(sb.reverse().toString());
					// System.out.println(v);
					if (!stack.peek().equals("("))
						v = stack.pop().equals("+") ? v : -v;
					res += v;
//					System.out.println(res);
				}
				stack.pop();
				if (res < 0) {
					if (!stack.isEmpty()) {
						String sym = stack.pop();
						sym = sym.equals("-") ? "+" : "-";
						stack.push(sym);
					} else {
						stack.push("-");
					}
					res = -res;
				}
				String tmp = res + "";
				for (int j = 0; j < tmp.length(); j++) {
					stack.push("" + tmp.charAt(j));
				}
			} else {
				stack.push(str[i] + "");
			}
		}
		if (stack.size() == 1)
			return Integer.parseInt(stack.pop());
		int res = 0;

		while (!stack.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			while (!stack.isEmpty() && stack.peek().charAt(0) >= '0'
					&& stack.peek().charAt(0) <= '9') {
				sb.append(stack.pop());
			}
			int v = Integer.parseInt(sb.reverse().toString());
			if (!stack.isEmpty())
				v = stack.pop().equals("+") ? v : -v;
			res += v;
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		BasicCarculater cobj = new BasicCarculater();
		System.out.println(cobj.calculate("(5-(1+(5)))"));
	}
}

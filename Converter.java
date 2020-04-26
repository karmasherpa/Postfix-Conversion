
public class Converter {

		private static boolean isOperator(char ch) {

			return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '(' || ch == ')';

		}

		private static int getOperator(char operator) {

			switch (operator) {

			case '+':

			case '-':

				return 1;

			case '*':

			case '/':

				return 2;

			}

			return -1;

		}

		// function to check if the given character is operand

		private static boolean isOperand(char alpha) {

			return (alpha >= 'a' && alpha <= 'z') || (alpha >= 'A' && alpha <= 'Z') || (alpha >= '0' && alpha <= '9');

		}

		public String convertPostfix(String infix) {

			DynamicArrayStack<Character> stack1 = new DynamicArrayStack<Character>();
			String postfix = "";

			char c;

			for (int i = 0; i < infix.length(); i++) {

				c = infix.charAt(i);

				if (isOperand(c)) {

					postfix += c;

				} else if (c == '(') {

					stack1.push(c);

				}
				
				else if (c == ')') {  

					while (!stack1.isEmpty() && stack1.top() != '(') {

						postfix += (stack1.pop());

					}

					if (!stack1.isEmpty() && stack1.top() != '(')

						return null;

					else if (!stack1.isEmpty())

						stack1.pop();

				}

				else if (isOperator(c)) // operator encountered

				{

					if (!stack1.isEmpty() && getOperator(c) <= getOperator(stack1.top())) {

						postfix += (stack1.pop());

					}
					postfix += " ";
					stack1.push(c);
					//postfix = " ";
				}

			}

			while (!stack1.isEmpty()) {

				postfix += (stack1.pop());

			}
			return postfix.toString();

		}

}

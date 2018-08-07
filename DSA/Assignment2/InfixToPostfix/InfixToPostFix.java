package Assignment2;

/*
 * InfixToPostFix - convert Infix Expression to Postfix Expression
 */
public class InfixToPostFix implements CharacterStack {
	private String arrayStack[];
	private int sizeofStack = 0;
	private int top = -1;


	public InfixToPostFix(int sizeofStack) {
		this.sizeofStack = sizeofStack;
		arrayStack = new String[sizeofStack];
	}
	
	/*
	 * (non-Javadoc)
	 * @see Assignment2.CharacterStack#peek() Peek - return top element of stack
	 * @return T - generic type, top element of stack
	 */
	@Override
	public String peek() {
		return arrayStack[top];
	}

	/*
	 * (non-Javadoc)
	 * @see Assignment2.CharacterStack#pop() Push - Is to push value into the stack
	 * @param item - of generic type
	 */
	@Override
	public void push(String item) {
		try {
			if (top == sizeofStack) {
				System.out.println("Stack overflow");
			} else {
				top = top + 1;
				arrayStack[top] = item;
			}
		} catch (Exception e) {
			e.getStackTrace();
		}

	}

	/*
	 * (non-Javadoc)
	 * @see Assignment2.CharacterStack#push(java.lang.String) 
	 * pop - To pop element from the stack
	 * @return T - generic value that has been pop.
	 */
	@Override
	public String pop() {
		String value = "";
		try {
			if (top == -1) {
				System.out.println("Stack underflow");
			} else {
				String popValue = arrayStack[top--];
				value = popValue;
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return value;

	}

	/*
	 * Precedence - Check the precedence of operator
	 * @param operator - String operator that will pass
	 * @return precedence number or rank
	 */
	private int Precedence(String operator) {
		switch (operator) {
		case "||":
			return 1;
		case "&&":
			return 2;
		case "==":
		case "!=":
			return 3;
		case "<":
		case ">":
		case "<=":
		case ">=":
			return 4;
		case "+":
		case "-":
			return 5;
		case "*":
		case "/":
			return 6;
		case "^":
			return 7;
		}
		return -1;
	}

	/*
	 * infixToPostfix - convert infix Expression to postfix expression
	 * @param expression - infix expression
	 * @return result - postfix expression
	 */
	public String infixToPostfix(String expression) {
		String result = new String("");

		String[] characterOfExpression = expression.split(" ");
		try {
			for (int i = 0; i < characterOfExpression.length; ++i) {

				if (Character.isLetter(characterOfExpression[i].charAt(0))) { // Check whether expression is letter or not
					result += characterOfExpression[i];
				} else if ("(".equals(characterOfExpression[i])) {
					push(characterOfExpression[i]);
				}

				else if (")".equals(characterOfExpression[i])) { // if ) is found it will start pop from the stack until ( is not found
					while (!isEmpty() && !"(".equals(peek())) {
						result += pop();
					}

					if (!isEmpty() && !"(".equals(peek())) { // if ( is not found it will show error
						return "Invalid Expression";
					} else {
						pop();
					}
				} else {
					while (!isEmpty()
							&& Precedence(characterOfExpression[i]) <= Precedence(peek())) {
						result += pop();
					}
					push(characterOfExpression[i]);
				}
			}
			while (!isEmpty()) {
				result += pop();
			}
		} catch (Exception exception) {
			exception.getStackTrace();
		}

		return result;
	}

	/*
	 * isEmpty -  check whether stack is empty or not
	 * @return boolean value - true if empty else false
	 */
	private boolean isEmpty() {
		boolean value = false;
		if (top == -1) {
			value = true;
		}
		return value;
	}

	public static void main(String[] args) {
		String expression = "A && H <= A";
		InfixToPostFix fix = new InfixToPostFix(10);
		System.out.println(fix.infixToPostfix(expression));
	}
}

import java.util.Scanner;

/*
 * PostfixEvaluation - Evaluate postfix Expression
 */
public class PostfixEvaluation implements Stack {
	private int arrayStack[];
	private int sizeofStack = 0;
	private int top = -1;

	public PostfixEvaluation(int sizeofStack) {
		this.sizeofStack = sizeofStack;
		arrayStack = new int[sizeofStack];
	}

	/**
	 * Check whether string is integer or not
	 * @param stringValue
	 * @return
	 */
	public static boolean isInteger(String stringValue) {
		return isInteger(stringValue, 10);
	}

	/**
	 * Convert String into Integer 
	 * @param stringValue
	 * @param radix
	 * @return
	 */
	public static boolean isInteger(String stringValue, int radix) {
		if (stringValue.isEmpty())
			return false;
		for (int i = 0; i < stringValue.length(); i++) {
			if (i == 0 && stringValue.charAt(i) == '-') {
				if (stringValue.length() == 1) {
					return false;
				} else {
					continue;
				}
			}
			if (Character.digit(stringValue.charAt(i), radix) < 0)
				{
				return false;
				}
		}
		return true;
	}

	/*
	 * evaluateExpression - evaluate the postfix expression
	 * @param expression - Postfix Expression
	 * @return top element of stack
	 */
	public int evaluateExpression(String expression) {
		try {
			String expressionArray[] = expression.split(" ");
			for (int i = 0; i < expressionArray.length; i++) {
				String characterOfString = new String();

				characterOfString = expressionArray[i];

				if (isInteger(characterOfString)) {
					push(Integer.parseInt(characterOfString));
				} else {
					int popElement1 = pop();
					int popElement2 = pop();

					switch (characterOfString) {
					case "+":
						push(popElement2 + popElement1);
						break;

					case "-":
						push(popElement2 - popElement1);
						break;

					case "/":
						push(popElement2 / popElement1);
						break;

					case "*":
						push(popElement2 * popElement1);
						break;
					}
				}

			}
		} catch (Exception exception) {
			exception.getStackTrace();
		}

		return pop();
	}

	/*
	 * (non-Javadoc)
	 * @see Question1.Stack#peek() Peek - return top element of stack
	 * @return T - generic type, top element of stack
	 */
	@Override
	public int peek() {
		return arrayStack[top];
	}

	/*
	 * (non-Javadoc)
	 * @see Question2.Stack#push(java.lang.Object) 
	 * Push - Is to push value into the stack
	 * @param item - of generic type
	 */
	@Override
	public void push(int item) {
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
	 * @see Question2.Stack#pop() 
	 * pop - To pop element from the stack
	 * @return T - generic value that has been pop.
	 */
	@Override
	public int pop() {
		int value = 0;
		try {
			if (top == -1) {
				System.out.println("Stack underflow");
			} else {
				int popValue = arrayStack[top--];
				value = popValue;
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return value;

	}

	public static void main(String[] arg) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter postfix Expression : ");
		String expression = input.nextLine();
		PostfixEvaluation evaluation = new PostfixEvaluation(100);
		int value = evaluation.evaluateExpression(expression);
		System.out.print("Value : " + value);
	}
}
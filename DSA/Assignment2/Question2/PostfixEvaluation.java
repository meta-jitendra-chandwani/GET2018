package Assignment2;

import java.util.Scanner;

/*
 * PostfixEvaluation - Evaluate postfix Expression
 */
public class PostfixEvaluation implements Stack {
	static Scanner input = new Scanner(System.in);

	private int arrayStack[];
	private int sizeofStack = 0;

	public PostfixEvaluation(int sizeofStack) {
		this.sizeofStack = sizeofStack;
		arrayStack = new int[sizeofStack];
	}

	private int top = -1;

	/*
	 * evaluateExpression - evaluate the postfix expression
	 * @param expression - Postfix Expression
	 * @return top element of stack
	 */
	public int evaluateExpression(String expression) {
		try {
			for (int i = 0; i < expression.length(); i++) {
				char characterOfString = 0;
				if (i % 2 == 0) {
					characterOfString = expression.charAt(i);

					if (Character.isDigit(characterOfString)) {
						push(characterOfString - '0');
					} else {
						int popElement1 = pop();
						int popElement2 = pop();

						switch (characterOfString) {
						case '+':
							push(popElement2 + popElement1);
							break;

						case '-':
							push(popElement2 - popElement1);
							break;

						case '/':
							push(popElement2 / popElement1);
							break;

						case '*':
							push(popElement2 * popElement1);
							break;
						}
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
	 * @see Question2.Stack#push(java.lang.Object) Push - Is to push value into the stack
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
	 * @see Question2.Stack#pop() pop - To pop element from the stack
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
		System.out.println("Enter postfix Expression : ");
		String expression = input.nextLine();
		PostfixEvaluation evaluation = new PostfixEvaluation(10);
		int value = evaluation.evaluateExpression(expression);
		System.out.print("Value : " + value);
	}
}
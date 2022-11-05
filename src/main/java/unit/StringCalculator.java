package unit;

import java.util.Scanner;

public class StringCalculator {
	private String[] values;
	private int result;
	private String operator = "+";

	void init() {
		Scanner scanner = new Scanner(System.in);
		String value = scanner.nextLine();
		String[] values = value.split(" ");
		this.values = values;
	}

	int calc() {
		for (String op : values) {
			if (op.matches("[^0-9]")) {
				this.operator = op;
			}

			if (op.matches("[0-9]+")) {
				checkOperaterAndCalc(Integer.parseInt(op));
			}
		}
		
		return result;
	}

	void checkOperaterAndCalc(int operand) {
		if (this.operator.equals("+")) {
			add(operand);
			return;
		}
		if (this.operator.equals("-")) {
			sub(operand);
			return;
		}
		if (this.operator.equals("*")) {
			mul(operand);
			return;
		}
		if (this.operator.equals("/")) {
			div(operand);
			return;
		}
	}

	void add(int num) {
		result += num;
	}

	void sub(int num) {	
		result -= num;
	}

	void mul(int num) {
		result *= num;
	}

	void div(int num) {
		result /= num;
	}
}

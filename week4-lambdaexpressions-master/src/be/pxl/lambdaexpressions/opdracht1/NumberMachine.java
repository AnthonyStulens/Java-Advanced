package be.pxl.lambdaexpressions.opdracht1;

import java.util.ArrayList;
import java.util.function.Function;

public class NumberMachine {
	private ArrayList<Integer> numbers = new ArrayList<>();

	public NumberMachine(int[] numbers) {
		for (int i = 0; i < numbers.length; i++)
			this.numbers.add(numbers[i]);
	}

	public String processNumbers(NumberFilter filter) {
		String result = "";
		for (int i = 0; i < numbers.size(); i++) {
			if (filter.check(numbers.get(i))) {
				result += numbers.get(i) + "-";
			}
		}
		result = result.substring(0, result.length() - 1);
		return result;
	}

	public String convertNumbers(NumberConvertor convertor) {
		String result = "";
		for (int i = 0; i < numbers.size(); i++) {
			result += convertor.convert(numbers.get(i)) + "-";
		}
		result = result.substring(0, result.length() - 1);
		return result;

	}
}

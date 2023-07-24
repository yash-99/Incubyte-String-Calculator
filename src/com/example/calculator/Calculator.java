package com.example.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator extends Exception {

	public static int add(String numbers) throws Exception {

		int sum = 0;

		if (numbers.length() > 0) {

//			Pattern pattern = Pattern.compile("//(\\[.*\\])(\\[.*\\])\n(.*)");
//			Matcher matcher = pattern.matcher(numbers);
//			matcher.matches();
			

			String[] numberArray = convertToStringArray(numbers);
            StringBuilder negativeNumbers = new StringBuilder();

            for (String num : numberArray) {
                int n = Integer.parseInt(num);
                if (n < 0) {
                    negativeNumbers.append(n).append(" ");
                } else  {
                    sum += n;
                }
            }

            if (negativeNumbers.length() > 0) {
                throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers.toString().trim());
            }

            

		}

		return sum;
	}
	
	
	  private static String[] convertToStringArray(String numbers) {
	        if (numbers.startsWith("//")) {
	            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(numbers);
	            if (matcher.matches()) {
	                String group1 = matcher.group(1);
	                return matcher.group(2).split(group1);
	            }
	        }
	        return numbers.split(",|\n");
	    }

}

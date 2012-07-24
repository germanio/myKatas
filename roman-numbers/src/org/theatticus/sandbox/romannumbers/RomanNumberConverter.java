package org.theatticus.sandbox.romannumbers;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

public class RomanNumberConverter {

	private static final int ONE_DECIMAL = 1;
	private static final int FIVE_DECIMAL = 5;
	private static final int TEN_DECIMAL = 10;
	private static final int HUNDRED_DECIMAL = 100;
	private static final int THOUSAND_DECIMAL = 1000;
	
	private static final String ONE_ROMAN = "I";
	private static final String FIVE_ROMAN = "V";
	private static final String TEN_ROMAN = "X";
	private static final String HUNDRED_ROMAN = "C";
	private static final String THOUSAND_ROMAN = "M";
	
	private Map<String, Integer> translator;
	
	public RomanNumberConverter(Map<String, Integer> myTranslator) {
		this.translator = myTranslator;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, Integer> translator = initializeTranslator();
		
		RomanNumberConverter converter = new RomanNumberConverter(translator);
		String[] romans = {"I","II","III","IV","V","VI","VII","VIII","IX","X","MCMXCIX"};
		Integer[] decimals = converter.convert(romans);
		
		for (int pos = 0; pos < decimals.length; pos++) {
			System.out.println("Resultados: " + decimals[pos]);
			System.out.println("En Romanos: " + romans[pos]);
		}
	}

	private static Map<String, Integer> initializeTranslator() {
		Map<String, Integer> translator = new HashMap<String, Integer>();
		translator.put(ONE_ROMAN, ONE_DECIMAL);
		translator.put(FIVE_ROMAN, FIVE_DECIMAL);
		translator.put(TEN_ROMAN, TEN_DECIMAL);
		translator.put(HUNDRED_ROMAN, HUNDRED_DECIMAL);
		translator.put(THOUSAND_ROMAN, THOUSAND_DECIMAL);
		
		return translator;
	}

	private Integer[] convert(String[] romans) {
		Integer[] decimals = new Integer[romans.length];
		
		for (int pos = 0; pos < romans.length; pos++) {
			String roman = romans[pos];
			decimals[pos] = convertRomanNumber(roman);
		}
		return decimals;
	}

	private Integer convertRomanNumber(String roman) {
		int total = 0;
		int partialNumber = 0;
		int previousValue = 0;
		
		for (int pos = 0; pos < roman.length(); pos++) {
			String simbol = String.valueOf(roman.charAt(pos));
			Integer tmp = translator.get(simbol);
			if (tmp == null)
				throw new InvalidParameterException("One of the simbols is not recognized.");
			
			int actualValue = tmp.intValue();
			if (previousValue == 0){
				partialNumber = actualValue;
			}else if (previousValue >= actualValue){
				partialNumber += actualValue;
			}else{
				partialNumber = partialNumber - previousValue + (actualValue - previousValue);
			}
			previousValue = actualValue;
		}
		
		total = partialNumber;
		
		return Integer.valueOf(total);
	}

}

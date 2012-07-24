package org.theatticus.sandbox.kata;

import java.security.InvalidParameterException;

public class OCRParser {

	public static final String[] OCR_ZERO = new String[]{
			" _ ",
	        "| |",
	        "|_|",
	        "   "
	        };
	
	public static final String[] OCR_NINE = new String[]{
			" _ ",
	        "|_|",
	        " _|",
	        "   "
	        };
	
	public static final String[] OCR_EIGHT = new String[]{
			" _ ",
	        "|_|",
	        "|_|",
	        "   "
	        };
	
	public static final String[] OCR_SEVEN = new String[]{
			" _ ",
	        "  |",
	        "  |",
	        "   "
	        };
	
	public static final String[] OCR_SIX = new String[]{
			" _ ",
	        "|_ ",
	        "|_|",
	        "   "
	        };
	
	public static final String[] OCR_FIVE = new String[]{
			" _ ",
	        "|_ ",
	        " _|",
	        "   "
	        };
	
	public static final String[] OCR_FOUR = new String[]{
			"   ",
	        "|_|",
	        "  |",
	        "   "
	        };
	
	public static final String[] OCR_THREE = new String[]{
			" _ ",
	        " _|",
	        " _|",
	        "   "
	        };
	
	public static final String[] OCR_TWO = new String[]{
			" _ ",
	        " _|",
	        "|_ ",
	        "   "
	        };
	
	public static final String[] OCR_ONE = new String[]{
			"   ",
	        "  |",
	        "  |",
	        "   "
	        };

	private Splitter splitter;

	public OCRParser(){
		splitter = new OCRSplitter();
	}
	
	public String parseUnit(String[] ocr) {
		if (theseAreTheSameCode(OCR_ONE, ocr))
			return "1";
		if (theseAreTheSameCode(OCR_TWO, ocr))
			return "2";
		if (theseAreTheSameCode(OCR_THREE, ocr))
			return "3";
		if (theseAreTheSameCode(OCR_FOUR, ocr))
			return "4";
		if (theseAreTheSameCode(OCR_FIVE, ocr))
			return "5";
		if (theseAreTheSameCode(OCR_SIX, ocr))
			return "6";
		if (theseAreTheSameCode(OCR_SEVEN, ocr))
			return "7";
		if (theseAreTheSameCode(OCR_EIGHT, ocr))
			return "8";
		if (theseAreTheSameCode(OCR_NINE, ocr))
			return "9";
		if (theseAreTheSameCode(OCR_ZERO, ocr))
			return "0";

		throw new InvalidParameterException("the OCR code is invalid");
	}

	private boolean theseAreTheSameCode(String[] expected, String[] ocr) {
		for (int index = 0; index < expected.length; index++) {
			if (!expected[index].equals(ocr[index]))
				return false;
		}
		
		return true;
	}

	public String parse(String[] ocr) {
		String result = "";
		
		String[][] splitted = splitter.split(ocr);
		for (int index = 0; index < splitted.length; index++) {
			String unit = parseUnit(splitted[index]);
			result += unit;
		}
		return result;
	}

}

package org.theatticus.sandbox.kata.bankocr;

import org.junit.Assert;
import org.junit.Test;
import org.theatticus.sandbox.kata.bankocr.OCRParser;
import org.theatticus.sandbox.kata.bankocr.OCRSplitter;
import org.theatticus.sandbox.kata.bankocr.Splitter;


public class KataBankOCR {

	private static final String[] OCR_ONE_DIGIT = new String[]{
					"   ",
					"  |",
					"  |",
					"   "
			};

	private static final String[] OCR_TWO_DIGITS = new String[]{
					"    _ ",
					"  ||_ ",
					"  | _|",
					"      "
			};

	private static final String[] OCR_THREE_DIGITS = new String[]{
					"    _  _ ",
					"  ||_ |_|",
					"  | _||_|",
					"         "
			};

	private static final String[] OCR_FOUR_DIGITS = {
					" _  _  _    ",
					"|_   ||_|  |",
					" _|  | _|  |",
					"            "
			};

	private static final String[] OCR_FULL_DIGITS_579123460 = new String[]{
					" _  _  _     _  _     _  _ ",
					"|_   ||_|  | _| _||_||_ | |",
					" _|  | _|  ||_  _|  ||_||_|",
					"                           "
			};

	private static final String[] OCR_FULL_DIGITS_132435467 = new String[]{
					"    _  _     _  _     _  _ ",
					"  | _| _||_| _||_ |_||_   |",
					"  | _||_   | _| _|  ||_|  |",
					"                           "
			};
	
	public static final String[] OCR_INVALID_LENGHT = new String[]{
					"||||",
			        "|||  ",
			        "| |",
			        "   "
	        };
	
	private static final String[] OCR_INVALID_LESS_LINES = new String[]{
					" _ ",
				    "| |",
				    "   "
		    };

	public static final String[] OCR_INVALID_NUMBER = new String[]{
					" _ ",
			        "  |",
			        "| |",
			        "   "
	        };

	private static final String[] OCR_INVALID_FULL_DIGITS_WITH_SHORTER_LINES = new String[]{
					" _  _  _     _  _     _  ",
					"|_   ||_|  | _| _||_||_ | |",
					" _|  | _|  ||_  _|  ||_||_|",
					"                         "
			};

	private static final String[] OCR_INVALID_FULL_DIGITS_WITH_SHORTER_LENGHT = new String[]{
					" _  _  _     _  _     _  _",
					"|_   ||_|  | _| _||_||_ | ",
					" _|  | _|  ||_  _|  ||_||_",
					"                          "
			};

	@Test
	public void parseNumberOne(){
		String[] ocr = OCRParser.OCR_ONE;
		OCRParser parser = new OCRParser();
		String parsedNumber = parser.parseUnit(ocr);
		
		Assert.assertEquals("1", parsedNumber);
	}

	@Test
	public void parseNumberTwo(){
		String[] ocr = OCRParser.OCR_TWO;
		OCRParser parser = new OCRParser();
		String parsedNumber = parser.parseUnit(ocr);
		
		Assert.assertEquals("2", parsedNumber);
	}
	
	@Test
	public void parseNumberThree(){
		String[] ocr = OCRParser.OCR_THREE;
		OCRParser parser = new OCRParser();
		String parsedNumber = parser.parseUnit(ocr);
		
		Assert.assertEquals("3", parsedNumber);
	}
	
	@Test
	public void parseNumberFour(){
		String[] ocr = OCRParser.OCR_FOUR;
		OCRParser parser = new OCRParser();
		String parsedNumber = parser.parseUnit(ocr);
		
		Assert.assertEquals("4", parsedNumber);
	}
	
	@Test
	public void parseNumberFive(){
		String[] ocr = OCRParser.OCR_FIVE;
		OCRParser parser = new OCRParser();
		String parsedNumber = parser.parseUnit(ocr);
		
		Assert.assertEquals("5", parsedNumber);
	}
	
	@Test
	public void parseNumberSix(){
		String[] ocr = OCRParser.OCR_SIX;
		OCRParser parser = new OCRParser();
		String parsedNumber = parser.parseUnit(ocr);
		
		Assert.assertEquals("6", parsedNumber);
	}
	
	@Test
	public void parseNumberSeven(){
		String[] ocr = OCRParser.OCR_SEVEN;
		OCRParser parser = new OCRParser();
		String parsedNumber = parser.parseUnit(ocr);
		
		Assert.assertEquals("7", parsedNumber);
	}
	
	@Test
	public void parseNumberEight(){
		String[] ocr = OCRParser.OCR_EIGHT;
		OCRParser parser = new OCRParser();
		String parsedNumber = parser.parseUnit(ocr);
		
		Assert.assertEquals("8", parsedNumber);
	}
	
	@Test
	public void parseNumberNine(){
		String[] ocr = OCRParser.OCR_NINE;
		OCRParser parser = new OCRParser();
		String parsedNumber = parser.parseUnit(ocr);
		
		Assert.assertEquals("9", parsedNumber);
	}
	
	@Test
	public void parseNumberZero(){
		String[] ocr = OCRParser.OCR_ZERO;
		OCRParser parser = new OCRParser();
		String parsedNumber = parser.parseUnit(ocr);
		
		Assert.assertEquals("0", parsedNumber);
	}
	
	@Test
	public void parseAnInvalidOCR(){
		String[] ocr = OCR_INVALID_NUMBER;
		try{
			OCRParser parser = new OCRParser();
			parser.parseUnit(ocr);
			
			Assert.fail("the parser has to throw an exception if the OCR is invalid");
		} catch (Exception e){
		}
	}
	
	@Test
	public void splitIntoOneOCRUnits(){
		String[] ocr = OCR_ONE_DIGIT;
		
		Splitter splitter = new OCRSplitter();
		String[][] splitted = splitter.split(ocr);
		
		Assert.assertArrayEquals(OCRParser.OCR_ONE, splitted[0]);
	}
	
	@Test
	public void splitIntoTwoOCRUnits(){
		String[] ocr = OCR_TWO_DIGITS;
		
		Splitter splitter = new OCRSplitter();
		String[][] splitted = splitter.split(ocr);
		
		Assert.assertArrayEquals(OCRParser.OCR_FIVE, splitted[1]);
	}
	
	@Test
	public void splitIntoThreeOCRUnits(){
		String[] ocr = OCR_THREE_DIGITS;
		
		Splitter splitter = new OCRSplitter();
		String[][] splitted = splitter.split(ocr);
		
		Assert.assertArrayEquals(OCRParser.OCR_EIGHT, splitted[2]);
	}
	
	@Test
	public void splitIntoFourOCRUnits(){
		String[] ocr = OCR_FOUR_DIGITS;
		
		Splitter splitter = new OCRSplitter();
		String[][] splitted = splitter.split(ocr);
		
		Assert.assertArrayEquals(OCRParser.OCR_ONE, splitted[3]);
	}
	
	@Test
	public void splitIntoNineOCRUnits(){
		String[] ocr = OCR_FULL_DIGITS_579123460;
		
		Splitter splitter = new OCRSplitter();
		String[][] splitted = splitter.split(ocr);
		
		Assert.assertArrayEquals(OCRParser.OCR_ZERO, splitted[8]);
	}
	
	@Test
	public void validateOCRUnitLines(){
		String[] ocr = OCR_INVALID_LESS_LINES;
		try{
			Splitter splitter = new OCRSplitter();
			splitter.validateFormat(ocr);
			Assert.fail("the parser has to throw an exception if the OCR is invalid");
		}catch(Exception e){
		}
	}
	
	@Test
	public void validateOCRUnitLenght(){
		String[] ocr = OCR_INVALID_LENGHT;
		try{
			Splitter splitter = new OCRSplitter();
			splitter.validateFormat(ocr);
			Assert.fail("the parser has to throw an exception if the OCR is invalid");
		}catch(Exception e){
		}
	}
	
	@Test
	public void validateOCRFullDigits(){
		String[] ocr = OCR_FULL_DIGITS_579123460;
		try{
			Splitter splitter = new OCRSplitter();
			splitter.validateFormat(ocr);
		}catch(Exception e){
			Assert.fail("the parser has thrown an exception, but the OCR is valid");
		}
	}
	
	@Test
	public void validateOCRFullDigitsWithShorterLines(){
		String[] ocr = OCR_INVALID_FULL_DIGITS_WITH_SHORTER_LINES;
		try{
			Splitter splitter = new OCRSplitter();
			splitter.validateFormat(ocr);
			Assert.fail("the parser has to throw an exception if the OCR is invalid");
		}catch(Exception e){
		}
	}
	
	@Test
	public void validateOCRFullDigitsWithShorterLenght(){
		String[] ocr = OCR_INVALID_FULL_DIGITS_WITH_SHORTER_LENGHT;
		try{
			Splitter splitter = new OCRSplitter();
			splitter.validateFormat(ocr);
			Assert.fail("the parser has to throw an exception if the OCR is invalid");
		}catch(Exception e){
		}
	}
	
	@Test
	public void parseFullDigitsOcrIntoBankAccount_579123460(){
		String[] ocr = OCR_FULL_DIGITS_579123460;
		
		OCRParser parser = new OCRParser();
		String bankAccount = parser.parse(ocr);
		Assert.assertEquals("579123460", bankAccount);
	}
	
	@Test
	public void parseFullDigitsOcrIntoBankAccount_132435467(){
		String[] ocr = OCR_FULL_DIGITS_132435467;
		
		OCRParser parser = new OCRParser();
		String bankAccount = parser.parse(ocr);
		Assert.assertEquals("132435467", bankAccount);
	}
	
	@Test
	public void parseInvalidFullDigitsOcrWithShorterLenghtIntoBankAccount(){
		String[] ocr = OCR_INVALID_FULL_DIGITS_WITH_SHORTER_LENGHT;
		
		try{
			OCRParser parser = new OCRParser();
			parser.parse(ocr);
			
			Assert.fail("the parser has to throw an exception if the OCR is invalid");
		}catch(Exception e){
		}
	}
	
	@Test
	public void parseInvalidFullDigitsOcrWithShorterLinesIntoBankAccount(){
		String[] ocr = OCR_INVALID_FULL_DIGITS_WITH_SHORTER_LINES;
		
		try{
			OCRParser parser = new OCRParser();
			parser.parse(ocr);
			
			Assert.fail("the parser has to throw an exception if the OCR is invalid");
		}catch(Exception e){
		}
	}
}

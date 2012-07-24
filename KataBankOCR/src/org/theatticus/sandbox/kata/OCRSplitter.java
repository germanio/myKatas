package org.theatticus.sandbox.kata;

import java.security.InvalidParameterException;

public class OCRSplitter implements Splitter{

	public static final int OCR_UNIT_LENGHT = 3;
	public static final int OCR_LINES = 4;
	
	public String[][] split(String[] ocr) {
		validateFormat(ocr);
		
		int size = ocr[0].length() / OCR_UNIT_LENGHT;
		String[][] splitted = new String[size][OCR_LINES];
		
		int startsAt = 0;
		int endsAt = OCR_UNIT_LENGHT;
		
		for (int unit = 0; unit < size; unit++) {
			String[] newUnit = new String[OCR_LINES];
			
			for (int line = 0; line < OCR_LINES; line++) {
				String part = ocr[line].substring(startsAt, endsAt);
				newUnit[line] = part;
			}

			startsAt = endsAt;
			endsAt += OCR_UNIT_LENGHT;
			
			splitted[unit] = newUnit;
		}
		
		return splitted;
	}
	
	public void validateFormat (String[] ocr) {
		
		if (ocr.length != OCR_LINES)
			throw new InvalidParameterException("the OCR code is invalid");
		
		for (int index = 0; index < OCR_LINES; index++) {
			int invalidCharCount = ocr[index].length() % OCR_UNIT_LENGHT;
			
			if (invalidCharCount > 0)
				throw new InvalidParameterException("the OCR code is invalid");
		}
		
	}
}

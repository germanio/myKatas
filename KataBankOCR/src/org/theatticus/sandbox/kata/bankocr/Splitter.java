package org.theatticus.sandbox.kata.bankocr;

public interface Splitter {

	String[][] split(String[] ocr);
	void validateFormat(String[] ocr);
}

package org.theatticus.sandbox.kata;

public interface Splitter {

	String[][] split(String[] ocr);
	void validateFormat(String[] ocr);
}

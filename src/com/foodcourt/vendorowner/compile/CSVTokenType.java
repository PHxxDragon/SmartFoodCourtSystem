package com.foodcourt.vendorowner.compile;

public enum CSVTokenType {
	ESCAPE_CHAR,
	DELIMITER,
	ENDLINE;
	private String string;
	static {
		ESCAPE_CHAR.string = "\"";
		DELIMITER.string = ",";
		ENDLINE.string = "\n";
	}
	public String getString() {
		return this.string;
	}
}
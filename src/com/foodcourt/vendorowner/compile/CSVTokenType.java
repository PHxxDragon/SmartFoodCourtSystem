package com.foodcourt.vendorowner.model;

public enum CSVTokenType {
	PURE_TEXT_ON,
	PURE_TEXT_OFF,
	SEPERATOR,
	ENDLINE;
	private String string;
	static {
		PURE_TEXT_ON.string = "\"";
		PURE_TEXT_OFF.string = "\"";
		SEPERATOR.string = ",";
		ENDLINE.string = "\n";
	}
	public String getString() {
		return this.string;
	}
}
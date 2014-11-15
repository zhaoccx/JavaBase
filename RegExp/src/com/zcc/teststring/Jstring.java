package com.zcc.teststring;

import javax.print.DocFlavor.STRING;

public class Jstring extends STRING {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4736008825601003936L;

	public Jstring(String mimeType) {
		super(mimeType);
	}

	public static void main(String[] args) {
		System.out.println(new Jstring("text/html; charset=utf-16"));
	}
}

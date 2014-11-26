package com.hw.zc;

public class Point {

	private int x;
	public int y;
	private String string1 = "ball";
	private String string2 = "baskdtball";
	private String string3 = "ced";

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", string1=" + string1 + ", string2=" + string2 + ", string3=" + string3 + "]";
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getString1() {
		return string1;
	}

	public void setString1(String string1) {
		this.string1 = string1;
	}

	public String getString2() {
		return string2;
	}

	public void setString2(String string2) {
		this.string2 = string2;
	}

	public String getString3() {
		return string3;
	}

	public void setString3(String string3) {
		this.string3 = string3;
	}

	public Point(int x, int y, String string1, String string2, String string3) {
		super();
		this.x = x;
		this.y = y;
		this.string1 = string1;
		this.string2 = string2;
		this.string3 = string3;
	}

	public Point() {
		super();
	}

}

package com.zcc.visitor;

public class StringElement implements IVisitable {

	private String se;

	public StringElement(String se) {
		this.se = se;
	}

	public String getSe() {
		return this.se;
	}

	@Override
	public void accept(IVisitor visitor) {
		visitor.visitString(this);
	}

}

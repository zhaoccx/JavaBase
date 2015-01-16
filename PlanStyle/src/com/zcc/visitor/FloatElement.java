/**
 * 
 */
package com.zcc.visitor;

/**
 * @author zhaocc
 *
 */
public class FloatElement implements IVisitable {

	private Float fe;

	public FloatElement(Float fe) {
		this.fe = fe;
	}

	public Float getFe() {
		return this.fe;
	}

	public void accept(IVisitor visitor) {
		visitor.visitFloat(this);
	}

}

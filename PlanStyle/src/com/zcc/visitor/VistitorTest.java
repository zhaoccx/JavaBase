package com.zcc.visitor;

import java.util.ArrayList;
import java.util.List;

public class VistitorTest {

	public static void main(String[] args) {
		IVisitor visitor = new ConcreteVisitor();
		StringElement se = new StringElement("abc");
		se.accept(visitor);

		FloatElement fe = new FloatElement(new Float(1.5));
		fe.accept(visitor);
		System.out.println("===========");
		List<Object> result = new ArrayList<Object>();
		result.add(new StringElement("abc"));
		result.add(new StringElement("abc"));
		result.add(new StringElement("abc"));
		result.add(new FloatElement(new Float(1.5)));
		result.add(new FloatElement(new Float(1.5)));
		result.add(new FloatElement(new Float(1.5)));
		visitor.visitCollection(result);
	}

}

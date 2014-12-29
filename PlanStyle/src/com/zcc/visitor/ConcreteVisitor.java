package com.zcc.visitor;

import java.util.Collection;
import java.util.Iterator;

public class ConcreteVisitor implements IVisitor {

	@Override
	public void visitString(StringElement stringE) {
		System.out.println(stringE.getSe());

	}

	@Override
	public void visitFloat(FloatElement floatE) {
		System.out.println(floatE.getFe());

	}

	@Override
	public void visitCollection(Collection<Object> collection) {
		// TODO Auto-generated method stub
		Iterator<Object> iterator = collection.iterator();
		while (iterator.hasNext()) {
			Object o = iterator.next();
			if (o instanceof IVisitable) {
				((IVisitable) o).accept(this);
			}
		}

	}

}

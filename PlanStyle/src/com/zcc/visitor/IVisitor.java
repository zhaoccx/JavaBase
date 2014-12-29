/**
 * 
 */
package com.zcc.visitor;

import java.util.Collection;

/**
 * @author zhaocc
 *
 */
public interface IVisitor {

	public void visitString(StringElement stringE);

	public void visitFloat(FloatElement floatE);

	public void visitCollection(Collection<Object> collection);
}

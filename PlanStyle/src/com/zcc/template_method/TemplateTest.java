package com.zcc.template_method;

public class TemplateTest {

	public static void main(String[] args) {
		Template temp = new TemplateConcrete();
		temp.update();
	}

}

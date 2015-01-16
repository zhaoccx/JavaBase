package com.hw.zc.day2;

@MyAnnotation
public class AnnotationTestMy {
	public static void main(String[] args) {
		if (AnnotationTestMy.class.isAnnotationPresent(MyAnnotation.class)) {
			MyAnnotation myAnnotation = AnnotationTestMy.class.getAnnotation(MyAnnotation.class);
			System.out.println(myAnnotation);
		}
	}
}

package com.hw.zc;

import static java.lang.Math.abs;
import static java.lang.Math.max;

import com.hw.zc.AutoBoxTest.Sex;
import com.hw.zc.AutoBoxTest.WeekDay;

/**
 * 静态导入
 * 
 * @author zhaocc
 *
 */
public class StaticImportTest { 
	public static void main(String[] args) {
		System.out.println(max(3, 6));
		System.out.println(abs(3 - 6));
		WeekDay day = WeekDay.MON;
		System.out.println(day.ordinal());

		Sex sex = Sex.ONE;

		System.out.println(sex.getNextSex());

		// Sex sex2 = Sex.THREE;
	}
}

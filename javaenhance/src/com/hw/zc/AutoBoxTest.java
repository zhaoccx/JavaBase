package com.hw.zc;

public class AutoBoxTest {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Integer intdataInteger = 3;
		System.out.println(intdataInteger + 12);

		String string1 = new String("abc");
		String string2 = new String("abc");

		/**
		 * 享元模式 flyweight 很多很小的东西，常常用到，就把搞成同一个对象，相同的做为内部对象，不同的做外部对象
		 */

		Integer i1 = 13;
		Integer i2 = 13;
		System.out.println(i1 == i2); // true

		Integer i3 = 128;
		Integer i4 = 128;
		System.out.println(i3 == i4); // false 128

		Integer i5 = Integer.valueOf(3);
		Integer i6 = Integer.valueOf(3);
		System.out.println(i5 == i6); // true

		Integer i7 = Integer.valueOf(128);
		Integer i8 = Integer.valueOf(128);
		System.out.println(i7 == i8); // false
	}

	public enum WeekDay {
		SUN, MON, THU, WED, TUR, FRI, STR;
	}

	public enum Sex {
		ONE {
			@Override
			public Sex getNextSex() {

				return TWO;
			}
		},
		TWO(40) {
			@Override
			public Sex getNextSex() {
				// TODO Auto-generated method stub
				return THREE;
			}
		},
		THREE(5) {
			@Override
			public Sex getNextSex() {
				// TODO Auto-generated method stub
				return ONE;
			}
		};

		public abstract Sex getNextSex();

		public int time;

		private Sex() {

		}

		private Sex(int time) {
			this.time = time;
		}
	}
}

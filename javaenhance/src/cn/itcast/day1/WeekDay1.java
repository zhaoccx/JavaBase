package cn.itcast.day1;

public abstract class WeekDay1 {
	private WeekDay1() {
	}

	public final static WeekDay1 SUN = new WeekDay1() {

		@Override
		public WeekDay1 nextDay() {
			return MON;
		}

	};
	public final static WeekDay1 MON = new WeekDay1() {

		@Override
		public WeekDay1 nextDay() {
			return SUN;
		}

	};

	public abstract WeekDay1 nextDay();

	/*
	 * public WeekDay nextDay(){ if(this == SUN){ return MON; }else{ return SUN;
	 * } }
	 */

	@Override
	public String toString() {
		return this == SUN ? "SUN" : "MON";
	}
}

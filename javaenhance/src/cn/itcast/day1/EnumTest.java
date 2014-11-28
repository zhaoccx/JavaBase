package cn.itcast.day1;

public class EnumTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WeekDay1 weekDay = WeekDay1.MON;
		System.out.println(weekDay.nextDay());

		WeekDay weekDay2 = WeekDay.FRI;
		System.out.println(weekDay2);
		System.out.println(weekDay2.name());
		System.out.println(weekDay2.ordinal());
		System.out.println(WeekDay.valueOf("SUN").toString());
		System.out.println(WeekDay.values().length);

		// new Date(300){};
	}

	public enum WeekDay {

		SUN(1), MON(), TUE, WED, THI, FRI, SAT;
		private WeekDay() {
			System.out.println("first");
		}

		private WeekDay(int day) {
			System.out.println("second");
		}
	}

	public enum TrafficLamp {
		RED(30) {
			@Override
			public TrafficLamp nextLamp() {
				return GREEN;
			}
		},
		GREEN(45) {
			@Override
			public TrafficLamp nextLamp() {
				return YELLOW;
			}
		},
		YELLOW(5) {
			@Override
			public TrafficLamp nextLamp() {
				return RED;
			}
		};
		public abstract TrafficLamp nextLamp();

		private int time;

		private TrafficLamp(int time) {
			this.setTime(time);
		}

		public int getTime() {
			return time;
		}

		public void setTime(int time) {
			this.time = time;
		}
	}
}

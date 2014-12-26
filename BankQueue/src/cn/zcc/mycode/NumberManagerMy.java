package cn.zcc.mycode;

import java.util.ArrayList;
import java.util.List;

public class NumberManagerMy {

	private int lastNumber = 1;
	private List<Integer> queueNumber = new ArrayList<Integer>();

	public synchronized Integer geterateNewManager() {
		queueNumber.add(lastNumber);
		return lastNumber++;
	}

	public synchronized Integer fetchServiceNumber() {
		Integer number = null;
		if (queueNumber.size() != 0) {
			number = queueNumber.remove(0);
		}
		return number;
	}

}

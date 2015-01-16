package cn.zcc.bankqueue;

import java.util.ArrayList;
import java.util.List;

public class NumberManager {
	private int lastNumber = 0;
	@SuppressWarnings("rawtypes")
	private List queueNumbers = new ArrayList();

	@SuppressWarnings("unchecked")
	public synchronized Integer generateNewNumber() {
		queueNumbers.add(++lastNumber);
		return lastNumber;
	}

	public synchronized Integer fetchNumber() {
		if (queueNumbers.size() > 0) {
			return (Integer) queueNumbers.remove(0);
		} else {
			return null;
		}
	}
}

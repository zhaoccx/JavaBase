package cn.zcc.bankqueue;

public enum CustomerType {
	COMMON, EXPRESS, VIP;
	@Override
	public String toString() {
		String name = null;
		switch (this) {
		case COMMON:
			name = "普通";
			break;
		case EXPRESS:
			name = "快速";
			break;
		case VIP:
			name = name();
			break;
		}
		return name;
	}
}

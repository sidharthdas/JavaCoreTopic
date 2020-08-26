package enumexample;

public enum Channel {
	PICKUP_POINT("21"), HOME("22"), WALKIN("1");
	Channel(String msg) {
		this.msg = msg;
	}

	private String msg;

	public String getMsg() {
		return msg;
	}
}

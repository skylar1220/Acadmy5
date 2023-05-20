package dao;

public class SingleTone {
	private static SingleTone instance = null;
	private int id;

	private SingleTone() {}  // 객체생성 금지
	
	public static SingleTone getInstance() {
		if (instance == null)
			instance = new SingleTone();
		return instance;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}

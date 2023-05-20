package dao;

public class SingleToneDemo {

	public static void main(String[] args) {
		SingleTone s1 = SingleTone.getInstance();
		s1.setId(100);
		System.out.println("s1 id = "+ s1.getId());
		
		SingleTone s2 = SingleTone.getInstance();
		s2.setId(300);
		System.out.printf("s1 id = %d  s2 id = %d\n",s1.getId(), s2.getId());
	}

}

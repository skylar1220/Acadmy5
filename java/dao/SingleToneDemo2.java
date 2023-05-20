package dao;

public class SingleToneDemo2 {

	public static void main(String[] args) {
		SingleTone s3 = SingleTone.getInstance();		
		System.out.println("s3 id = "+ s3.getId());

	}

}

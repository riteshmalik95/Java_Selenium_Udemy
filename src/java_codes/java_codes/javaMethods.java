package java_codes;

public class javaMethods {
	public String getData() {
		System.out.println("Hello Java");
		return "Robust Language";
	}
	public static void setData() {
		System.out.println("By Java");
		
		
	}

	public static void main(String[] args) {
		javaMethods j=new javaMethods();
		System.out.println(j.getData());
		setData();
		
	}

}

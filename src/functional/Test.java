package functional;

public class Test {
	
	/*static {
		System.out.println("Static");
	}*/
	public Test() {
		System.out.println("ctt");
	}
	{
		System.out.println("Non static");
	}
	private static void init() {
		System.out.println("Init");
	}
	
	public static void main(String[] args) {
		new Test();
		
	}
}

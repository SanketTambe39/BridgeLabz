package designPatterns;

public class SingletonLink 
{

	public static void main(String[] args) 
	{
		
		

	}

}

class EagerInitialization
{
	
	private static EagerInitialization newInstance=new EagerInitialization();

	private EagerInitialization()
	{
		System.out.println("Eager Initialization:  New Instance Created");
	}
	public static EagerInitialization getInsatnce()
	{
		return newInstance;
	}
}

class StaticBlockSingleton
{
	
	private static StaticBlockSingleton newInstance;

	static
	{
		try {
		newInstance=new StaticBlockSingleton();
		}
		catch(Exception e)
		{
			System.out.println("\n Exception occured when creating Static Block Singleton instance");
		}
	}
	private StaticBlockSingleton()
	{
		System.out.println("Static Block Singleton:  New Instance Created");
	}
	public static StaticBlockSingleton getInsatnce()
	{
		return newInstance;
	}
}

class LazyInitialization
{
	
	private static LazyInitialization newInstance=null;
	
	private LazyInitialization() 
	{
		System.out.println("\n Lazy Initialization Singleton : New Instance created");
	}
	public static LazyInitialization getInstance()
	{
		if(newInstance==null)
		{
			newInstance= new LazyInitialization();
			return newInstance;
		}
		else
		{
			System.out.println("\n We can't create another object");
			return null;
		}
	}
	
}
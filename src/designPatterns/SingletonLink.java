package designPatterns;

import java.io.ObjectOutput;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author admin1
 *
 *Class SingletonLink is used to call the various singleton implementation
 *
 *It takes user choice to select the method which calls the singleton classes
 */
public class SingletonLink 
{
	
	//EggerInitialization singleton test function	
	public void eggerInitializationDemo()
	{
		EagerInitialization newObject=EagerInitialization.getInstance();
		EagerInitialization newObject2=EagerInitialization.getInstance();

		System.out.println(newObject);
		System.out.println(newObject2);
	}
	
	//StaticBlock Singleton Test function	
	public void staticBlockSingleton()
	{
		StaticBlockSingleton newObject= StaticBlockSingleton.getInsatnce();
		StaticBlockSingleton newObject2= StaticBlockSingleton.getInsatnce();
		
		System.out.println(newObject);
		System.out.println(newObject2);
	}
	
	//Lazy Initialization Singleton test function	
	public void lazyInitialization()
	{
		LazyInitialization newObject= LazyInitialization.getInstance();
		LazyInitialization newObject2= LazyInitialization.getInstance();
		
		System.out.println(newObject);
		System.out.println(newObject2);
	}
	
	//Thread Safe Singleton test function	
	public void threadSafeSingleton()
	{
		ThreadSafeSingleton newObject= ThreadSafeSingleton.getInstance();
		ThreadSafeSingleton newObject2= ThreadSafeSingleton.getInstance();
		
		System.out.println(newObject);
		System.out.println(newObject2);
	}
	
	//EnumSingleton test function	
	public void enumSingleton()
	{
		System.out.println(EnumSingleton.instance);
	}
	
	//Destroying the singleton concept using reflection
	public void reflectionToDestroySingleton()
	{
		new ReflectionToDestroySingleton();
	}
	
	//Bill Pugh Singleton test function	
	public void billPughSingleton()
	{
		BillPughSingleton newObject1= BillPughSingleton.getInstance();
		BillPughSingleton newObject2= BillPughSingleton.getInstance();
		
		System.out.println(newObject1);
		System.out.println(newObject2);
	}
	
	
	//Serialized singleton test function	
	public void serializableSingleton() throws FileNotFoundException, IOException, ClassNotFoundException
	{
	
		SerializableSingleton newObject1= SerializableSingleton.getInstance();
		
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
        out.writeObject(newObject1);
        out.close();
        
        ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
        
        SerializableSingleton newObject2 = (SerializableSingleton) in.readObject();
        
        in.close();
        
        System.out.println("instanceOne hashCode="+newObject1.hashCode());
        System.out.println("instanceTwo hashCode="+newObject2.hashCode());
		
	}
	
	public static void main(String[] args) 
	{
	
		SingletonLink newObject= new SingletonLink();
		
		newObject.eggerInitializationDemo();
	}
	
}

// EagerInitialization Singleton class
class EagerInitialization
{
	
//	Initialize new instance of the class	
	private static final EagerInitialization newInstance=new EagerInitialization();

//	private constructor of class
	private EagerInitialization()
	{
//		Displayed when new instance is created
		System.out.println("Eager Initialization:  New Instance Created");
	}
	
//	method that returns private object of current class
	public static EagerInitialization getInstance()
	{	
		return newInstance;
	}
}


//Static Block Singleton class implementation
class StaticBlockSingleton
{
//	creates reference of the current class 
	private static StaticBlockSingleton newInstance;

//	static block to initialize object
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
	
//	Constructor of the class
	private StaticBlockSingleton()
	{
		System.out.println("Static Block Singleton:  New Instance Created");
	}
	
	
//  returns current class private object
	public static StaticBlockSingleton getInsatnce()
	{
		return newInstance;
	}
}


//Lazy Initialization Singleton implementation 
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
			
		}
		return newInstance;
	}
	
}

//Thread Safe Singleton implementation
class ThreadSafeSingleton
{
	
	private static ThreadSafeSingleton instance=null;
	
	private ThreadSafeSingleton() 
	{
		System.out.println("\n Thread Safe Singleton : New Instance created");	
	}
	
	public static synchronized ThreadSafeSingleton getInstance()
	{
		if(instance==null)
		{
			instance= new ThreadSafeSingleton();
		}
		return instance;
	}

}

//Bill Pugh Singleton implementation
class BillPughSingleton
{
	
	private BillPughSingleton() 
	{
		System.out.println("\n Bill Pugh Singleton : New Instance created");
	}
	
//	Singleton helper class for initialize object
	private static class SingletonHelper
	{
		private static final BillPughSingleton newInstance= new BillPughSingleton();
	}
	
	public static BillPughSingleton getInstance()
	{
		return SingletonHelper.newInstance;
	}		
	
}


// Reflection To Destroy Singleton class to destroy singleton pattern 
class ReflectionToDestroySingleton
{
	{
	try 
	{
//		Singleton object initialization
		EagerInitialization newObject1= EagerInitialization.getInstance();
		EagerInitialization newObject2=null;
		
//		Getting the constructors of the singleton class in an constructor array 
		Constructor<?> constructors[]= EagerInitialization.class.getDeclaredConstructors();
	
		for(Constructor<?> constructor: constructors)
		{
//			setting all constructor of the singleton class as accessible
			constructor.setAccessible(true);
			
//			intializing new object
			newObject2 = (EagerInitialization) constructor.newInstance();
		}
		
		System.out.println("EggerInitialized Singleton Object1 hashcode: "+newObject1.hashCode());
		System.out.println("EggerInitialized Singleton Object2 hashcode: "+newObject2.hashCode());
	}
	catch(Exception e)
	{
		System.out.println("Can't Initialize Object");
	}
	
	}
}

//Enum singleton implementation
enum EnumSingleton
{
	
//	Instance of the enum is created here
	instance;
	
	private EnumSingleton()
	{
		System.out.println("Enum Singleton Object : new instance ");
	}
	
}

// Serializable singleton implementation
class SerializableSingleton implements Serializable
{
	
//	setting default serialVersionUID
	private static final long serialVersionUID = 1L;

//	Serializable singleton constructor
	private SerializableSingleton() 
	{
		System.out.println("\n Serializable Singleton : New Instance created");
	}
	
//	Singleton helper class for initialize the object
	private static class SingletonHelper
	{
		private static final SerializableSingleton newInstance=new SerializableSingleton();
	}
	
	
	public static SerializableSingleton getInstance()
	{
		return SingletonHelper.newInstance;
	}		
	
//	read resolve method for deserializing object from file
	protected Object readResolve() {
	    return getInstance();
	}
	
}


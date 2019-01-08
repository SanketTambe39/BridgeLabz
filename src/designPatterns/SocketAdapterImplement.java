package designPatterns;

public class SocketAdapterImplement
{

	public void classAdapter()
	{
		
			SocketAdapter socket= new SocketAdapterClassImplement();
			
			Volt v120= getVolt(socket, 120);
			
			Volt v12= getVolt(socket, 12);
			
			Volt v3= getVolt(socket, 3);
			System.out.println("\n Using Class Adapter Pattern : \n");
			System.out.println(" v3 volts using Object Adapter="+v3.getVolts());
			System.out.println(" v12 volts using Object Adapter="+v12.getVolts());
			System.out.println(" v120 volts using Object Adapter="+v120.getVolts());
		
	}
	public void objectAdapter()
	{
		
			SocketAdapter socket= new SocketAdapterObjectImplement();
			
			Volt v120= getVolt(socket, 120);
			
			Volt v12= getVolt(socket, 12);
			
			Volt v3= getVolt(socket, 3);
		
			System.out.println("\n Using Object Adapter Pattern : \n");
			System.out.println(" v3 volts using Object Adapter="+v3.getVolts());
			System.out.println(" v12 volts using Object Adapter="+v12.getVolts());
			System.out.println(" v120 volts using Object Adapter="+v120.getVolts());
		
	}
	private static Volt getVolt(SocketAdapter sockAdapter, int i) 
	{
		switch (i)
		{
		case 3: return sockAdapter.get3Volts();
		
		case 12: return sockAdapter.get12Volts();
		
		case 120: return sockAdapter.get120Volts();
		
		default: return sockAdapter.get120Volts();
		}
	}
	
	public static void main(String[] args) 
	{
	
		SocketAdapterImplement newObject= new SocketAdapterImplement();
		newObject.classAdapter();
		newObject.objectAdapter();
	}

}
class SocketAdapterClassImplement extends Socket implements SocketAdapter
{

	@Override
	public Volt get3Volts() {
		Volt v=getVolt();
		return converVolt(v, 40);
	}

	@Override
	public Volt get12Volts() {
		Volt v=getVolt();
		return converVolt(v, 10);
	}

	@Override
	public Volt get120Volts() {
		return getVolt();
	}
	
	public Volt converVolt(Volt v, int i)
	{
		return new Volt(v.getVolts()/i);
	}

}
class SocketAdapterObjectImplement implements SocketAdapter
{

	private Socket socket= new Socket();
	@Override
	public Volt get3Volts() {
		Volt v= socket.getVolt();
		return converVolt(v, 40);
	}

	@Override
	public Volt get12Volts() {

		Volt v= socket.getVolt();
		return converVolt(v, 10);
	}

	@Override
	public Volt get120Volts() {
		
		return socket.getVolt();
	}
	
	public Volt converVolt(Volt v, int i)
	{
		return new Volt(v.getVolts()/i);
	}

}

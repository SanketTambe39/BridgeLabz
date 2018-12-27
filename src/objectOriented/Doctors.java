package objectOriented;

public class Doctors 
{

	private String name;
	private String id;
	private String specializedIn;
	private String 	availabelTime;
	
	public Doctors() {}
	public Doctors(String name, String id, String specializedIn, String availabelTime)
	{
		this.name= name;
		this.id=id;
		this.specializedIn=specializedIn;
		this.availabelTime= availabelTime;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setId(String id)
	{
		this.id=id;
	}
	public void setSpecializedIn(String specializedIn)
	{
		this.specializedIn=specializedIn;
	}
	public void setAvailabelTime(String availabelTime)
	{
		this.availabelTime=availabelTime;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getId()
	{
		return this.id;
	}
	
	public String getSpecializedIn()
	{
		return this.specializedIn;
	}
	public String getAvailabelTime()
	{
		return this.availabelTime;
	}
	
	public String toString()
	{
		return "Name : "+this.name+"  Id :"+this.id+" Specialization : "+
				this.specializedIn+" Availability : "+this.availabelTime;
	}
	
}

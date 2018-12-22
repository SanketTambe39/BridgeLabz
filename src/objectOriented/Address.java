package objectOriented;

public class Address 
{

	private String locality;
	private String city;
	private String state;
	private String zip;
	
	public Address() {}
	public Address(String locality, String city, String state, String zip)
	{
		this.locality=locality;
		this.city=city;
		this.state=state;
		this.zip=zip;
	}
	public void setLocality(String locality)
	{
		this.locality=locality;
	}
	
	public void setCity(String city)
	{
		this.city=city;
	}
	public void setState(String state)
	{
		this.state=state;
	}
	public void setZip(String zip)
	{
		this.zip=zip;
	}
	
	public String getLocality()
	{
		return this.locality;
	}
	public String getCity() 
	{
		return this.city;
	}
	public String getState()
	{
		return this.state;
	}
	public String getZip()
	{
		return this.zip;
	}
	
	public String toString()
	{
		return locality+", "+city+", "+state+", "+zip;
	}
	
}

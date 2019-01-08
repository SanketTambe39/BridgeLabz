package objectOriented;

import java.math.BigDecimal;

public class Developer 
{

	private String name;
	private BigDecimal payment;
	private int age;
	
	public Developer() {}
	
	public Developer(String name, BigDecimal payment, int age) 
	{
		this.name=name;
		this.payment=payment;
		this.age=age;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPayment() {
		return payment;
	}
	public void setPayment(BigDecimal payment) {
		this.payment = payment;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString()
	{
		return "name : "+name+" payment: "+payment+" age: "+age;
	}
	
	
}

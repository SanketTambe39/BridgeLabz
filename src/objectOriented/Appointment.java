package objectOriented;

import java.util.LinkedList;

public class Appointment
{

	private String doctorName;
	private String date;
	private LinkedList<Patients> patient;
	
	public Appointment() {}
	public Appointment(String name, String date, LinkedList<Patients> patient)
	{
		this.date=date;
		this.doctorName=name;
		this.patient=patient;
	}
	
	public void setDoctorName(String name)
	{
		this.doctorName= name;
	}
	
	public void setDate(String date)
	{
		this.date=date;
	}
	public void setPatient(LinkedList<Patients> patient)
	{
		this.patient=patient;
	}
	public String getDoctorName()
	{
		return doctorName;
	}
	public String getDate()
	{
		return date;
	}
	public LinkedList<Patients> getPatient()
	{
		return patient;
	}
	
	public String toString()
	{
		return " Doctor Name: "+doctorName+"  Appontment Date : "+date+"  "
				+ "Patient Details : "+patient.toString();
	}
	
}

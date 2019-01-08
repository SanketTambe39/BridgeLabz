package objectOriented;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import utility.Utility;

public class CliniqueMangement 
{

	private ObjectMapper mapper;
	private Patients patients[];
	private Doctors doctors[];
	private List<Patients> patientList; 
	private List<Doctors> doctorList;
	private List<Patients> searchResultPatient;
	private List<Doctors> searchResultDoctor;
	private List<Appointment> appointments;
	private static Utility utility;
	
	public CliniqueMangement()
	{
		mapper = new ObjectMapper();
		patientList=new LinkedList<Patients>();
		doctorList=new LinkedList<Doctors>();
		searchResultDoctor=new LinkedList<Doctors>();
		searchResultPatient=new LinkedList<Patients>();
		appointments=new LinkedList<Appointment>();
		utility= new Utility();
	}
	
	
	public Patients addPatient() throws JsonParseException, JsonMappingException, IOException
	{
		
		patients=mapper.readValue(new File("Patients.json"), Patients[].class);
		
		patientList.clear();
		
		for(Patients patient: patients)
		{
			patientList.add(patient);
		}
		
		System.out.println("*****************Add Patient***************");
		
		System.out.print(" \n Name of Patient : ");
		String name=utility.getLine();
		
		System.out.print("\n Patient Id : ");
		String id= utility.getLine();
		
		System.out.print("\n Mobile Number : ");
		String mobileNumber=utility.getLine();
		
		System.out.print("\n Patient Age : ");
		int age= Integer.parseInt(utility.getLine());
		
		Patients patient= new Patients(name, id, mobileNumber, age);
		patientList.add(patient);
		try {
			mapper.writeValue(new File("Patients.json"), patientList);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		return patient;
	}
	
	public void addDoctor() throws JsonParseException, JsonMappingException, IOException
	{
	
		doctors=mapper.readValue(new File("Doctors.json"), Doctors[].class);
		
		doctorList.clear();
		
		for(Doctors doctor: doctors)
		{
			doctorList.add(doctor);
		}
		
		System.out.println("*****************Add Doctor***************");
		
		System.out.print("\n Name of Doctor : ");
		String name=utility.getLine();
		
		System.out.print("\n Doctor Id : ");
		String id= utility.getLine();
		
		System.out.print("\n Specialization : ");
		String specializedIn=utility.getLine();
		
		System.out.print("\n Available Time : ");
		String time=utility.getLine();
		
		Doctors doctor= new Doctors(name, id, specializedIn, time);
		doctorList.add(doctor);
		try {
			mapper.writeValue(new File("Doctors.json"), doctorList);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}
	
	
	public void searchByNameDoctor(String name)
	{
		searchResultDoctor.clear();
		try {
			doctors=mapper.readValue(new File("Doctors.json"), Doctors[].class);
		
			doctorList.clear();
			
			for(Doctors doctor: doctors)
			{
				doctorList.add(doctor);
			}
			for(Doctors doctor: doctorList)
			{
				
				if(doctor.getName().equals(name))
				{
					searchResultDoctor.add(doctor);
				}
			}
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	
	public void searchByIdDoctor(String id)
	{
		try {
			searchResultDoctor.clear();
			doctors=mapper.readValue(new File("Doctors.json"), Doctors[].class);
		
			doctorList.clear();
			
			for(Doctors doctor: doctors)
			{
				doctorList.add(doctor);
			}
			for(Doctors doctor: doctorList)
			{
				
				if(doctor.getId().equals(id))
				{
					searchResultDoctor.add(doctor);
				}
			}
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	
	public void searchBySpecialization(String specializedIn) throws JsonParseException, JsonMappingException, IOException
	{
		searchResultDoctor.clear();
		doctors=mapper.readValue(new File("Doctors.json"), Doctors[].class);
		
		doctorList.clear();
		
		for(Doctors doctor: doctors)
		{
			doctorList.add(doctor);
		}
		for(Doctors doctor: doctorList)
		{
			if(doctor.getSpecializedIn().equals(specializedIn))
			{
				searchResultDoctor.add(doctor);
			}
		}
		
	}
	
	
	
	public void searchByAvailability(String availabelTime) throws JsonParseException, JsonMappingException, IOException
	{
		searchResultDoctor.clear();
		doctors=mapper.readValue(new File("Doctors.json"), Doctors[].class);
		
		doctorList.clear();
		
		for(Doctors doctor: doctors)
		{
			doctorList.add(doctor);
		}
		for(Doctors doctor: doctorList)
		{
			
			if(doctor.getAvailabelTime().equals(availabelTime))
			{
				searchResultDoctor.add(doctor);
			}
		}
		
	}
	
	
	public void searchByNamePatient(String name) throws JsonParseException, JsonMappingException, IOException
	{
		searchResultPatient.clear();
		patients=mapper.readValue(new File("Patients.json"), Patients[].class);
		
		patientList.clear();
		
		for(Patients patient: patients)
		{
			patientList.add(patient);
		}
		for(Patients patient: patientList)
		{
			
			if(patient.getName().equals(name))
			{
				searchResultPatient.add(patient);
			}
		}
	}
	
	
	public void searchByIdPatient(String id) throws JsonParseException, JsonMappingException, IOException
	{
		searchResultPatient.clear();
		patients=mapper.readValue(new File("Patients.json"), Patients[].class);
		
		patientList.clear();
		
		for(Patients patient: patients)
		{
			patientList.add(patient);
		}
		
		for(Patients patient: patientList)
		{
			
			if(patient.getId().equals(id))
			{
				searchResultPatient.add(patient);
			}
		}
	}
	
	public void searchByMobileNumber(String mobileNumber) throws JsonParseException, JsonMappingException, IOException
	{
		searchResultPatient.clear();
		patients=mapper.readValue(new File("Patients.json"), Patients[].class);
		
		patientList.clear();
		
		for(Patients patient: patients)
		{
			patientList.add(patient);
		}
		
		for(Patients patient: patientList)
		{
			
			if(patient.getMobileNumber().equals(mobileNumber))
			{
				searchResultPatient.add(patient);
			}
		}

	}
	
	public Patients getPatientToBeAppoint() throws JsonParseException, JsonMappingException, IOException 
	{
		System.out.println("\n Is patient already taking treatment from doctor(Y/N) :");
		char ch= utility.getLine().charAt(0);
		
		if(ch=='y'||ch=='Y')
		{
			System.out.println("\n Enter name of patient to search in the list");
			String patientName = utility.getLine();
			
			searchByNamePatient(patientName);
			
			if(searchResultPatient.size()==0 )
			{
				System.out.println("\n There is no records found for the patient");
				return null;
			}
			else if(searchResultPatient.size()>1)
			{
				System.out.println("\n There are two or more records founded \n Plzzz enter id of patient : ");
				
				String id=utility.getString();
				
				searchByIdPatient(id);
				
				if(searchResultPatient.size()!=0)
				{
					return ((LinkedList<Patients>) searchResultPatient).getFirst();
				}
			}
			else
			{
				return ((LinkedList<Patients>) searchResultPatient).getFirst();
			}
		}
		else if(ch=='n'|| ch=='N')
		{
			Patients patient=addPatient();
			
			return patient;
			
		}
		return null;
		
	}

	@SuppressWarnings("deprecation")
	public void getAppointment(String doctorName) throws JsonGenerationException, JsonMappingException, IOException
	{
		appointments.clear();
		
		Appointment appointmentList[]= mapper.readValue(new File("Appointment.json"), Appointment[].class);
		boolean flag=false;
		Date date=new Date();
		
		for(Appointment appoint:appointmentList)
		{
			if(appoint.getDoctorName().equals(doctorName))
			{
				if(appoint.getPatient().size()<5)
				{
					Patients patient=getPatientToBeAppoint();
					if(patient != null && appoint.getPatient().getFirst().getId().equals(patient.getId())==false)
					{
						appoint.getPatient().add(patient);
						flag=true;
					}
					else
					{
						System.out.println("\n Patient is already appointed");
						return;
					}
				}
				else 
				{
					date.setDate(date.getDate()+1);
				}
					
			}
			appointments.add(appoint);
		}
		
		if(flag==false)
		{
			
			
			String dateString= date.getDate()+"/"+(date.getMonth()+1)+"/"+(date.getYear()+1900);
			
			LinkedList<Patients> patientList= new LinkedList<Patients>();
			
			patientList.add(getPatientToBeAppoint());
			
			Appointment newAppointment=new Appointment(doctorName, dateString, patientList);
			
			appointments.add(newAppointment);
		}
		mapper.writeValue(new File("Appointment.json"), appointments);
		
	
	}
	
	public void appointment()
	{
		
		System.out.println("\n Which doctors appointment u did have ? : ");
		String doctorName= utility.getLine();
		
		try 
		{
			searchByNameDoctor(doctorName);
			if(searchResultDoctor.size()==1)
			{
				getAppointment(doctorName);
			}	
			else if(searchResultDoctor.size()>1)
			{
				System.out.println("\n Enter Doctor Id to search :");
				String id=utility.getLine();
				
				searchByIdDoctor(id);
				
				if(searchResultDoctor.size()!=0)
				{
					getAppointment(doctorName);
				}
				else
				{
					System.out.println("\n No such doctor is found ");
				}
			}
			else 
			{
				System.out.println("\n The doctor u specified is not in the list");
			}
		
		} 
		catch (IOException e) 
		{

			e.printStackTrace();
		
		}
		
	}
	public void displayDoctorSearchResult()
	{
		for(Doctors doctor: searchResultDoctor)
		{
			System.out.println(doctor.toString());
		}
	}
	
	public void displayPatientSearchResult()
	{
		for(Patients patient: searchResultPatient)
		{
			System.out.println(patient.toString());
		}
	}
	
	public void displayAppointments() throws JsonParseException, JsonMappingException, IOException
	{
		Appointment appointmentList[]= mapper.readValue(new File("Appointment.json"), Appointment[].class);
		System.out.println("\n ***************Appointment Details**************");
		for(Appointment appoint: appointmentList)
		{
			System.out.print("\n Doctor Name : "+appoint.getDoctorName());
			System.out.println("\n Date : "+appoint.getDate());
			for(Patients patient: appoint.getPatient())
			{
				System.out.println(patient.toString());
			}
		}
		
	}
	
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
		CliniqueMangement clinique=new CliniqueMangement();
		
		while(true)
		{
			System.out.println("\n ************Clinique Management***************");
			System.out.print ("\n \t 1. Add Doctor "
							 + "\n \t 2. Add Patient "
							 + "\n \t 3. Get Appointment "
							 + "\n \t 4. Display Appointment "
			    			 + "\n \t 5. Search Doctor "
			    			 + "\n \t 6. Search patient "
			    			 + "\n \t 7. Exit "
			    			 + "\n Choose your option............. : ");
		
			int ch= Integer.parseInt(utility.getLine());
			
			switch(ch)
			{
			case 1: clinique.addDoctor();
					break;
					
			case 2: clinique.addPatient();
					break;
					
			case 3: clinique.appointment();
					break;
					
			case 4: clinique.displayAppointments();
					break;
					
			case 5: System.out.println("\n 1. Search by Name "
									 + "\n 2. Search By id "
									 + "\n 3. Search by specialization "
									 + "\n 4. Search By Availability"
									 + "\n Choose your option.............. : ");
					int search= Integer.parseInt(utility.getLine());
					
					switch(search)
					{
					case 1: System.out.println("\n Enter name of the doctor : ");
							String name= utility.getLine();
							clinique.searchByNameDoctor(name);
							clinique.displayDoctorSearchResult();
							break;
					
					case 2: System.out.println("\n Enter Id of the doctor : "); 
							String id= utility.getLine();
							clinique.searchByIdDoctor(id);
							clinique.displayDoctorSearchResult();
							break;
							
					case 3: System.out.println("\n Enter Specialization of the doctor : ");
							String specializedIn= utility.getLine();
							clinique.searchBySpecialization(specializedIn);;
							clinique.displayDoctorSearchResult();
							break;
							
					case 4: System.out.println("\n Enter what time should be doctor is available : ");
							String availableTime= utility.getLine();
							clinique.searchByAvailability(availableTime);;
							clinique.displayDoctorSearchResult();
							break;
					}
					break;
					
			case 6: System.out.println("\n 1. Search by Name "
					 + "\n 2. Search By id "
					 + "\n 3. Search by mobile number "
					 + "\n Choose your option.............. : ");
				
					int searchPatient= Integer.parseInt(utility.getLine());
					
					switch(searchPatient)
					{
					case 1: System.out.println("\n Enter name of the patient : ");
							String name= utility.getLine();
							clinique.searchByNamePatient(name);
							clinique.displayPatientSearchResult();
							break;
					
					case 2: System.out.println("\n Enter Id of the patient : "); 
							String id= utility.getLine();
							clinique.searchByIdPatient(id);
							clinique.displayPatientSearchResult();
							break;
							
					case 3: System.out.println("\n Enter Mobile Number of the patient : ");
							String mobileNumber= utility.getLine();
							clinique.searchBySpecialization(mobileNumber);;
							clinique.displayPatientSearchResult();
							break;
							
					}
					break;
					
			case 7: return;
				
			}
		}
		/*clinique.displayAppointments();*/
	}
	
	
}

package objectOriented;



/*class PatientList {

	private LinkedList<Patients> patientList;

	public void setPatientList(LinkedList<Patients> patientList) {
		this.patientList = patientList;
	}

	public LinkedList<Patients> getPatientList() {
		return patientList;
	}

}*/
public class Patients 
{
	
		private String name;
		private String id;
		private String mobileNumber;
		private int age;
		
		public Patients(){}
		public Patients(String name, String id, String mobileNumber, int age)
		{
			this.name= name;
			this.id=id;
			this.mobileNumber=mobileNumber;
			this.age= age;
		}
		public void setName(String name)
		{
			this.name=name;
		}
		public void setId(String id)
		{
			this.id=id;
		}
		public void setMobileNumber(String mobileNumber)
		{
			this.mobileNumber=mobileNumber;
		}
		public void setAge(int age)
		{
			this.age=age;
		}
		
		public String getName()
		{
			return this.name;
		}
		
		public String getId()
		{
			return this.id;
		}
		
		public String getMobileNumber()
		{
			return this.mobileNumber;
		}
		public int getAge()
		{
			return this.age;
		}
		
		public String toString()
		{
			return "{Name : "+this.name+"  Id :"+this.id+" Mobile Number : "+
					this.mobileNumber+" Age : "+this.age+"}";
		}
		
	

	
}

package assignment7;

public class Student {
	private String firstName; 
	private String lastName; 
	private int StudID; 
	private int credits;
	private int passingcredits; 
	private double TotalQualityPoints; 
	private double bearBucks; 
	
	//constructor method
	public Student(String frstName, String lstName, int ID) {
		firstName = frstName;
		lastName = lstName;
		StudID = ID; 
		credits = 0;
		passingcredits = 0; 
		TotalQualityPoints = 0.0; 
		bearBucks = 0; 
		
	}
	
	public String getFullName() { 
		return firstName + " " + lastName; 
	}
	
	public int getId() { //gets the id of the student
		return StudID;
	}
	
	//adds the credits of the class to the total credits the student is taking, adds credits to passingcredits if student has a high enough grade and then updates totalqualitypoints accordingly
	public void submitGrade(double grade, int creditOfClass) {
		credits = credits + creditOfClass; 
		TotalQualityPoints = TotalQualityPoints + grade*creditOfClass; 
		if (grade>=1.7) {
			passingcredits = passingcredits + creditOfClass; 
		}
	}
	
	public int getTotalAttemptedCredits() {
		return credits;
	}
	public int getTotalPassingCredits() {
		return passingcredits; 
	}
	
	//calculates grade point average
	public double calculateGradePointAverage() {
		if (credits==0) {
			return Double.NaN; 
		}
		return TotalQualityPoints/(double)credits; 
	}
	
	public String getClassStanding() {
		if (passingcredits<30) {
			return "First Year";
		}
		else if (passingcredits<60) {
			return "Sophomore"; 
		}
		else if (passingcredits<90) {
			return "Junior";
		}
		else {
			return "Senior"; 
		}
	}
	
	//checks to see if a given student is eligible for this frat
	public boolean isEligibleForPhiBetaKappa() {
		if ((credits>=98)&&(calculateGradePointAverage()>=3.6)) {
			return true; 
		}
		else if ((credits>=75)&&(calculateGradePointAverage()>=3.8)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	//heres a collection of methods to add, subtract, check or cash out bear bucks 
	public void depositBearBucks(double amount) {
		bearBucks = bearBucks + amount;
	}
	public void deductBearBucks(double amount) {
		bearBucks = bearBucks - amount;
	}
	public double getBearBucksBalance() {
		return bearBucks; 
	}
	public double cashOutBearBucks() {
		double temp = bearBucks;
		bearBucks = 0;
		return Math.max(temp-10, 0); 
	}
	
	public String getLastName() {
		return lastName; 
	}
	
	//constructor that creates a new legacy student
	public Student createLegacy(String frstName, Student otherParent, boolean isHyphenated, int id) {
		String childLastName = this.lastName; 
		if (isHyphenated==true) {
			childLastName = this.lastName+"-"+otherParent.getLastName(); 
		}
		Student childStudent = new Student(frstName,childLastName,id); 
		childStudent.depositBearBucks(this.cashOutBearBucks()+otherParent.cashOutBearBucks()); 
		return childStudent; 
	}
	
	//converts a student in to string of their name and then their ID
	public String toString() {
		return getFullName() + " " + getId(); 
	}
	
}

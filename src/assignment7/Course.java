package assignment7;

public class Course {
	String Name; 
	int Credits;
	int Capacity; 
	Student[] Rooster; 
	
	//constructor
	public Course(String NameOClass, int creditOfClass, int capacity) {
		Name = NameOClass; 
		Credits = creditOfClass;
		Capacity = capacity;
		Rooster = new Student[Capacity]; 
	}
	
	public String getName() {
		return Name; 
	}
	public int getCredits() {
		return Credits;
	}
	public int getCapacity() {
		return Capacity; 
	}
	
	//returns a student
	public boolean addStudent(Student s) {
		for (int i =0; i< Capacity;i++) {
			if(Rooster[i]==s) {
				return false;
			}
		}
		for (int i =0; i< Capacity;i++) {
			if(Rooster[i]==null) {
				Rooster[i] = s; 
				return true; 
			}
		}
		return false; 
	}
	
	public int getSeatsRemaining() {
		int seats = Capacity; 
		for (int i =0; i< Capacity;i++) {
			if(Rooster[i]!=null) {
				seats = seats - 1;
			}
		}
		return seats; 
	}
	
	public Student getStudentAt(int index) {
		return Rooster[index]; 
	}
	
	public String generateRoster() {
		String stringRooster =""; 
		for (Student student : Rooster) {
			if (student!=null) {
				stringRooster = stringRooster + student.getFullName() + " "; 
			}
		}
		return stringRooster; 
	}
	
	//returns the average gpa across a class
	public double calculateAverageGPA() {
		double totalGPA = 0.0;
		int numOfStudents = 0;
		for (Student student : Rooster) {
			if (student!=null) {
				double gpa = student.calculateGradePointAverage();
	            // Ensure GPA is a valid number before adding it
	            if (!Double.isNaN(gpa) && !Double.isInfinite(gpa)) {
	                totalGPA += gpa;
	                numOfStudents += 1;
	            } 
			}
		}
		if (Credits==0) {
			return Double.NaN; 
		}
		return totalGPA/numOfStudents; 
	}
	
	//converts a course object into a string of its name and its credits
	public String toString() {
		return "name: " + getName() + "; credits " + getCredits(); 
	}
	
	
}

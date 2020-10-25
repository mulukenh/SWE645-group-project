package swe645.gmu.edu;

import javax.persistence.*;

@Entity
public class Student {
	@Id
	@GeneratedValue
	int studentId;
	
	String firstName;
	String lastName;
	String address;
	
	public int getStudentId() {
		return studentId;
	}

}

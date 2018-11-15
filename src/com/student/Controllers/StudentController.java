package com.student.Controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.student.DAOs.CollegeMySQL;
import com.student.Models.Student;

@ManagedBean@RequestScoped

public class StudentController {
	
	private CollegeMySQL studentDAO = new CollegeMySQL("jdbc:mysql://localhost:3306/studentDB", "studentDAO", "student123");
	private ArrayList<Student> students;
	private ResultSet result;
	
	public ArrayList<Student> getStudents(){
		result = studentDAO.executeQuery("Select * from student");
		students = new ArrayList<>();
		
		try {
			while(result.next() != false) {
				students.add(new Student(result.getString("sid"), result.getString("cid"), result.getString("name"), result.getString("address")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return students;
	}
	
	public void addStudent(Student s) {
		studentDAO.executeUpdate("insert into student values('"+s.getSid()+"','"+s.getCid()+"','"+s.getName()+"','"+s.getAddress()+"')");
	}
}

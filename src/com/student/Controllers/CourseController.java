package com.student.Controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.student.DAOs.CollegeMySQL;
import com.student.Models.Course;

@ManagedBean@RequestScoped

public class CourseController {
	
	private ResultSet result;
	private CollegeMySQL courseDAO = new CollegeMySQL("jdbc:mysql://localhost:3306/studentDB", "studentDAO", "student123");
	private ArrayList<Course> courses;
	
	public CourseController() {
	}
	
	public ArrayList<Course> getCourses(){
		result = courseDAO.executeQuery("Select * from course");
		courses = new ArrayList<>();
		
		try {
			while(result.next() != false) {
				courses.add(new Course(result.getString("cID"), result.getString("cName"), result.getInt("duration")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return courses;
	}
	
	public void addCourse(Course c) {
		courseDAO.executeUpdate("insert into course values('"+c.getCid()+"','"+c.getCname()+"',"+c.getDuration()+")");
	}
}

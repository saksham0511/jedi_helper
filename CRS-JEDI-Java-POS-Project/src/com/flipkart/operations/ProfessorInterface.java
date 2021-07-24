package com.flipkart.operations;
import com.flipkart.bean.Student;
import com.flipkart.bean.Course;
import com.flipkart.exception.ProfessorAlreadyExistException;

import java.sql.SQLException;
import java.util.List;

public interface ProfessorInterface {

    public boolean teachCourse(int profId, int courseId);
    public List<Student> getEnrolledStudents(int courseId);
    public Course[] viewCourses();
    public boolean addGrades(int studId, int courseId, String grade);
}

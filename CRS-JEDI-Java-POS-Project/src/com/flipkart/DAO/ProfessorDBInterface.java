package com.flipkart.DAO;

import com.flipkart.bean.Student;
import com.flipkart.exception.ProfessorAlreadyExistException;

import java.sql.SQLException;
import java.util.List;

public interface ProfessorDBInterface {

    public boolean teachCourseDB(int profId, int courseId);
    public List<Student> getEnrolledStudentsDB(int courseId);
    public boolean addGradesDB(int studId, int courseId, String grade);

}

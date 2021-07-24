package com.flipkart.operations;

import com.flipkart.DAO.ProfessorDB;
import com.flipkart.DAO.ProfessorDBInterface;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.exception.ProfessorAlreadyExistException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorOperations implements  ProfessorInterface{
    @Override
    public boolean teachCourse(int profId, int courseId){
        ProfessorDBInterface profDb = new ProfessorDB();
        return profDb.teachCourseDB(profId, courseId);
    }

    @Override
    public List<Student> getEnrolledStudents(int courseId) {
        List<Student> studentList = new ArrayList<>();
        ProfessorDBInterface profDb = new ProfessorDB();
        studentList = profDb.getEnrolledStudentsDB(courseId);
        return studentList;
    }

    @Override
    public Course[] viewCourses() {
        return new Course[0];
    }

    @Override
    public boolean addGrades(int studId, int courseId, String grade) {
        ProfessorDBInterface profDb = new ProfessorDB();
        return profDb.addGradesDB(studId, courseId, grade);
    }
}

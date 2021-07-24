package com.flipkart.operations;
import com.flipkart.bean.User;

public interface CourseInterface {
    public boolean addStudent(int studId);
    public boolean removeStudent(int studId);
    public User[] getListOfStudents();
    public int addProfessor(int profId);
    public boolean isCourseAvailable(int courseId);
    public boolean addToCatalog();
    public boolean removeFromCatalog();
}

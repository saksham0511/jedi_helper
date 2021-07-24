package com.flipkart.DAO;

import com.flipkart.bean.User;

public interface CourseDBInterface {
    public boolean addStudentDB(int studId);
    public boolean removeStudentDB(int studId);
    public User[] getListOfStudentsDB();
    public int addProfessorDB(int profId);
    public boolean isCourseAvailableDB(int courseId);
    public boolean addToCatalogDB();
    public boolean removeFromCatalogDB();
}

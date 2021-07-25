package com.flipkart.operations;
import com.flipkart.bean.Course;

import java.util.List;


public interface StudentInterface {
    public List<Course> getRegisteredCourses(int studId);
    public boolean isFeefeespaidDB(int studentId);
}

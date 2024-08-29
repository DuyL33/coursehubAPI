package com.dlviet.Courses.Service;

import com.dlviet.Courses.Model.Course;
import com.dlviet.Courses.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    public List<Course> findAllCourses() {
        return repository.findAll();
    }

    public Optional<Course> singleCourse(String courseNumber) {
        return repository.findCourseByNumber(courseNumber);
    }
}

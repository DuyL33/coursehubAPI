package com.dlviet.Courses.Controller;

import com.dlviet.Courses.Service.CourseService;
import com.dlviet.Courses.Model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/CS/Courses")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CourseController {
    @Autowired
    private CourseService service;
    @GetMapping
    public ResponseEntity<List<Course>> getCourses() {
        List<Course> courses = service.findAllCourses();
        courses.sort(Comparator.comparingLong(Course::getCid)); // Sort by ID
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
    @GetMapping("/{number}")
    public ResponseEntity<Optional<Course>> getSingleCourse(@PathVariable String number){
        return new ResponseEntity<Optional<Course>>(service.singleCourse(number), HttpStatus.OK);
    }
}

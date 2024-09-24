package com.dlviet.Courses.Service;

import com.dlviet.Courses.Model.Course;
import com.dlviet.Courses.Model.Review;
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

        public double averageDifficulty(String courseNumber) {
        Optional<Course> optionalCourse = singleCourse(courseNumber);

        return optionalCourse.map(course -> course.getReview_ids().stream()
                        .mapToDouble(r -> {
                            try {
                                return Double.parseDouble(r.getDifficulty());
                            } catch (NumberFormatException e) {
                                return 0.0;
                            }
                        })
                        .average()
                        .orElse(0.0))
                .orElse(0.0);
    }
//    public double averageDifficulty(String courseNumber) {
//        Optional<Course> optionalCourse = repository.findCourseByNumber(courseNumber);
//        double average = 0.0;
//        int count = 0;
//        System.out.println(optionalCourse);
//        if (optionalCourse.isPresent()) {
//            Course c = optionalCourse.get();
//            for (Review r : c.getReview_ids()) {
//                Double difficulty = Double.parseDouble(r.getDifficulty());
//                average += difficulty;
//                count++;
//            }
//        }
//        if (count == 0) count++;
//        average = average / count;
//        return average;
//    }

}

package com.dlviet.Courses.Repository;
import com.dlviet.Courses.Model.Course;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends MongoRepository<Course, ObjectId>{
    Optional<Course> findCourseByNumber(String courseNumber);
}

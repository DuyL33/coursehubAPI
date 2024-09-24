package com.dlviet.Courses.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    private ObjectId id;
    private String grade;
    private String professor;
    private String semester;
    private String year;
    private String difficulty;
    private String courseWork;

    private String body;

    private LocalDateTime created;
    private LocalDateTime updated;

    public Review(String grade, String professor, String semester, String year, String difficulty, String courseWork, String body, LocalDateTime created, LocalDateTime updated) {

        this.grade = grade;
        this.professor = professor;
        this.semester = semester;
        this.year = year;
        this.difficulty = difficulty;
        this.courseWork = courseWork;
        this.body = body;
        this.created = created;
        this.updated = updated;

    }
}

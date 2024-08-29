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
    private String difficulty;
    private String body;
    private LocalDateTime created;
    private LocalDateTime updated;
    public Review(String grade, String difficulty, String body, LocalDateTime created, LocalDateTime updated) {
        this.grade = grade;
        this.difficulty = difficulty;
        this.body = body;
        this.created = created;
        this.updated = updated;
    }
}

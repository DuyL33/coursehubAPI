package com.dlviet.Courses.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    private String id;

    private ERole name;

    public ERole getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
package com.dlviet.Courses.Repository;

import com.dlviet.Courses.Model.User;
import com.dlviet.Courses.Model.Role;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.Objects;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);

}
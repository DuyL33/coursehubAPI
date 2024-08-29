package com.dlviet.Courses.Repository;


import com.dlviet.Courses.Model.Role;
import com.dlviet.Courses.Model.ERole;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, ObjectId> {
    Optional<Role> findByName(ERole name);
}

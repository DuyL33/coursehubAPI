package com.dlviet.Courses;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ReviewRepository extends MongoRepository<Review,ObjectId> {

    Optional<Review> findByCreated(LocalDateTime created);
    Optional<Review> deleteReviewByCreated(LocalDateTime created);
}

package com.dlviet.Courses.Service;
import com.dlviet.Courses.Model.Course;
import com.dlviet.Courses.Model.Review;
import com.dlviet.Courses.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;
    public Review createReview(String grade, String professor, String semester, String year, String difficulty, String courseWork, String reviewBody, String number) {
        Review review = repository.insert(new Review(grade,professor, semester, year, difficulty, courseWork, reviewBody, LocalDateTime.now(), LocalDateTime.now()));

        mongoTemplate.update(Course.class)
                .matching(Criteria.where("number").is(number))
                .apply(new Update().push("review_ids").value(review))
                .first();

        return review;
    }
    public List<Review> findAllReviews() {
        return repository.findAll();
    }
    public Optional<Review> singleReview(LocalDateTime created) {
        return repository.findByCreated(created);
    }

    public void deleteReview(LocalDateTime created) {
        // Delete the review from the repository
        repository.deleteReviewByCreated(created);
    }

}

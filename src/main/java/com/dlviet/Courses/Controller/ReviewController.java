package com.dlviet.Courses.Controller;
import com.dlviet.Courses.Model.Review;
import com.dlviet.Courses.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@RestController
@RequestMapping("/CS/Courses/Review")

public class ReviewController {

    @Autowired
    private ReviewService service;

    @PostMapping()
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {

        return new ResponseEntity<Review>(service.createReview(payload.get("grade"),payload.get("difficulty") ,payload.get("body"), payload.get("number")), HttpStatus.OK);
    }
    @GetMapping("/{created}")
    public ResponseEntity<Optional<Review>> getSingleReview(@PathVariable LocalDateTime created){
        return new ResponseEntity<Optional<Review>>(service.singleReview(created), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Review>> getReviews() {
        List<Review> reviews = service.findAllReviews();
         // Sort by ID
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }
    @DeleteMapping("/{created}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteReview(@PathVariable LocalDateTime created) {
        try {
            // Call your service to delete the review
            service.deleteReview(created);
            return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting review: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

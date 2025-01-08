package org.generation.italy.hairhub.controllers;

import org.generation.italy.hairhub.dto.ReviewDto;
import org.generation.italy.hairhub.model.entities.Review;
import org.generation.italy.hairhub.model.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200/", allowedHeaders = "*")
@RestController
@RequestMapping("/review")
public class ReviewController {
    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{id}/reviews")
    public ResponseEntity<List<ReviewDto>> getReviewsBySalonId(@PathVariable long id) {
        List<Review> reviews = reviewService.getReviewsBySalonId(id);
        return ResponseEntity.ok(ReviewDto.fromReviews(reviews));
    }
}

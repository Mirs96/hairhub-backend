package org.generation.italy.hairhub.model.services;

import org.generation.italy.hairhub.model.entities.Review;
import org.generation.italy.hairhub.model.repositories.ReviewRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceJpa implements ReviewService {
    ReviewRepositoryJpa reviewRepository;

    @Autowired
    public ReviewServiceJpa(ReviewRepositoryJpa reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getReviewsBySalonId(long salonId) {
        List<Review> reviews = reviewRepository.findReviewsBySalonId(salonId);
        return reviews;
    }
}

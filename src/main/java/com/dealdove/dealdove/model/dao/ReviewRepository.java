package com.dealdove.dealdove.model.dao;

import com.dealdove.dealdove.model.enitity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Review findByReviewID(Integer reviewID);


}

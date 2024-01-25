package com.dealdove.dealdove.interfaces;

import com.dealdove.dealdove.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Review findByReviewID(Integer reviewID);
    List<Review> findByProductID(Integer productID);


}

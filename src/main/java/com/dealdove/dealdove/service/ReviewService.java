package com.dealdove.dealdove.service;

import com.dealdove.dealdove.model.dao.ReviewRepository;
import com.dealdove.dealdove.model.enitity.Review;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class ReviewService {

    private ReviewRepository reviewRepository;
    public double calculateAverageRating(Integer productID) {
        // 取得該產品的所有評論
        List<Review> reviews = reviewRepository.findByProductID(productID);

        if (reviews.isEmpty()) {
            return 0.0;
        }

        // 計算平均值
        double sum = 0.0;
        for (Review review : reviews) {
            sum += review.getRating();
        }

        double averageRating = sum / reviews.size();

        // 使用 DecimalFormat 控制小數位數為兩位，並進行四捨五入
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formattedAverage = decimalFormat.format(averageRating);

        // 將格式化後的字串轉換為 double 並返回
        return Double.parseDouble(formattedAverage);
    }
}

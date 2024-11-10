package umc.spring.service.ReviewService;

import umc.spring.domain.Review;

import java.util.List;

public interface ReviewQueryService {

    List<Review> getReviewByMember(Long memberId);
//    List<Review> getReviewByStore(Long storeId);

    Review createReview(Long memberId, Long storeId, String body, Float score);
}

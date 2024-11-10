package umc.spring.repository.ReviewRepository;

import umc.spring.domain.Review;
import java.util.List;

public interface ReviewRepositoryCustom {
    List<Review> findReviewsByStoreId(Long storeId);
    List<Review> findReviewsByMemberId(Long memberId);
}

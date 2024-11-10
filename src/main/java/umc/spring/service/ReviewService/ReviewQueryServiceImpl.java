package umc.spring.service.ReviewService;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Member;
import umc.spring.domain.QMember;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.ReviewRepository.ReviewRepository;
import umc.spring.repository.ReviewRepository.ReviewRepositoryImpl;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.repository.StoreRepository.StoreRepositoryImpl;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final JPAQueryFactory jpaQueryFactory;
    private final ReviewRepositoryImpl reviewRepositoryImpl;
    private final StoreRepositoryImpl storeRepositoryImpl;


    @Override
    public Review createReview(Long memberId, Long storeId, String body, Float score) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(()-> new IllegalArgumentException("Invalid member ID"));
        Store store = storeRepository.findById(storeId)
                .orElseThrow(()-> new IllegalArgumentException("Invalid store ID"));
        Review review = Review.builder()
                .member(member)
                .store(store)
                .body(body)
                .score(score)
                .build();
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getReviewByMember(Long memberId) {
        return reviewRepositoryImpl.findReviewsByMemberId(memberId);
    }



}

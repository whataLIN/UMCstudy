package umc.spring.repository.ReviewRepository;


import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.QMember;
import umc.spring.domain.QReview;
import umc.spring.domain.QStore;
import umc.spring.domain.Review;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QReview qReview = QReview.review;
    private final QStore qStore = QStore.store;
    private final QMember qMember = QMember.member;

    //해당멤버의 리뷰 모아보기
    @Override
    public List<Review> findReviewsByMemberId(Long memberId) {
        return jpaQueryFactory
                .selectFrom(qReview)
                .where(qReview.member.id.eq(memberId))
                .fetch();
    }

    //식당의 리뷰 모아보기
    @Override
    public List<Review> findReviewsByStoreId(Long storeId) {
        return jpaQueryFactory
                .selectFrom(qReview)
                .where(qReview.store.id.eq(storeId))
                .fetch();
    }


}

package umc.spring.repository.TermRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.domain.QMember;
import umc.spring.domain.QTerms;
import umc.spring.domain.Terms;
import umc.spring.domain.mapping.QMemberAgree;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TermRepositoryImpl implements TermRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMemberAgree qMemberAgree = QMemberAgree.memberAgree;
    private final QTerms qTerms = QTerms.terms;
    private final QMember qMember = QMember.member;

    //동의한 알림 설정 목록 불러오기
    @Override
    public List<Terms> findAllTermsforMember(Long memberId){
        return jpaQueryFactory
                .selectFrom(qTerms)
                .where(qMemberAgree.member.id.eq(memberId))
                .fetch();
    }
}

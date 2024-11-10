package umc.spring.repository.MemberRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Member;
import umc.spring.domain.QMember;


@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMember qMember = QMember.member;

    @Override
    public Member findMemberById(Long id) {
        return jpaQueryFactory
                .selectFrom(qMember)
                .where(qMember.id.eq(id))
                .fetchOne();
    }

    @Override
    public void updateMemberName(Long memberId, String newName){
        jpaQueryFactory.update(qMember)
                .set(qMember.name, newName)
                .where(qMember.id.eq(memberId))
                .execute();
    }
}

package umc.spring.repository.MissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.*;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.QMemberMission;

import java.util.List;

import static umc.spring.domain.enums.MissionStatus.CHALLENGING;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMemberMission qMemberMission = QMemberMission.memberMission;
    private final QMember qMember = QMember.member;
    private final QMission qMission = QMission.mission;
    private final QStore qStore = QStore.store;

    //진행중 미션
    @Override
    public List<Mission> findChallengingMission(Long memberId, Long missionId) {

        return jpaQueryFactory
                .selectFrom(qMission)
                .where(qMemberMission.member.id.eq(memberId)
                        .and(qMemberMission.status.eq(MissionStatus.CHALLENGING)))
                .fetch();
    }

    //완료된
    @Override
    public List<Mission> findCompletedMission(Long memberId, Long missionId) {

        return jpaQueryFactory
                .selectFrom(qMission)
                .where(qMemberMission.member.id.eq(memberId)
                        .and(qMemberMission.status.eq(MissionStatus.COMPLETED)))
                .fetch();
    }

    //지역에서 도전가능한 미션 찾기
    @Override
    public List<Mission> findAvailableMissionsByRegion(Long regionId){
        BooleanBuilder predicate = new BooleanBuilder();

        predicate.and(qMission.store.region.id.eq(regionId))
                .and(qMission.memberMissionList.any().status.eq(MissionStatus.DEFAULT));

        return jpaQueryFactory
                .selectFrom(qMission)
                .join(qMission.store,qStore)
                .where(predicate)
                .fetch();
    }
}

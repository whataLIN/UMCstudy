package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.repository.MissionRepository.MissionRepositoryImpl;


import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepositoryImpl missionRepositoryImpl;
    private final MissionRepository missionRepository;

    @Override
    public List<Mission> findCompletedMissionsByMember(Long memberId, Long missionId) {
        return missionRepositoryImpl.findCompletedMission(memberId,missionId);
    }

    @Override
    public List<Mission> findChallengingMissionsByMember(Long memberId, Long missionId) {
        return missionRepositoryImpl.findChallengingMission(memberId,missionId);
    }

    @Override
    public List<Mission> getAvailableMissionsByRegion(Long regionId) {
        return missionRepositoryImpl.findAvailableMissionsByRegion(regionId);
    }
}

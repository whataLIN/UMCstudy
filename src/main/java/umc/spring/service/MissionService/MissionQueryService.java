package umc.spring.service.MissionService;

import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;

import java.util.List;
import java.util.Optional;

public interface MissionQueryService {

    List<Mission> findCompletedMissionsByMember(Long missionId, Long memberId);
    List<Mission> findChallengingMissionsByMember(Long missionId, Long memberId);

    List<Mission> getAvailableMissionsByRegion(Long regionId);
}

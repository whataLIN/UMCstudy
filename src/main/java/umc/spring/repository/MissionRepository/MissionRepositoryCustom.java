package umc.spring.repository.MissionRepository;


import umc.spring.domain.Mission;

import java.util.List;

public interface MissionRepositoryCustom {

    List<Mission> findCompletedMission(Long memberId, Long missionId);
    List<Mission> findChallengingMission(Long memberId, Long missionId);

    List<Mission> findAvailableMissionsByRegion(Long regionId);
}

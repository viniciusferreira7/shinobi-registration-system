package dev.java10.ShinobiRegistrationSystem.Missions;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissionService {
    private final MissionRepository missionRepository;

    public MissionService(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    public MissionModel createMission(MissionModel mission){
        return this.missionRepository.save(mission);
    }
    public List<MissionModel> getMissions(){
        return this.missionRepository.findAll();
    }

    public MissionModel getMissionById(Long id){
        Optional<MissionModel> mission = this.missionRepository.findById(id);

        return mission.orElse(null);
    }

    public void deleteMissionById(Long id){
        this.missionRepository.deleteById(id);
    }

}

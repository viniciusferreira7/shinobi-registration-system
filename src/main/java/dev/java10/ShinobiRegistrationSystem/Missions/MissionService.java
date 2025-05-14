package dev.java10.ShinobiRegistrationSystem.Missions;

import dev.java10.ShinobiRegistrationSystem.Ninjas.NinjaModel;
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

    public MissionModel updateMission(Long id, MissionModel updatedMission){
        if(this.missionRepository.existsById(id)){
            updatedMission.setId(id);
            return this.missionRepository.save(updatedMission);
        }

        return null;
    }

    public void deleteMissionById(Long id){
        this.missionRepository.deleteById(id);
    }

}

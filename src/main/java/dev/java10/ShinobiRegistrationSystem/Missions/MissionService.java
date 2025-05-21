package dev.java10.ShinobiRegistrationSystem.Missions;

import dev.java10.ShinobiRegistrationSystem.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissionService {
    private final MissionRepository missionRepository;
    private final MissionMapper missionMapper;

    public MissionService(MissionRepository missionRepository, MissionMapper missionMapper) {
        this.missionRepository = missionRepository;
        this.missionMapper = missionMapper;
    }

    public MissionDTO createMission(MissionDTO missionDTO){
        MissionModel missionModel = this.missionMapper.map(missionDTO);
        MissionModel mission = this.missionRepository.save(missionModel);
        return this.missionMapper.map(mission);
    }
    public List<MissionDTO> getMissions(){
        List<MissionModel> missionsModel = this.missionRepository.findAll();

        return missionsModel.stream().map(this.missionMapper::map).toList();
    }

    public MissionDTO getMissionById(Long id){
        Optional<MissionModel> mission = this.missionRepository.findById(id);

        return mission.map(this.missionMapper::map).orElse(null);
    }

    public MissionDTO updateMission(Long id, MissionDTO updatedMission){
        Optional<MissionModel> mission = this.missionRepository.findById(id);

        if(mission.isPresent()){
            updatedMission.setId(id);
            MissionModel missionModel = this.missionMapper.map(updatedMission);
            return this.missionMapper.map(missionModel);
        }

        return null;
    }

    public void deleteMissionById(Long id){
        this.missionRepository.deleteById(id);
    }

}

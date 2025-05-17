package dev.java10.ShinobiRegistrationSystem.Missions;

public class MissionMapper {
    public MissionModel map(MissionDTO missionDTO){
        MissionModel missionModel = new MissionModel();
        missionModel.setId(missionDTO.getId());
        missionModel.setName(missionDTO.getName());
        missionModel.setDescription(missionDTO.getDescription());
        missionModel.setRank(missionDTO.getRank());
        missionModel.setNinjas(missionDTO.getNinjas());

        return missionModel;
    }

    public MissionDTO map(MissionModel missionModel){
        MissionDTO missionDTO = new MissionDTO();
        missionDTO.setId(missionModel.getId());
        missionDTO.setName(missionModel.getName());
        missionDTO.setDescription(missionModel.getDescription());
        missionDTO.setRank(missionModel.getRank());
        missionDTO.setNinjas(missionModel.getNinjas());

        return missionDTO;
    }
}

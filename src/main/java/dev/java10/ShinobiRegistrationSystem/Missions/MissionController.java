package dev.java10.ShinobiRegistrationSystem.Missions;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missions")
public class MissionController {
    private final MissionService missionService;

    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }

    @PostMapping
    public MissionModel createMission(@RequestBody MissionModel mission) {
        return this.missionService.createMission(mission);
    }

    @GetMapping
    public List<MissionModel> getMissions() {
        return this.missionService.getMissions();
    }

    @GetMapping("/{id}")
    public MissionModel getMissionById(@PathVariable Long id) {
        return this.missionService.getMissionById(id);
    }

    @PatchMapping("/{id}")
    public MissionModel updateMission(@PathVariable Long id, @RequestBody MissionModel data) {
        return this.missionService.updateMission(id, data);
    }

    @DeleteMapping("/{id}")
    public void deleteMission(@PathVariable Long id) {
        this.missionService.deleteMissionById(id);
    }
}
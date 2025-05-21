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
    public MissionDTO createMission(@RequestBody MissionDTO mission) {
        return this.missionService.createMission(mission);
    }

    @GetMapping
    public List<MissionDTO> getMissions() {
        return this.missionService.getMissions();
    }

    @GetMapping("/{id}")
    public MissionDTO getMissionById(@PathVariable Long id) {
        return this.missionService.getMissionById(id);
    }

    @PatchMapping("/{id}")
    public MissionDTO updateMission(@PathVariable Long id, @RequestBody MissionDTO data) {
        return this.missionService.updateMission(id, data);
    }

    @DeleteMapping("/{id}")
    public void deleteMission(@PathVariable Long id) {
        this.missionService.deleteMissionById(id);
    }
}
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
    public String createMission() {
        return "Created mission";
    }

    @GetMapping
    public List<MissionModel> getMissions() {
        return this.missionService.getMissions();
    }

    @GetMapping("/{id}")
    public String getMissionById() {
        return "Mission by id";
    }

    @PutMapping("/{id}")
    public String updateMission() {
        return "Mission updated";
    }

    @DeleteMapping("/{id}")
    public String deleteMission() {
        return "Mission deleted";
    }
}
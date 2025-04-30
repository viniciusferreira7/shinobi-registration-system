package dev.java10.ShinobiRegistrationSystem.Missions;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class MissionController {

    @PostMapping("/missions")
    public String createMission() {
        return "Created mission";
    }

    @GetMapping("/missions")
    public String getMissions() {
        return "Missions";
    }

    @GetMapping("/missions/{id}")
    public String getMissionById() {
        return "Mission by id";
    }

    @PatchMapping("/missions/{id}")
    public String updateMission() {
        return "Mission updated";
    }

    @DeleteMapping("/missions/{id}")
    public String deleteMission() {
        return "Mission deleted";
    }
}
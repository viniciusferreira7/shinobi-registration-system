package dev.java10.ShinobiRegistrationSystem.Missions;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missions")
public class MissionController {

    @PostMapping
    public String createMission() {
        return "Created mission";
    }

    @GetMapping
    public String getMissions() {
        return "Missions";
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
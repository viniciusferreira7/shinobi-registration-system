package dev.java10.ShinobiRegistrationSystem.Missions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Void> createMission(@RequestBody MissionDTO mission) {
        this.missionService.createMission(mission);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<MissionDTO>> getMissions() {
        return ResponseEntity.ok(this.missionService.getMissions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MissionDTO> getMissionById(@PathVariable Long id) {
        MissionDTO mission = this.missionService.getMissionById(id);

        if (mission == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(mission);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateMission(@PathVariable Long id, @RequestBody MissionDTO data) {
        MissionDTO existing = this.missionService.getMissionById(id);

        if (existing == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        this.missionService.updateMission(id, data);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMission(@PathVariable Long id) {
        MissionDTO existing = this.missionService.getMissionById(id);

        if (existing == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        this.missionService.deleteMissionById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
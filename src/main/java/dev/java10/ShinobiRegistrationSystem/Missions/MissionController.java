package dev.java10.ShinobiRegistrationSystem.Missions;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/missions")
public class MissionController {
    private final MissionService missionService;

    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }

    @Operation(
            summary = "Create a new mission",
            description = "Creates a new mission using the data provided in the request body."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Mission created successfully")
    })
    @PostMapping
    public ResponseEntity<Void> createMission(@RequestBody MissionDTO mission) {
        this.missionService.createMission(mission);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(
            summary = "Get all missions",
            description = "Returns a list of all missions registered in the system."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of missions retrieved successfully")
    })
    @GetMapping
    public ResponseEntity<List<MissionDTO>> getMissions() {
        return ResponseEntity.ok(this.missionService.getMissions());
    }

    @Operation(
            summary = "Get mission by ID",
            description = "Retrieves the details of a specific mission by its ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mission retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Mission not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<MissionDTO> getMissionById(@PathVariable Long id) {
        MissionDTO mission = this.missionService.getMissionById(id);

        if (mission == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(mission);
    }

    @Operation(
            summary = "Update mission",
            description = "Partially updates a mission based on the provided ID and request body data."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Mission updated successfully"),
            @ApiResponse(responseCode = "404", description = "Mission not found")
    })
    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateMission(@PathVariable Long id, @RequestBody MissionDTO data) {
        MissionDTO existing = this.missionService.getMissionById(id);

        if (existing == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        this.missionService.updateMission(id, data);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(
            summary = "Delete mission",
            description = "Deletes a mission identified by its ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Mission deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Mission not found")
    })
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
package dev.java10.ShinobiRegistrationSystem.Missions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/missions")
public class MissionControllerUi {
    private final MissionService missionService;

    public MissionControllerUi(MissionService missionService) {
        this.missionService = missionService;
    }

    @GetMapping
    private String getMissions(Model model){
        List<MissionDTO> missions = this.missionService.getMissions();
        model.addAttribute("missions", missions);

        return "getMissions";
    }

    @GetMapping("/{id}")
    public String getMissionById(@PathVariable Long id, Model model) {
        MissionDTO mission = this.missionService.getMissionById(id);

        if (mission == null) {
            return "redirect:/missions";
        }

        model.addAttribute("mission", mission);
        return "getMission";
    }

    @PostMapping("/delete/{id}")
    public String deleteMission(@PathVariable Long id) {
        MissionDTO existing = this.missionService.getMissionById(id);

        this.missionService.deleteMissionById(id);
        return "redirect:/missions";
    }
}

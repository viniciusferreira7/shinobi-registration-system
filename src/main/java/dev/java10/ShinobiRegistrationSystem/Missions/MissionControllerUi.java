package dev.java10.ShinobiRegistrationSystem.Missions;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}

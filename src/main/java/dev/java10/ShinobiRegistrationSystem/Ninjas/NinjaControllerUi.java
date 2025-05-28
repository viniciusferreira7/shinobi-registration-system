package dev.java10.ShinobiRegistrationSystem.Ninjas;

import dev.java10.ShinobiRegistrationSystem.Missions.MissionDTO;
import dev.java10.ShinobiRegistrationSystem.Missions.MissionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ninjas")
public class NinjaControllerUi {
    private final NinjaService ninjaService;
    private final MissionService missionService;


    public NinjaControllerUi(NinjaService ninjaService, MissionService missionService) {
        this.ninjaService = ninjaService;
        this.missionService = missionService;
    }

    @GetMapping
    private String getNinjas(Model model){
        List<NinjaDTO> ninjas = this.ninjaService.getNinjas();
        model.addAttribute("ninjas", ninjas);
        return "getNinjas";
    }

    @GetMapping("/{id}")
    public String getNinjaById(@PathVariable Long id, Model model){
        NinjaDTO ninja = this.ninjaService.getNinjaById(id);

     if(ninja == null){
            return "redirect:/ninjas";
        }

        model.addAttribute("ninja", ninja);
        return "getNinja";
    }

    @GetMapping("/update/{id}")
    public String getNinjaByIdToUpdate(@PathVariable Long id, Model model){
        NinjaDTO ninja = this.ninjaService.getNinjaById(id);

        List<MissionDTO> missions = this.missionService.getMissions();
        model.addAttribute("missions", missions);


     if(ninja == null){
            return "redirect:/ninjas";
        }

        model.addAttribute("ninja", ninja);
        return "updateNinja";
    }

    @PostMapping("/update/{id}")
    public String updateNinja(@PathVariable Long id, @ModelAttribute NinjaDTO data){
        if(this.ninjaService.getNinjaById(id) == null){
            return "redirect:/ninjas";
        }

        //TODO: Descobrir por que não está atualizando os campos
        //TODO: Adicionar a rota de atualizar a missão tambem

        this.ninjaService.updateNinja(id, data);

        return "redirect:/ninjas";
    }


    @PostMapping("/delete/{id}")
    public String deleteNinja(@PathVariable Long id){
        this.ninjaService.deleteNinjaById(id);
        return "redirect:/ninjas";
    }
}

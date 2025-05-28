package dev.java10.ShinobiRegistrationSystem.Ninjas;

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

    public NinjaControllerUi(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping
    private String getNinjas(Model model){
        List<NinjaDTO> ninjas = this.ninjaService.getNinjas();
        model.addAttribute("ninjas", ninjas);
        return "getNinjas";
    }

    @PostMapping("/delete/{id}")
    public String deleteNinja(@PathVariable Long id){
        if(this.ninjaService.getNinjaById(id) == null){
            return "redirect:/ninjas";
        }

        this.ninjaService.deleteNinjaById(id);
        return "redirect:/ninjas";
    }
}

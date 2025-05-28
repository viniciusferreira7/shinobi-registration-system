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

    @GetMapping("/{id}")
    public String getNinjaById(@PathVariable Long id, Model model){
        NinjaDTO ninja = this.ninjaService.getNinjaById(id);

     if(ninja == null){
            return "redirect:/ninjas";
        }

        model.addAttribute("ninja", ninja);
        return "getNinja";
    }

    @PostMapping("/delete/{id}")
    public String deleteNinja(@PathVariable Long id){
        this.ninjaService.deleteNinjaById(id);
        return "redirect:/ninjas";
    }
}

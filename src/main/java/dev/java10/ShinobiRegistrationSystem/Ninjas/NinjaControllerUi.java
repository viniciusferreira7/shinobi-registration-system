package dev.java10.ShinobiRegistrationSystem.Ninjas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}

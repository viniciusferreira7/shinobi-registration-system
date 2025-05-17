package dev.java10.ShinobiRegistrationSystem.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

   @PostMapping
   public NinjaDTO createNinja(@RequestBody NinjaDTO ninja){
       return this.ninjaService.createNinja(ninja);
   }

   @GetMapping
   public List<NinjaDTO> getNinjas(){
       return this.ninjaService.getNinjas();
   }

   @GetMapping("/{id}")
   public NinjaDTO getNinjaById(@PathVariable Long id){
       return this.ninjaService.getNinjaById(id);
   }

   @PatchMapping("/{id}")
   public NinjaDTO updateNinja(@PathVariable Long id, @RequestBody NinjaDTO data){
       return this.ninjaService.updateNinja(id, data);
   }

   @DeleteMapping("/{id}")
   public void deleteNinja(@PathVariable Long id){
        this.ninjaService.deleteNinjaById(id);
   }
}

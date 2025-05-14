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
   public NinjaModel createNinja(@RequestBody NinjaModel ninja){
       return this.ninjaService.createNinja(ninja);
   }

   @GetMapping
   public List<NinjaModel> getNinjas(){
       return this.ninjaService.getNinjas();
   }

   @GetMapping("/{id}")
   public NinjaModel getNinjaById(@PathVariable Long id){
       return this.ninjaService.getNinjaById(id);
   }

   @PatchMapping("/{id}")
   public NinjaModel updateNinja(@PathVariable Long id, @RequestBody NinjaModel data){
       return this.ninjaService.updateNinja(id, data);
   }

   @DeleteMapping("/{id}")
   public void deleteNinja(@PathVariable Long id){
        this.ninjaService.deleteNinjaById(id);
   }
}

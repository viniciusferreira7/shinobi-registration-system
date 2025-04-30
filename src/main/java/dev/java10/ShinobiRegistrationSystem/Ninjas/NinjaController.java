package dev.java10.ShinobiRegistrationSystem.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

   @PostMapping("/ninjas")
   public String createNinja(){
       return "Created ninja";
   }

   @GetMapping("/ninjas")
   public String getNinjas(){
       return "Ninjas";
   }

   @GetMapping("/ninjas/{id}")
   public String getNinjaById(){
       return "Ninja by id";
   }

   @PatchMapping("/ninjas/{id}")
   public String updateNinja(){
       return "Ninja updated";
   }

   @DeleteMapping("/ninjas/{id}")
   public String deleteNinja(){
       return "Ninja deleted";
   }
}

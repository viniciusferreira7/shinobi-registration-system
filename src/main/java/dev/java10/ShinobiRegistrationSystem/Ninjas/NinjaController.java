package dev.java10.ShinobiRegistrationSystem.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

   @PostMapping
   public String createNinja(){
       return "Created ninja";
   }

   @GetMapping
   public String getNinjas(){
       return "Ninjas";
   }

   @GetMapping("/{id}")
   public String getNinjaById(){
       return "Ninja by id";
   }

   @PutMapping("/{id}")
   public String updateNinja(){
       return "Ninja updated";
   }

   @DeleteMapping("/{id}")
   public String deleteNinja(){
       return "Ninja deleted";
   }
}

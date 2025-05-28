package dev.java10.ShinobiRegistrationSystem.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

   @PostMapping
   public ResponseEntity<Void> createNinja(@RequestBody NinjaDTO ninja){
        this.ninjaService.createNinja(ninja);

       return ResponseEntity.status(HttpStatus.CREATED).build();
   }

   @GetMapping
   public ResponseEntity<List<NinjaDTO>> getNinjas(){
       return ResponseEntity.status(HttpStatus.OK).body(this.ninjaService.getNinjas());
   }

   @GetMapping("/{id}")
   public ResponseEntity<NinjaDTO> getNinjaById(@PathVariable Long id){
       if(this.ninjaService.getNinjaById(id) == null){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }

       return ResponseEntity.status(HttpStatus.OK).body(this.ninjaService.getNinjaById(id));
   }

   @PatchMapping("/{id}")
   public ResponseEntity<Void> updateNinja(@PathVariable Long id, @RequestBody NinjaDTO data){
        if(this.ninjaService.getNinjaById(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        this.ninjaService.updateNinja(id, data);

       return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteNinja(@PathVariable Long id){
       if(this.ninjaService.getNinjaById(id) == null){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }

        this.ninjaService.deleteNinjaById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
   }
}

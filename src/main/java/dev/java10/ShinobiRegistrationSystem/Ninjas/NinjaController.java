package dev.java10.ShinobiRegistrationSystem.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @Operation(
            summary = "Create a new ninja",
            description = "Registers a new ninja using the data provided in the request body."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja created successfully")
    })
    @PostMapping
    public ResponseEntity<Void> createNinja(@RequestBody NinjaDTO ninja){
        this.ninjaService.createNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(
            summary = "Get all ninjas",
            description = "Returns a list of all ninjas registered in the system."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of ninjas retrieved successfully")
    })
    @GetMapping
    public ResponseEntity<List<NinjaDTO>> getNinjas(){
        return ResponseEntity.status(HttpStatus.OK).body(this.ninjaService.getNinjas());
    }

    @Operation(
            summary = "Get ninja by ID",
            description = "Retrieves the details of a specific ninja using their unique ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Ninja not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<NinjaDTO> getNinjaById(@PathVariable Long id){
        if(this.ninjaService.getNinjaById(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(this.ninjaService.getNinjaById(id));
    }

    @Operation(
            summary = "Update ninja",
            description = "Partially updates the information of an existing ninja using their ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Ninja updated successfully"),
            @ApiResponse(responseCode = "404", description = "Ninja not found")
    })
    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateNinja(@PathVariable Long id, @RequestBody NinjaDTO data){
        if(this.ninjaService.getNinjaById(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        this.ninjaService.updateNinja(id, data);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(
            summary = "Delete ninja",
            description = "Deletes a ninja from the system using their unique ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Ninja deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Ninja not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNinja(@PathVariable Long id){
        if(this.ninjaService.getNinjaById(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        this.ninjaService.deleteNinjaById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
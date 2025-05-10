package dev.java10.ShinobiRegistrationSystem.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public NinjaModel createNinja(NinjaModel ninja){
        return this.ninjaRepository.save(ninja);
    }

    public List<NinjaModel> getNinjas(){
        return this.ninjaRepository.findAll();
    }

    public NinjaModel getNinjaById(Long id){
        Optional<NinjaModel> ninja = this.ninjaRepository.findById(id);

        return ninja.orElse(null);
    }
}

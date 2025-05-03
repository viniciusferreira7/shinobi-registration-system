package dev.java10.ShinobiRegistrationSystem.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<NinjaModel> getNinjas(){
        return this.ninjaRepository.findAll();
    }
}

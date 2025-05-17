package dev.java10.ShinobiRegistrationSystem.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public NinjaDTO createNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = this.ninjaMapper.map(ninjaDTO);

        NinjaModel ninjaModel = this.ninjaRepository.save(ninja);

        return this.ninjaMapper.map(ninjaModel);

    }

    public List<NinjaDTO> getNinjas(){
        List<NinjaModel> ninjasModel = this.ninjaRepository.findAll();

        return ninjasModel.stream().map(this.ninjaMapper::map).toList();
    }

    public NinjaDTO getNinjaById(Long id){
        Optional<NinjaModel> ninja = this.ninjaRepository.findById(id);

        return ninja.map(this.ninjaMapper::map).orElse(null);

    }

    public NinjaDTO updateNinja(Long id, NinjaDTO updatedNinja){
        if(this.ninjaRepository.existsById(id)){
            updatedNinja.setId(id);

            NinjaModel ninjaModel = this.ninjaMapper.map(updatedNinja);

           return this.ninjaMapper.map(ninjaModel);
        }

        return null;
    }

    public void deleteNinjaById(Long id){
        this.ninjaRepository.deleteById(id);
    }


}

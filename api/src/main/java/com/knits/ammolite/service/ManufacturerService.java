package com.knits.ammolite.service;


import com.knits.ammolite.model.asset.Manufacturer;
import com.knits.ammolite.repository.ManufacturerRepository;
import com.knits.ammolite.service.dto.ManufacturerDto;
import com.knits.ammolite.service.mapper.ManufacturerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ManufacturerService {
    private final ManufacturerRepository repository;
    private final ManufacturerMapper mapper;

    public ManufacturerDto save(String name){
        Manufacturer manufacturer = new Manufacturer();

        if(repository.findByName(name).isEmpty()){
            manufacturer.setName(name);
            repository.save(manufacturer);
        }else{
            manufacturer = repository.findByName(name).get();
        }
        return mapper.toDto(manufacturer);

    }

}

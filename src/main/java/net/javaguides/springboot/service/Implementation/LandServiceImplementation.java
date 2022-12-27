package net.javaguides.springboot.service.Implementation;

import lombok.RequiredArgsConstructor;
import net.javaguides.springboot.dto.IrrigationConfigurationDto;
import net.javaguides.springboot.dto.LandDto;
import net.javaguides.springboot.entity.Land;
import net.javaguides.springboot.exception.BadRequestException;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.repository.LandRepository;
import net.javaguides.springboot.service.IrrigationConfigurationService;
import net.javaguides.springboot.service.LandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LandServiceImplementation implements LandService {

    private final LandRepository landRepository;
    private final IrrigationConfigurationService irrigationConfigurationService;
    private final ModelMapper mapper;

    @Override
    public Land add(LandDto model) {
        Optional<Land> land = landRepository.findBySerialNumber(model.getSerialNumber());

        if(land.isPresent()){
            return land.get();
        }

        Land entity = mapper.map(model, Land.class);
        entity.setDateCreated(new Date());
        landRepository.save(entity);
        return entity;
    }

    @Override
    public Land update(LandDto model, Long id) {
        Optional<Land> land = landRepository.findById(id);

        if(!land.isPresent()){
            throw new BadRequestException("Land not found!");
        }
        Land entity = land.get();
        entity.setSerialNumber(model.getSerialNumber());
        entity.setLandPurpose(model.getLandPurpose());
        entity.setArea(model.getArea());
        entity.setSoilType(model.getSoilType());

        entity.setDateModified(new Date());
        landRepository.save(entity);
        return entity;
    }

    @Override
    public Land getById(Long id) {
        Optional<Land> land = landRepository.findById(id);
        if(!land.isPresent()){
            throw new ResourceNotFoundException("Land not found");
        }
        return land.get();
    }

    @Override
    public List<Land> getAll() {
        return landRepository.findAll();
    }
    @Override
    public Land configure(IrrigationConfigurationDto model, Long id) {
        return null;
    }




}

package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.IrrigationConfigurationDto;
import net.javaguides.springboot.dto.LandDto;
import net.javaguides.springboot.entity.Land;

import java.util.List;

public interface LandService {
    Land add(LandDto model);

    Land update(LandDto model,Long id);

    Land configure(IrrigationConfigurationDto model, Long id);

    Land getById(Long id);

    List<Land> getAll();
}

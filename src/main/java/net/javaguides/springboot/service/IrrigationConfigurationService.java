package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.IrrigationConfigurationDto;
import net.javaguides.springboot.entity.IrrigationConfiguration;
import net.javaguides.springboot.entity.Land;

import java.util.List;

public interface IrrigationConfigurationService {
    IrrigationConfiguration configureLand(IrrigationConfigurationDto model, Land land);

    List<IrrigationConfiguration> getConfigurationSchedules();

    IrrigationConfiguration updateNextTimeSlot(IrrigationConfiguration configuration);
}

package net.javaguides.springboot.service.Implementation;

import lombok.RequiredArgsConstructor;
import lombok.var;
import net.javaguides.springboot.dto.IrrigationConfigurationDto;
import net.javaguides.springboot.entity.IrrigationConfiguration;
import net.javaguides.springboot.entity.Land;
import net.javaguides.springboot.exception.BadRequestException;
import net.javaguides.springboot.repository.IrrigationConfigurationRepository;
import net.javaguides.springboot.service.IrrigationConfigurationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IrrigationConfigurationServiceImplementation implements IrrigationConfigurationService {

    private final IrrigationConfigurationRepository repository;
    private final ModelMapper modelMapper;


    @Override
    public IrrigationConfiguration configureLand(IrrigationConfigurationDto model, Land land) {
        if(land==null){
            throw new BadRequestException("Land not found");
        }
        IrrigationConfiguration device = modelMapper.map(model, IrrigationConfiguration.class);

        if(model.getTimeSlot().getTime() < new Date().getTime()){
            throw new BadRequestException("Time slot past current time");
        }

        device.setLand(land);
        device.setNextTimeSlot(model.getTimeSlot());
        device.setDateCreated(new Date());

        repository.save(device);
        return device;
    }

    @Override
    public List<IrrigationConfiguration> getConfigurationSchedules() {
        return repository.getByNextTimeSlot(new Date());
    }

    @Override
    public IrrigationConfiguration updateNextTimeSlot(IrrigationConfiguration configuration) {
        var calendar = Calendar.getInstance();
        calendar.setTime(configuration.getNextTimeSlot());
        calendar.add(Calendar.HOUR_OF_DAY, configuration.getIrrigationIntervalInDays());
        var timeSlot =  calendar.getTime();
        configuration.setNextTimeSlot(timeSlot);
        configuration.setDateModified(new Date());
        repository.save(configuration);
        return configuration;
    }
}

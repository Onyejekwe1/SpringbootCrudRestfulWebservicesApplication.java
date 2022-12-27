package net.javaguides.springboot.service.Implementation;

import lombok.RequiredArgsConstructor;
import lombok.var;
import net.javaguides.springboot.dto.IrrigationConfigurationDto;
import net.javaguides.springboot.entity.IrrigationConfiguration;
import net.javaguides.springboot.entity.IrrigationScheduleLog;
import net.javaguides.springboot.entity.Land;
import net.javaguides.springboot.entity.enums.IrrigationOperationStatus;
import net.javaguides.springboot.exception.BadRequestException;
import net.javaguides.springboot.repository.IrrigationConfigurationRepository;
import net.javaguides.springboot.repository.IrrigationScheduleLogRepository;
import net.javaguides.springboot.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IrrigationScheduleLogServiceImplementation implements IrrigationScheduleLogService {

    private final IrrigationScheduleLogRepository repository;
    private final IotAlertingService iotAlertingService;
    private final IotEmulatorService iotEmulatorService;

    @Value("${number.of.sensor.retries}")
    private int numberOfSensorRetries;

    @Override
    public IrrigationScheduleLog schedule(IrrigationConfiguration device) {
        IrrigationScheduleLog schedule = new IrrigationScheduleLog();
        schedule.setDateCreated(new Date());
        schedule.setLitresOfWater(device.getLitresOfWater());
        schedule.setDurationInMinutes(device.getDurationInMinutes());
        schedule.setIrrigationConfiguration(device);
        repository.save(schedule);
        return schedule;
    }

    @Override
    public IrrigationScheduleLog activate(IrrigationScheduleLog schedule) {
        var status = iotEmulatorService.sendIrrigationSchedule(schedule);
        var retries = 0;
        while(status == IrrigationOperationStatus.UNAVAILABLE && retries < numberOfSensorRetries){
            status = iotEmulatorService.sendIrrigationSchedule(schedule);
            retries++;
        }

        if(status == IrrigationOperationStatus.UNAVAILABLE){
            iotAlertingService.sendIotDeviceNotAvailableAlert(schedule.getIrrigationConfiguration().getDeviceName());
        }
        schedule.setStatus(status);
        repository.save(schedule);
        return schedule;
    }
    }

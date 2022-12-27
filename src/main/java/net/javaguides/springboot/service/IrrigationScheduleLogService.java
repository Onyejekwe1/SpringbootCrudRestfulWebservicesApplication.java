package net.javaguides.springboot.service;

import net.javaguides.springboot.entity.IrrigationConfiguration;
import net.javaguides.springboot.entity.IrrigationScheduleLog;

public interface IrrigationScheduleLogService {
    IrrigationScheduleLog schedule(IrrigationConfiguration device);
    IrrigationScheduleLog activate(IrrigationScheduleLog schedule);
}
